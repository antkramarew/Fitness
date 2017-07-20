package fitness.domain.dto.types;

import com.google.common.collect.ForwardingList;
import fitness.domain.dto.ProductLineDTO;

import java.util.List;

/**
 * Created by Anton_Kramarev on 7/20/2017.
 */
public class MealItems extends ForwardingList<ProductLineDTO> {

    private List<ProductLineDTO> delegate;

    public static MealItems of(List<ProductLineDTO> delegate) {
        return new MealItems(delegate);
    }

    @Override
    protected List<ProductLineDTO> delegate() {
        return delegate;
    }

    private MealItems(List<ProductLineDTO> delegate) {
        this.delegate = delegate;
    }

    public Protein getProtein() {
       return Protein.of(delegate.stream()
               .map(p -> p.getProtein().toInteger())
               .reduce(0, Integer::sum));
    }

    public Calories getCalories() {
        return Calories.of(delegate.stream()
                .map(p -> p.getCalories().toInteger())
                .reduce(0, Integer::sum));
    }

    public Fat getFat () {
        return Fat.of(delegate.stream()
                .map(p -> p.getFat().toInteger())
                .reduce(0, Integer::sum));
    }

    public Carbohydrate getCarbohydrate() {
        return Carbohydrate.of(delegate.stream()
                .map(p -> p.getCarbohydrate().toInteger())
                .reduce(0, Integer::sum));
    }
}
