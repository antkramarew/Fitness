package fitness.persistence.entity;

import fitness.domain.dto.types.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Anton_Kramarev on 6/16/2017.
 */
@Entity(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Measure measure;
    private Protein protein;
    private Fat fat;
    private Carbohydrate carbohydrate;
    private Calories calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    public Carbohydrate getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Carbohydrate carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public Calories getCalories() {
        return calories;
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(name, that.name) &&
                measure == that.measure &&
                Objects.equals(protein, that.protein) &&
                Objects.equals(fat, that.fat) &&
                Objects.equals(carbohydrate, that.carbohydrate) &&
                Objects.equals(calories, that.calories);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, measure, protein, fat, carbohydrate, calories);
    }
}
