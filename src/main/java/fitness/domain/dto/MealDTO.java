package fitness.domain.dto;

import fitness.domain.dto.types.MealItems;

import java.util.List;

/**
 * Created by Anton_Kramarev on 7/20/2017.
 */
public class MealDTO {

    private Long id;
    private String name;

    private List<ProductLineDTO> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealItems getItems() {
        return MealItems.of(items);
    }

    public void setItems(List<ProductLineDTO> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
