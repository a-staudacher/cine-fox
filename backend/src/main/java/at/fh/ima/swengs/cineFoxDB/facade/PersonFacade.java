package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.service.CharakterService;
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

    @Autowired
    private CharakterService charakterService;

        void mapDtoToEntity(at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto, at.fh.ima.swengs.cineFoxDB.model.Person entity) {
            entity.setVorname(dto.getVorname());
            entity.setNachname(dto.getNachname());
            entity.setDayOfBirth(dto.getDayOfBirth());
            entity.setBeschreibung(dto.getBeschreibung());
            entity.setDirectors(dto.getDirectors());
            entity.setCharakters(dto.getCharakters());
            entity.setPictures(dto.getPictures());
        }

        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.Person entity, at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto) {
            dto.setId(entity.getId());
            dto.setVorname(entity.getVorname());
            dto.setNachname(entity.getNachname());
            dto.setDayOfBirth(entity.getDayOfBirth());
            dto.setBeschreibung(entity.getBeschreibung());
            dto.setDirectors(entity.getDirectors());
            dto.setCharakters(entity.getCharakters());
            dto.setPictures(entity.getPictures());
        }

        public at.fh.ima.swengs.cineFoxDB.dto.PersonDTO update(Long id, at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto) {
            at.fh.ima.swengs.cineFoxDB.model.Person entity = personService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(personService.save(entity), dto);
            return dto;
        }

    public at.fh.ima.swengs.cineFoxDB.dto.PersonDTO create(at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto) {
        at.fh.ima.swengs.cineFoxDB.model.Person entity = new at.fh.ima.swengs.cineFoxDB.model.Person();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(personService.save(entity), dto);
        return dto;
    }

    public at.fh.ima.swengs.cineFoxDB.dto.PersonDTO getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.Person entity = personService.findById(id).get();
        at.fh.ima.swengs.cineFoxDB.dto.PersonDTO dto = new at.fh.ima.swengs.cineFoxDB.dto.PersonDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }
}
