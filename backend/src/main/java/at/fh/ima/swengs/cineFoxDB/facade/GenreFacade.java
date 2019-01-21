package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional
public class GenreFacade {

    @Autowired
    private GenreService genreService;
    /*
        @Autowired
        private MovieService movieService;*/

        void mapDtoToEntity(at.fh.ima.swengs.cineFoxDB.dto.GenreDTO dto, at.fh.ima.swengs.cineFoxDB.model.Genre entity) {
            entity.setName(dto.getName());
            entity.setSeries(dto.getSeries());
        }

        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.Genre entity, at.fh.ima.swengs.cineFoxDB.dto.GenreDTO dto) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSeries(entity.getSeries());
        }

        public at.fh.ima.swengs.cineFoxDB.dto.GenreDTO update(Long id, at.fh.ima.swengs.cineFoxDB.dto.GenreDTO dto) {
            at.fh.ima.swengs.cineFoxDB.model.Genre entity = genreService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(genreService.save(entity), dto);
            return dto;
        }

    public at.fh.ima.swengs.cineFoxDB.dto.GenreDTO create(at.fh.ima.swengs.cineFoxDB.dto.GenreDTO dto) {
        at.fh.ima.swengs.cineFoxDB.model.Genre entity = new at.fh.ima.swengs.cineFoxDB.model.Genre();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(genreService.save(entity), dto);
        return dto;
    }

    public at.fh.ima.swengs.cineFoxDB.dto.GenreDTO getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.Genre entity = genreService.findById(id).get();
        at.fh.ima.swengs.cineFoxDB.dto.GenreDTO dto = new at.fh.ima.swengs.cineFoxDB.dto.GenreDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }
}
