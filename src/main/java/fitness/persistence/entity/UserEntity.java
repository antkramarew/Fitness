package fitness.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by toxa on 22.08.2017.
 */

@Entity(name = "user")
public class UserEntity {
    public static final String FK_USER_ID = "fk_user_id";
    @Id
    @GeneratedValue
    private Long id;

    private String login;
    private String password;

    @OneToMany
    @JoinColumn(name = FK_USER_ID)
    private List<ProductEntity> products;
    @OneToMany
    @JoinColumn(name = FK_USER_ID)
    private List<ProductLineEntity> lines;
    @OneToMany
    @JoinColumn(name = FK_USER_ID)
    private List<MealEntity> meals;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public List<ProductLineEntity> getLines() {
        return lines;
    }

    public void setLines(List<ProductLineEntity> lines) {
        this.lines = lines;
    }

    public List<MealEntity> getMeals() {
        return meals;
    }

    public void setMeals(List<MealEntity> meals) {
        this.meals = meals;
    }
}
