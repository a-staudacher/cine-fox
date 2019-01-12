package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Kategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String bezeichnung;

    @OneToMany(mappedBy= "kategorie", fetch=FetchType.EAGER)
    private Set<Serie> series;

    @Version
    @JsonIgnore
    private long version;

    public Kategorie() {

    }

    public Kategorie(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Kategorie{" +
                "id=" + id +
                ", bezeichnung='" + bezeichnung + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kategorie)) return false;
        Kategorie kategorie = (Kategorie) o;
        return getId() == kategorie.getId() &&
                getVersion() == kategorie.getVersion() &&
                Objects.equals(getBezeichnung(), kategorie.getBezeichnung());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBezeichnung(), getVersion());
    }
}
