package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource
@Transactional(isolation = Isolation.READ_COMMITTED)
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long>, JpaRepository<Review, Long>, CrudRepository<Review, Long> {

    List<Review> findBySerieId(@Param("id") long id);
}
