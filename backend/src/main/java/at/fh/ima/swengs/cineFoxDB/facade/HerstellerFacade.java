package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.service.HerstellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional
public class HerstellerFacade {

    @Autowired
    private HerstellerService herstellerService;
    /*
        @Autowired
        private MovieService movieService;*/

        void mapDtoToEntity(at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO dto, at.fh.ima.swengs.cineFoxDB.model.Hersteller entity) {
            entity.setBezeichnung(dto.getBezeichnung());
            entity.setSeries(dto.getSeries());
        }

        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.Hersteller entity, at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO dto) {
            dto.setId(entity.getId());
            dto.setBezeichnung(entity.getBezeichnung());
            dto.setSeries(entity.getSeries());
        }

        public at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO update(Long id, at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO dto) {
            at.fh.ima.swengs.cineFoxDB.model.Hersteller entity = herstellerService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(herstellerService.save(entity), dto);
            return dto;
        }

    public at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO create(at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO dto) {
        at.fh.ima.swengs.cineFoxDB.model.Hersteller entity = new at.fh.ima.swengs.cineFoxDB.model.Hersteller();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(herstellerService.save(entity), dto);
        return dto;
    }

    public at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.Hersteller entity = herstellerService.findById(id).get();
        at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO dto = new at.fh.ima.swengs.cineFoxDB.dto.HerstellerDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }
}
