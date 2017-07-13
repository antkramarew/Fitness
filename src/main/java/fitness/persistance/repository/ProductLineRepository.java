package fitness.persistance.repository;

import fitness.persistance.entity.ProductLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Anton_Kramarev on 6/23/2017.
 */
public interface ProductLineRepository extends JpaRepository<ProductLineEntity, Long> {

    Optional<ProductLineEntity> findProductLineById(Long id);
}
