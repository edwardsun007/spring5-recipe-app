package guru.springframework.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created By esun
 * Date: 6/12/22
 */
@Entity
public class UnitMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // means this will use the PK column from the DB
    private long id;
    private String description; // unit of measurement description

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
