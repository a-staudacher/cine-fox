package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource
@Transactional(isolation = Isolation.READ_COMMITTED)
public interface DirectorRepository extends PagingAndSortingRepository<Director, Long>, JpaRepository<Director, Long>, CrudRepository<Director, Long> {

    //@Query("select s.name from Serie s inner join Director d where s.director = d.id")
    //public Director findSerieName(String serie);
}
