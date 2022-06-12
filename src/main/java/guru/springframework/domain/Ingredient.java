package guru.springframework.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *  Created By
 *  Date:
 * */
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means this will use the PK column from the DB
    private Long id;

    private String description;
    private BigDecimal amount;

    // means which recipe this ingredient belong to
    @ManyToOne
    private Recipe recipe; // No cascade here because deletion of ingredient should not delete recipe

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
