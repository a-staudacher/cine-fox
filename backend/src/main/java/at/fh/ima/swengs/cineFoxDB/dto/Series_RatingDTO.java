package at.fh.ima.swengs.cineFoxDB.dto;

import at.fh.ima.swengs.cineFoxDB.model.*;

import java.util.Date;
import java.util.Set;

public class Series_RatingDTO {

    private Long id;

    private Integer rating;

    private User user;

    public Series_RatingDTO(Long id, Integer rating) {
        this.id = id;
        this.rating = rating;
        this.user = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
