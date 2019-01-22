package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.GenreDTO;
import at.fh.ima.swengs.cineFoxDB.facade.GenreFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GenreController {

    @Autowired
    private GenreFacade genreFacade;

    @GetMapping("/dto/genres/{id}")
    GenreDTO getById(@PathVariable long id) {
        return genreFacade.getById(id);
    }

    @PostMapping("/dto/genres")
    GenreDTO create(@RequestBody @Valid GenreDTO dto) {
        return genreFacade.create(dto);
    }

    @PutMapping("/dto/genres/{id}")
    GenreDTO update(@RequestBody @Valid GenreDTO dto, @PathVariable long id) {
        return genreFacade.update(id, dto);
    }

}
