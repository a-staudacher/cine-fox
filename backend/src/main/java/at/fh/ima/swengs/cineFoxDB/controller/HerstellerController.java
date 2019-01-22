package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO;
import at.fh.ima.swengs.cineFoxDB.facade.HerstellerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HerstellerController {

    @Autowired
    private HerstellerFacade herstellerFacade;

    @GetMapping("/dto/herstellers/{id}")
    HerstellerDTO getById(@PathVariable long id) {
        return herstellerFacade.getById(id);
    }

    @PostMapping("/dto/herstellers")
    HerstellerDTO create(@RequestBody @Valid HerstellerDTO dto) {
        return herstellerFacade.create(dto);
    }

    @PutMapping("/dto/herstellers/{id}")
    HerstellerDTO update(@RequestBody @Valid HerstellerDTO dto, @PathVariable long id) {
        return herstellerFacade.update(id, dto);
    }

}
