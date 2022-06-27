package guru.springframework.dojoModels;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created By esun
 * Date: 6/26/22
 */
@Entity
@Table(name="books") // the name is the table name in DB
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 200, message = "title must be between 5 and 200 characters") // alidates that the annotated property value has a size between the attributes min and max; can be applied to String, Collection, Map, and array properties.
    private String title;
    // title is a string that needs to be between 5 and 200 characters

    @Size(min = 5, max = 200, message = "description must be between 5 and 200 characters")
    private String description;

    @Size(min = 3, max = 40, message = "language must be between 3 and 40 characters")
    private String language;

    @Min(100)
    private Integer numOfPages;

    @Column(updatable = false) // Hibernate cannot update this field, only writing native SQL statement can update it
    private Date createdAt;
    private Date updatedAt;

    public Book(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Book(String title, String description, String language, Integer numOfPages) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.numOfPages = numOfPages;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

/* JPA lifecycle events
before persist is called for a new entity – @PrePersist
after persist is called for a new entity – @PostPersist
before an entity is removed – @PreRemove
after an entity has been deleted – @PostRemove
before the update operation – @PreUpdate
after an entity is updated – @PostUpdate
after an entity has been loaded – @PostLoad
    * */
}
