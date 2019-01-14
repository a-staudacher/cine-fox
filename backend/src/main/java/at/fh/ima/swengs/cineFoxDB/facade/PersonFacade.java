package at.fh.ima.swengs.cineFoxDB.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import at.fh.ima.swengs.cineFoxDB.service.PersonService;

import java.util.stream.Collectors;

@Service()
@Transactional
public class PersonFacade {

    @Autowired
    private PersonService personService;
    /*
        @Autowired
        private MovieService movieSvice;
    /*
        void mapDtoToEntity(at.fh.ima.swengs.moviedbv3.dto.PersonDTO dto, at.fh.ima.swengs.moviedbv3.model.Person entity) {
            entity.setFirstName(dto.getFirstName());
            entity.setLastName(dto.getLastName());
            entity.setAlive(dto.isAlive());
            entity.setRating(dto.getRating());
            entity.setGender(dto.getGender());
            entity.setDayOfBirth(dto.getDayOfBirth());
            entity.setMovies(movieService.getMovies(dto.getMovies()));
        }

        private void mapEntityToDto(at.fh.ima.swengs.moviedbv3.model.Person entity, at.fh.ima.swengs.moviedbv3.dto.PersonDTO dto) {
            dto.setId(entity.getId());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dto.setAlive(entity.isAlive());
            dto.setRating(entity.getRating());
            dto.setGender(entity.getGender());
            dto.setDayOfBirth(entity.getDayOfBirth());
            dto.setMovies(entity.getMovies().stream().map((m) -> m.getId()).collect(Collectors.toSet()));
        }

        public at.fh.ima.swengs.moviedbv3.dto.PersonDTO update(Long id, at.fh.ima.swengs.moviedbv3.dto.PersonDTO dto) {
            at.fh.ima.swengs.moviedbv3.model.Person entity = actorService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(actorService.save(entity), dto);
            return dto;
        }
    */
    public at.fh.ima.swengs.cineFoxDB.dto.PersonDTO create(at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto) {
        at.fh.ima.swengs.cineFoxDB.model.Person entity = new at.fh.ima.swengs.cineFoxDB.model.Person();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(personService.save(entity), dto);
        return dto;
    }

    public at.fh.ima.swengs.cineFoxDB.dto.PersonDTO getById(Long id) {
        // at.fh.ima.swengs.cineFoxDB.model.Person entity = actorService.findById(id).get();
        // at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto = new at.fh.ima.swengs.moviedbv3.dto.PersonDTO();
        // mapEntityToDto(entity, dto);
        // return dto;
        return null;
    }
}
