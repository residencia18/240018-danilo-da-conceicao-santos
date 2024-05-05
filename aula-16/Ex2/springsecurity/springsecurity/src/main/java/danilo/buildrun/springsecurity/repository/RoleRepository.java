package danilo.buildrun.springsecurity.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import danilo.buildrun.springsecurity.entities.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
