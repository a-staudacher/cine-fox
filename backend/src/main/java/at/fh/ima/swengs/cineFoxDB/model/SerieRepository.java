package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource()
public interface SerieRepository extends PagingAndSortingRepository<Serie,Long>, JpaRepository<Serie, Long>, CrudRepository<Serie, Long> {

    Serie findByName (String name);

    Serie findSerieByDirector (Director director);

    //This would be exposed under the URL: http://localhost:8080/actors/search/findByFirstNameAndLastName
    //public List<Serie> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
