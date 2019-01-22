package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO;
import at.fh.ima.swengs.cineFoxDB.facade.KategorieFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class KategorieController {

    @Autowired
    private KategorieFacade kategorieFacade;

    @GetMapping("/dto/kategories/{id}")
    KategorieDTO getById(@PathVariable long id) {
        return kategorieFacade.getById(id);
    }

    @PostMapping("/dto/kategories")
    KategorieDTO create(@RequestBody @Valid KategorieDTO dto) {
        return kategorieFacade.create(dto);
    }

    @PutMapping("/dto/kategories/{id}")
    KategorieDTO update(@RequestBody @Valid KategorieDTO dto, @PathVariable long id) {
        return kategorieFacade.update(id, dto);
    }

}
