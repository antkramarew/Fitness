package fitness;

import fitness.domain.dto.types.*;
import fitness.persistence.entity.ProductEntity;
import fitness.persistence.repository.ProductRepository;
import fitness.persistence.repository.spring.ExtendedJpaRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

import static java.util.Arrays.asList;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = ExtendedJpaRepository.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "dozerMapper")
    public DozerBeanMapper dozerMapper() throws IOException {
        DozerBeanMapper mapper = new DozerBeanMapper(asList("dozer/product-mappings.xml"));
        return mapper;
    }

    @Bean
    public CommandLineRunner productDemo(ProductRepository productRepository) {
        return args -> {
            productRepository.save(initProduct());
        };
    }

    private ProductEntity initProduct() {
        ProductEntity product = new ProductEntity();
        product.setName("Test product");
        product.setMeasure(Measure.WEIGHT);
        product.setNutritionFacts(new NutritionFacts(Calories.of(1), Fat.of(1), Carbohydrate.of(1), Protein.of(1) ));
        return product;
    }


}