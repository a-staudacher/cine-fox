package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Attributes to be added if needed (right now just m:n)

    @ManyToOne
    private Person person;

    @ManyToOne
    private Serie serie;

    @Version
    @JsonIgnore
    private long version;

    public Director() {
    }

    public Director(Person person, Serie serie) {
        this.person = person;
        this.serie = serie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director person = (Director) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", person=" + person +
                ", serie=" + serie +
                ", version=" + version +
                '}';
    }
}
