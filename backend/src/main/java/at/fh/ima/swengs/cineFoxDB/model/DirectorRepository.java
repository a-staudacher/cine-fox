package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@RepositoryRestResource
@Transactional(isolation = Isolation.READ_COMMITTED)
public interface DirectorRepository extends PagingAndSortingRepository<Director, Long>, JpaRepository<Director, Long>, CrudRepository<Director, Long> {

    //Director findDirectorBySerie (Serie serie);


}
