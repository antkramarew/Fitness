package fitness.service.business;

import fitness.domain.dto.ProductLineDTO;
import fitness.domain.utils.ProductLineOperations;
import fitness.persistence.entity.ProductLineEntity;
import fitness.persistence.repository.ProductLineRepository;
import fitness.service.exeption.ResourceNotFoundException;
import fitness.service.validator.ValidationManager;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by toxa on 7/19/2017.
 */
@Service
public class ProductLineBusinessService implements ProductLineService {

    @Autowired
    private ProductLineRepository productLineRepository;
    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private ValidationManager validationManager;

    @Override
    public ProductLineDTO createProductLine(ProductLineDTO lineDTO) {
        validationManager.validateAndThrow(lineDTO);
        ProductLineEntity lineEntity = mapper.map(lineDTO, ProductLineEntity.class);
        ProductLineEntity savedLine = productLineRepository.save(lineEntity);
        return mapper.map(savedLine, ProductLineDTO.class).apply(ProductLineOperations.COUNT_TOTAL_NUTRITION_FACTS);
    }

    @Override
    public void deleteProductLine(Long lineId) {
        this.productLineRepository.delete(lineId);
    }

    @Override
    public ProductLineDTO getProductLine(Long id) {
        return this.productLineRepository.findProductLineById(id)
                .map(productLineEntity -> mapper.map(productLineEntity, ProductLineDTO.class))
                .map(productLineDTO -> productLineDTO.apply(ProductLineOperations.COUNT_TOTAL_NUTRITION_FACTS))
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
