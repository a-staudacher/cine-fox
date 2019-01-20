package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.CharakterDTO;
import at.fh.ima.swengs.cineFoxDB.facade.CharakterFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CharakterController {

    @Autowired
    private CharakterFacade charakterFacade;

    @GetMapping("/dto/charakters/{id}")
    CharakterDTO getById(@PathVariable long id) {
        return charakterFacade.getById(id);
    }

    @PostMapping("/dto/charakters")
    CharakterDTO create(@RequestBody @Valid CharakterDTO dto) {
        return charakterFacade.create(dto);
    }

    @PutMapping("/dto/charakters/{id}")
    CharakterDTO update(@RequestBody @Valid CharakterDTO dto, @PathVariable long id) {
        return charakterFacade.update(id, dto);
    }

}
