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
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer episoden_name;
    private Integer dauer;


    @ManyToOne
    private Serie serie;


    @Version
    @JsonIgnore
    private long version;

    public Episode() {
    }

    public Episode(Integer dauer, Integer episoden_name) {
        this.dauer = dauer;
        this.episoden_name = episoden_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getDauer() {
        return dauer;
    }

    public void setDauer(Integer dauer) {
        this.dauer = dauer;
    }

    public Integer getEpisoden_name() {
        return episoden_name;
    }

    public void setEpisoden_name(Integer episoden_name) {
        this.episoden_name = episoden_name;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
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
        Episode serie = (Episode) o;
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
                ", dauer='" + dauer + '\'' +
                ", episoden_name='" + episoden_name + '\'' +
                ", version=" + version +
                '}';
    }
}
