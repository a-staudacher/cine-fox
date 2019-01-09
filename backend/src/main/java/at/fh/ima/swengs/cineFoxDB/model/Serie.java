package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;
    private String trailer;
    private Integer anzahl;


    @Temporal(TemporalType.TIMESTAMP)
    private Date release;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "genre_serie",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )

    @ManyToOne
    private Hersteller hersteller;

    @ManyToOne
    private Kategorie kategorie;

    @ManyToOne
    private Favorit favorit;


    @Version
    @JsonIgnore
    private long version;

    public Serie() {
    }

    public Serie(String name, String trailer, Integer anzahl, Date release) {
        this.name = name;
        this.trailer = trailer;
        this.anzahl = anzahl;
        this.release = release;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Favorit getFavorit() {
        return favorit;
    }

    public void setFavorit(Favorit favorit) {
        this.favorit = favorit;
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
        Serie serie = (Serie) o;
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
                ", name='" + name + '\'' +
                ", trailer='" + trailer + '\'' +
                ", anzahl='" + anzahl + '\'' +
                ", release='" + release + '\'' +
                ", version=" + version +
                '}';
    }
}
