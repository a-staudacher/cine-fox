package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "serienRatings")
public interface Serien_RatingRepository extends PagingAndSortingRepository<Serien_Rating,Long>, JpaRepository<Serien_Rating, Long>, CrudRepository<Serien_Rating, Long> {


}
