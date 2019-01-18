package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.PersonDTO;
import at.fh.ima.swengs.cineFoxDB.model.Person;
import at.fh.ima.swengs.cineFoxDB.facade.PersonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    private PersonFacade personFacade;

    @GetMapping("/dto/person/{id}")
    PersonDTO getById(@PathVariable Long id) {
        return personFacade.getById(id);
    }

    @PostMapping("/dto/person")
    PersonDTO create(@RequestBody @Valid at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto) {
        return personFacade.create(dto);
    }

    @PutMapping("/dto/person/{id}")
    PersonDTO update(@RequestBody @Valid at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto, @PathVariable Long id) {
        return personFacade.update(id, dto);
    }

}
