package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.dto.SeriesDTO;
import at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating;
import at.fh.ima.swengs.cineFoxDB.dto.UserDTO;
import at.fh.ima.swengs.cineFoxDB.model.Serie;
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
public class SeriesFacade {

    @Autowired
    private SeriesService seriesService;

    @Autowired
    private GenreService genreService;
    /*
        @Autowired
        private MovieService movieService;*/

        void mapDtoToEntity(at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating dto, at.fh.ima.swengs.cineFoxDB.model.Serie entity) {
            entity.setName(dto.getName());
            entity.setTrailer(dto.getTrailer());
            entity.setReleaseDate(dto.getReleaseDate());
            entity.setGenres(genreService.getGenres(dto.getGenres()));
            entity.setHersteller(dto.getHersteller());
            entity.setKategorie(dto.getKategorie());
            entity.setSerien_ratings(dto.getSerien_ratings());
            entity.setCharakters(dto.getCharakters());
            entity.setDirectors(dto.getDirectors());
            entity.setReviews(dto.getReviews());
            entity.setPictures(dto.getPictures());
        }

        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.Serie entity, at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating dto) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setTrailer(entity.getTrailer());
            dto.setReleaseDate(entity.getReleaseDate());
            dto.setGenres(entity.getGenres().stream().map((m) -> m.getName()).collect(Collectors.toSet()));
            dto.setHersteller(entity.getHersteller());
            dto.setKategorie(entity.getKategorie());
            dto.setSerien_ratings(entity.getSerien_ratings());
            dto.setCharakters(entity.getCharakters());
            dto.setDirectors(entity.getDirectors());
            dto.setReviews(entity.getReviews());
            dto.setPictures(entity.getPictures());
        }

        public at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating update(Long id, at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating dto) {
            at.fh.ima.swengs.cineFoxDB.model.Serie entity = seriesService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(seriesService.save(entity), dto);
            return dto;
        }

    public at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating create(at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating dto) {
        at.fh.ima.swengs.cineFoxDB.model.Serie entity = new at.fh.ima.swengs.cineFoxDB.model.Serie();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(seriesService.save(entity), dto);
        return dto;
    }

    public at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.Serie entity = seriesService.findById(id).get();
        at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating dto = new at.fh.ima.swengs.cineFoxDB.dto.SeriesDTOnormalRating();
        mapEntityToDto(entity, dto);
        return dto;
    }

    public Set<SeriesDTOnormalRating> getAll() {
        List<Serie> entityList = seriesService.getAll();
        // at.fh.ima.swengs.cineFoxDB.model.User entity = userService.findById(id).get();
        Set<SeriesDTOnormalRating> dtoSet = new HashSet<SeriesDTOnormalRating>();
        SeriesDTOnormalRating dto;

        for(int i = 0; i < entityList.size(); i++)
        {
            dto = new SeriesDTOnormalRating();
            mapEntityToDto(entityList.get(i),dto);
            dtoSet.add(dto);
        }
        return dtoSet;
    }
}
