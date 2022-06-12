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

    @OneToOne
    private UnitMeasure uom;
    /*
    This is one-direction one to one here: An Ingredient has its own unit of measurement
    But no unit of measure belong to any ingredient thats why UnitMeasure class doesn't have Ingredient property
    * */

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

    public UnitMeasure getUom() {
        return uom;
    }

    public void setUom(UnitMeasure uom) {
        this.uom = uom;
    }
}
