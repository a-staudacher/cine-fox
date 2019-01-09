package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Episoden_Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer rating;

    @ManyToOne
    private Episode Episode;


    @Version
    @JsonIgnore
    private long version;

    public Episoden_Rating() {
    }

    public Episoden_Rating(Integer rating) {
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

    public at.fh.ima.swengs.cineFoxDB.model.Episode getEpisode() {
        return Episode;
    }

    public void setEpisode(at.fh.ima.swengs.cineFoxDB.model.Episode episode) {
        Episode = episode;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Episoden_Rating serie = (Episoden_Rating) o;
        return id == serie.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                ", version=" + version +
                '}';
    }
}
