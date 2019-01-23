package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource()
public interface SerieRepository extends PagingAndSortingRepository<Serie,Long>, JpaRepository<Serie, Long>, CrudRepository<Serie, Long> {

    //This would be exposed under the URL: http://localhost:8080/actors/search/findByFirstNameAndLastName
    //public List<Serie> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    public List<Serie> findByNameContainingAllIgnoreCase(String name);
}
