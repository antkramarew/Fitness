package fitness;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger1.annotations.EnableSwagger;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;

import static java.util.Arrays.asList;

@SpringBootApplication
@EnableSwagger
@EnableSwagger2
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "dozerMapper")
    public DozerBeanMapper dozerMapper() throws IOException {
        DozerBeanMapper mapper = new DozerBeanMapper(asList("dozer/product-mappings.xml"));
        return mapper;
    }


}