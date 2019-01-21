package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.SeriesDTO;
import at.fh.ima.swengs.cineFoxDB.facade.SeriesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SerieController {

    @Autowired
    private SeriesFacade seriesFacade;

    @GetMapping("/dto/series/{id}")
    SeriesDTO getById(@PathVariable long id) {
        return seriesFacade.getById(id);
    }

    @PostMapping("/dto/series")
    SeriesDTO create(@RequestBody @Valid SeriesDTO dto) {
        return seriesFacade.create(dto);
    }

    @PutMapping("/dto/series/{id}")
    SeriesDTO update(@RequestBody @Valid SeriesDTO dto, @PathVariable long id) {
        return seriesFacade.update(id, dto);
    }

}
