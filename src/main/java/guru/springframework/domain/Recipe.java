package guru.springframework.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means this will use the PK column from the DB
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    // todo add
//     private Difficulty difficulty;

    @Lob // This annotation means that specifies that the database should store the property as Large Object.
    private Byte[] image; // https://www.baeldung.com/hibernate-lob

    /*ORDINAL type means that enum values will be saved as Integer in our DB
    * STRING type means that enum values will be saved as String in our DB
    *
    * 1      2      3 for ORDINAL
    * EASY Medium Hard
    * now if we change the table after it is created, for ex:
    * 1      2     3     4
    * EASY medium bitHard hard
    * hard changed to 4  but we saved 3 , this will be a bug in our DB
    *
    * How ever if we persist them as String, this issue can avoided
    * */
    @Enumerated(value=EnumType.STRING)
    private Difficulty difficulty;

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

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

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }
}
