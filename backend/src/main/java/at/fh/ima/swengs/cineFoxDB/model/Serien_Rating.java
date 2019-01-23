package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")

public class Serien_Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer rating;

    @ManyToOne
    private Serie serie;


    @ManyToOne
    private User user;


    @Version
    @JsonIgnore
    private long version;

    public Serien_Rating() {
    }

    public Serien_Rating(Integer rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public at.fh.ima.swengs.cineFoxDB.model.Serie getSerie() {
        return serie;
    }

    public void setSerie(at.fh.ima.swengs.cineFoxDB.model.Serie serie) {
        this.serie = serie;
    }

    public at.fh.ima.swengs.cineFoxDB.model.User getUser() {
        return user;
    }

    public void setUser(at.fh.ima.swengs.cineFoxDB.model.User user) {
        this.user = user;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Serien_Rating{" +
                "id=" + id +
                ", rating=" + rating +
                ", Serie=" + serie +
                ", User=" + user +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serien_Rating that = (Serien_Rating) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
