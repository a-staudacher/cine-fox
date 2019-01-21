package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.UserDTO;
import at.fh.ima.swengs.cineFoxDB.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/dto/user/{id}")
    UserDTO getById(@PathVariable long id) {
        return userFacade.getById(id);
    }

    @PostMapping("/dto/user")
    UserDTO create(@RequestBody @Valid UserDTO dto) {
        return userFacade.create(dto);
    }

    @PutMapping("/dto/user/{id}")
    UserDTO update(@RequestBody @Valid UserDTO dto, @PathVariable long id) {
        return userFacade.update(id, dto);
    }

    @GetMapping("/dto/users")
    Set<UserDTO> getAll() {return userFacade.getAll();}

}
