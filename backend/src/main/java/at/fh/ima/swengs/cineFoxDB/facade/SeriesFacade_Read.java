package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.dto.SeriesDTO;
import at.fh.ima.swengs.cineFoxDB.dto.Series_RatingDTO;
import at.fh.ima.swengs.cineFoxDB.model.Serie;
import at.fh.ima.swengs.cineFoxDB.model.Serien_Rating;
import at.fh.ima.swengs.cineFoxDB.service.GenreService;
import at.fh.ima.swengs.cineFoxDB.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service()
@Transactional
public class SeriesFacade_Read {

    @Autowired
    private SeriesService seriesService;

    @Autowired
    private GenreService genreService;
    /*
        @Autowired
        private MovieService movieService;*/

        private void mapEntityToDto(Serie entity, SeriesDTO dto) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setTrailer(entity.getTrailer());
            dto.setReleaseDate(entity.getReleaseDate());
            dto.setGenres(entity.getGenres().stream().map((m) -> m.getName()).collect(Collectors.toSet()));
            dto.setHersteller(entity.getHersteller());
            dto.setKategorie(entity.getKategorie());
            Set<Serien_Rating> sR = entity.getSerien_ratings();
            dto.setSerien_ratings(sR.stream().map((m) -> new Series_RatingDTO(m.getId(),m.getRating())).collect(Collectors.toSet()));
            //dto.setCharakters(entity.getCharakters());
            dto.setDirectors(entity.getDirectors());
            //dto.setReviews(entity.getReviews());
            dto.setPictures(entity.getPictures());
        }

    public SeriesDTO getById(Long id) {
        Serie entity = seriesService.findById(id).get();
        SeriesDTO dto = new SeriesDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public Set<SeriesDTO> getAll() {
        List<Serie> entityList = seriesService.getAll();
        // at.fh.ima.swengs.cineFoxDB.model.User entity = userService.findById(id).get();
        Set<SeriesDTO> dtoSet = new HashSet<SeriesDTO>();
        SeriesDTO dto;

        for(int i = 0; i < entityList.size(); i++)
        {
            dto = new SeriesDTO();
            mapEntityToDto(entityList.get(i),dto);
            dtoSet.add(dto);
        }
        return dtoSet;
    }
}
