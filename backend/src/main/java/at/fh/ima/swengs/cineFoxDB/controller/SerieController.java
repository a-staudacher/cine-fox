package at.fh.ima.swengs.cineFoxDB.controller;

import at.fh.ima.swengs.cineFoxDB.dto.SeriesDTO;
import at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating;
import at.fh.ima.swengs.cineFoxDB.facade.SeriesFacade;
import at.fh.ima.swengs.cineFoxDB.facade.SeriesFacade_Read;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
public class SerieController {

    @Autowired
    private SeriesFacade seriesFacade;

    @Autowired
    private SeriesFacade_Read seriesFacade_read;

    @GetMapping("/dto/series/{id}")
    SeriesDTO getById(@PathVariable long id) {
        return seriesFacade_read.getById(id);
    }

    @PostMapping("/dto/series")
    SeriesDTOnormalRating create(@RequestBody @Valid SeriesDTOnormalRating dto) {
        return seriesFacade.create(dto);
    }

    @PutMapping("/dto/series/{id}")
    SeriesDTOnormalRating update(@RequestBody @Valid SeriesDTOnormalRating dto, @PathVariable long id) {
        return seriesFacade.update(id, dto);
    }

    @GetMapping("/dto/series")
    Set<SeriesDTO> getAll() {
        return seriesFacade_read.getAll();
    }

}
