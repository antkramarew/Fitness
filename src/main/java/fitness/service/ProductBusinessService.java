package fitness.service;

import fitness.domain.dto.ProductDTO;
import fitness.domain.dto.ProductLineDTO;
import fitness.domain.utils.ProductLineOperations;
import fitness.persistance.repository.ProductLineRepository;
import fitness.service.exeption.ProductLineNotFoundException;
import fitness.service.exeption.ProductNotFoundException;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import fitness.persistance.entity.ProductEntity;
import fitness.persistance.repository.ProductRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by Anton_Kramarev on 6/18/2017.
 */

@Service
public class ProductBusinessService implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductLineRepository productLineRepository;

    @Autowired
    private DozerBeanMapper mapper;


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = mapper.map(productDTO, ProductEntity.class);
        ProductEntity savedEntity = productRepository.save(productEntity);
        return mapper.map(savedEntity, ProductDTO.class);
    }

    @Override
    public ProductDTO getProduct(Long productId) {
        return this.productRepository.findProductById(productId)
                .map(productEntity -> mapper.map(productEntity, ProductDTO.class))
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @Override
    @Transactional
    public void deleteProduct(Long productId) {
        Optional<ProductEntity> productToRemove = this.productRepository.findProductById(productId);
        if (productToRemove.isPresent()) {
            this.productRepository.delete(productId);
        } else {
            throw new ProductNotFoundException(productId);
        }
    }

    @Override
    public Page<ProductDTO> getProductByName(String name, Pageable pageable) {
        Page<ProductEntity> products = this.productRepository
                .findProductByNameStartingWith(name, pageable);
        return products.map(productEntity -> mapper.map(productEntity, ProductDTO.class));
    }

    @Override
    public ProductLineDTO getProductLine(Long id) {
         return this.productLineRepository.findProductLineById(id)
                 .map(productLineEntity -> mapper.map(productLineEntity, ProductLineDTO.class))
                 .map(productLineDTO -> productLineDTO.apply(ProductLineOperations.COUNT_TOTAL_NUTRITION_FACTS))
                 .orElseThrow(() -> new ProductLineNotFoundException(id));
    }
}
