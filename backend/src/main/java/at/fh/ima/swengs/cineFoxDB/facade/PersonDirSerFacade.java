package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.model.Serie;
import at.fh.ima.swengs.cineFoxDB.service.GenreService;
import at.fh.ima.swengs.cineFoxDB.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service()
@Transactional
public class PersonDirSerFacade {

    @Autowired
    private PersonService personService;
    /*
        @Autowired
        private MovieService movieService;*/


        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.Person entity, at.fh.ima.swengs.cineFoxDB.dto.PersonDirSerDTO dto) {
            dto.setId(entity.getId());
            if(entity.getDirectors() != null) {
                dto.setSeriename(entity.getDirectors().stream().map((m) -> {
                    Serie zwiSerie = m.getSerie();
                    if(zwiSerie != null)
                    {
                        return zwiSerie.getName();
                    }
                    else
                    {
                        return null;
                    }
                }).collect(Collectors.toSet()));
            }
            else
            {
                dto.setSeriename(new HashSet<>());
            }
        }

    public at.fh.ima.swengs.cineFoxDB.dto.PersonDirSerDTO getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.Person entity = personService.findById(id).get();
        at.fh.ima.swengs.cineFoxDB.dto.PersonDirSerDTO dto = new at.fh.ima.swengs.cineFoxDB.dto.PersonDirSerDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }
}
