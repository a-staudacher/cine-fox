package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.facade.PersonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    private PersonFacade personFacade;

    @GetMapping("/dto/actors/{id}")
    at.fh.ima.swengs.cineFoxDB.dto.PersonDTO getById(@PathVariable Long id) {
        return personFacade.getById(id);
    }

    @PostMapping("/dto/actors")
    at.fh.ima.swengs.cineFoxDB.dto.PersonDTO create(@RequestBody @Valid at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto) {
        // return personFacade.create(dto);
        return null;
    }

    @PutMapping("/dto/actors/{id}")
    at.fh.ima.swengs.cineFoxDB.dto.PersonDTO update(@RequestBody @Valid at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto, @PathVariable Long id) {
        // return personFacade.update(id, dto);
        return null;
    }

}
