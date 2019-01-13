package at.fh.ima.swengs.cineFoxDB.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
@Transactional(isolation = Isolation.READ_COMMITTED)
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>, JpaRepository<Role, Long>, CrudRepository<Role, Long> {
}
