package at.fh.ima.swengs.cineFoxDB.facade;

import at.fh.ima.swengs.cineFoxDB.service.KategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional
public class KategorieFacade {

    @Autowired
    private KategorieService kategorieService;
    /*
        @Autowired
        private MovieService movieService;*/

        void mapDtoToEntity(at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO dto, at.fh.ima.swengs.cineFoxDB.model.Kategorie entity) {
            entity.setBezeichnung(dto.getBezeichnung());
            //entity.setSeries(dto.getSeries());
        }

        private void mapEntityToDto(at.fh.ima.swengs.cineFoxDB.model.Kategorie entity, at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO dto) {
            dto.setId(entity.getId());
            dto.setBezeichnung(entity.getBezeichnung());
            //dto.setSeries(entity.getSeries());
        }

        public at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO update(Long id, at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO dto) {
            at.fh.ima.swengs.cineFoxDB.model.Kategorie entity = kategorieService.findById(id).get();
            mapDtoToEntity(dto, entity);
            mapEntityToDto(kategorieService.save(entity), dto);
            return dto;
        }

    public at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO create(at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO dto) {
        at.fh.ima.swengs.cineFoxDB.model.Kategorie entity = new at.fh.ima.swengs.cineFoxDB.model.Kategorie();
        mapDtoToEntity(dto, entity);
        mapEntityToDto(kategorieService.save(entity), dto);
        return dto;
    }

    public at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO getById(Long id) {
        at.fh.ima.swengs.cineFoxDB.model.Kategorie entity = kategorieService.findById(id).get();
        at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO dto = new at.fh.ima.swengs.cineFoxDB.dto.KategorieDTO();
        mapEntityToDto(entity, dto);
        return dto;
    }
}
