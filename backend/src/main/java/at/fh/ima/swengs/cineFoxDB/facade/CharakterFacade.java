package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.dto.CharakterDTO;
import at.fh.ima.swengs.cineFoxDB.model.Serie;
import at.fh.ima.swengs.cineFoxDB.service.CharakterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional
public class CharakterFacade {

    @Autowired
    private CharakterService charakterService;
    /*
        @Autowired
        private MovieService movieService;*/

        void mapDtoToEntity(CharakterDTO dto, at.fh.ima.swengs.cineFoxDB.model.Charakter entity) {
            entity.setName(dto.getName());
            entity.setPerson(dto.getPerson());
            Serie serie = new Serie();
            serie.setId(dto.getId());
            serie.setName(dto.getName());
            entity.setSerie(serie);
        }

        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.Charakter entity, CharakterDTO dto) {
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setPerson(entity.getPerson());
            dto.getPerson().setDirectors(null);
            dto.setSerie_id(entity.getSerie().getId());
            dto.setSerie_name(entity.getSerie().getName());
        }

        public CharakterDTO update(Long id, CharakterDTO dto) {
            at.fh.ima.swengs.cineFoxDB.model.Charakter entity = charakterService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(charakterService.save(entity), dto);
            return dto;
        }

    public CharakterDTO create(CharakterDTO dto) {
        at.fh.ima.swengs.cineFoxDB.model.Charakter entity = new at.fh.ima.swengs.cineFoxDB.model.Charakter();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(charakterService.save(entity), dto);
        return dto;
    }

    public CharakterDTO getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.Charakter entity = charakterService.findById(id).get();
        CharakterDTO dto = new CharakterDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }
}
