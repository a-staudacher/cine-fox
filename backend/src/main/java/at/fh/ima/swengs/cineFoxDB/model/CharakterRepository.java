package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
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
public interface CharakterRepository extends PagingAndSortingRepository<Charakter, Long>, JpaRepository<Charakter, Long>, CrudRepository<Charakter, Long> {
    public List<Charakter> findBySerieId(@Param("id") long serie);

    Charakter findByName(String name);
}
