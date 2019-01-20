package at.fh.ima.swengs.cineFoxDB.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private boolean admin;

    @ManyToOne
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "serie_user",
            joinColumns = @JoinColumn(name = "serie_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Serie> favorite;

    @OneToMany(mappedBy = "user")
    private Set<Media> profilePicture;

    @OneToMany(mappedBy = "user")
    private Set<Serien_Rating> serien_ratings;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "user")
    private Set<Episoden_Rating> episoden_ratings;

    public User() {
    }

    public User(String username, String password, boolean admin, Role role, Set<Serie> favorite,
                Set<Serien_Rating> serien_ratings, Set<Review> reviews, Set<Episoden_Rating> episoden_ratings) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.role = role;
        this.favorite = favorite;
        this.serien_ratings = serien_ratings;
        this.reviews = reviews;
        this.episoden_ratings = episoden_ratings;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Serie> getFavorite() {
        return favorite;
    }

    public void setFavorite(Set<Serie> favorite) {
        this.favorite = favorite;
    }

    public Set<Serien_Rating> getSerien_ratings() {
        return serien_ratings;
    }

    public void setSerien_ratings(Set<Serien_Rating> serien_ratings) {
        this.serien_ratings = serien_ratings;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Episoden_Rating> getEpisoden_ratings() {
        return episoden_ratings;
    }

    public void setEpisoden_ratings(Set<Episoden_Rating> episoden_ratings) {
        this.episoden_ratings = episoden_ratings;
    }

    public Set<Media> getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Set<Media> profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
