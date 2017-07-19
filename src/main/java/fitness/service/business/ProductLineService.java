package fitness.service.business;

import fitness.domain.dto.ProductDTO;
import fitness.domain.dto.ProductLineDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Anton_Kramarev on 6/18/2017.
 */
public interface ProductLineService {

    ProductLineDTO createProductLine(ProductLineDTO lineDTO);

    void deleteProductLine(Long lineId);

    ProductLineDTO getProductLine(Long lineId);
}
