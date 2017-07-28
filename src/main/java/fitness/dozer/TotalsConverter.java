package fitness.dozer;

import fitness.domain.dto.ProductDTO;
import fitness.domain.dto.types.Calories;
import fitness.domain.dto.types.Carbohydrate;
import fitness.domain.dto.types.Fat;
import fitness.domain.dto.types.Protein;
import fitness.rest.model.Totals;
import org.dozer.DozerConverter;

import java.util.Objects;

/**
 * Created by Anton_Kramarev on 7/24/2017.
 */
public class TotalsConverter extends DozerConverter<Totals, ProductDTO> {

    public TotalsConverter() {
        super(Totals.class, ProductDTO.class);
    }

    @Override
    public ProductDTO convertTo(Totals source, ProductDTO destination) {
        if (Objects.isNull(source)) {
            return destination;
        }
        destination.setProtein(Protein.of(source.getProtein()));
        destination.setCalories(Calories.of((source.getCalories())));
        destination.setFat(Fat.of(source.getFat()));
        destination.setCarbohydrate(Carbohydrate.of(source.getCarbohydrate()));
        return destination;
    }

    @Override
    public Totals convertFrom(ProductDTO source, Totals destination) {
        if (Objects.isNull(source)) {
            return null;
        }
        destination = new Totals();
        destination.setCarbohydrate(Carbohydrate.of(source.getCarbohydrate()).toInteger());
        destination.setCalories(Calories.of(source.getCalories()).toInteger());
        destination.setFat(Fat.of(source.getFat()).toInteger());
        destination.setProtein(Protein.of(source.getProtein()).toInteger());
        return destination;
    }
}
