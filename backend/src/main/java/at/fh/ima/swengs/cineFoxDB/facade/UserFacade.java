package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.dto.UserDTO;
import at.fh.ima.swengs.cineFoxDB.model.User;
import at.fh.ima.swengs.cineFoxDB.service.UserDetailsServiceImpl;
import at.fh.ima.swengs.cineFoxDB.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service()
@Transactional
public class UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

        void mapDtoToEntity(at.fh.ima.swengs.cineFoxDB.dto.UserDTO dto, at.fh.ima.swengs.cineFoxDB.model.User entity) {
            entity.setUsername(dto.getUsername());
        }

        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.User entity, at.fh.ima.swengs.cineFoxDB.dto.UserDTO dto) {
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
        }

        void mapCreateDtoToEntity(at.fh.ima.swengs.cineFoxDB.dto.UserCreateDTO dto, at.fh.ima.swengs.cineFoxDB.model.User entity) {
            entity.setUsername(dto.getUsername());
            entity.setPassword(userDetailsService.encode(dto.getPassword())); //verschluesseln notwendig?
        }

        private void mapEntityToCreateDto(at.fh.ima.swengs.cineFoxDB.model.User entity, at.fh.ima.swengs.cineFoxDB.dto.UserCreateDTO dto) {
            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setPassword(entity.getPassword());
        }

        public at.fh.ima.swengs.cineFoxDB.dto.UserDTO update(Long id, at.fh.ima.swengs.cineFoxDB.dto.UserDTO dto) {
            at.fh.ima.swengs.cineFoxDB.model.User entity = userService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(userService.save(entity), dto);
            return dto;
        }

    public at.fh.ima.swengs.cineFoxDB.dto.UserCreateDTO create(at.fh.ima.swengs.cineFoxDB.dto.UserCreateDTO dto) {
        at.fh.ima.swengs.cineFoxDB.model.User entity = new at.fh.ima.swengs.cineFoxDB.model.User();
        mapCreateDtoToEntity(dto, entity);
        mapEntityToCreateDto(userService.save(entity), dto);
        return dto;
    }

    public at.fh.ima.swengs.cineFoxDB.dto.UserDTO getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.User entity = userService.findById(id).get();
        at.fh.ima.swengs.cineFoxDB.dto.UserDTO dto = new at.fh.ima.swengs.cineFoxDB.dto.UserDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public Set<at.fh.ima.swengs.cineFoxDB.dto.UserDTO> getAll() {
        List<User> entityList = userService.getAll();
        // at.fh.ima.swengs.cineFoxDB.model.User entity = userService.findById(id).get();
        Set<UserDTO> dtoSet = new HashSet<UserDTO>();
        UserDTO dto;

        for(int i = 0; i < entityList.size(); i++)
        {
            dto = new UserDTO();
            mapEntityToDto(entityList.get(i),dto);
            dtoSet.add(dto);
        }
        return dtoSet;
    }
}
