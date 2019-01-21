package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Hersteller;
import at.fh.ima.swengs.cineFoxDB.model.HerstellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service()
public class HerstellerService {

    @Autowired
    private HerstellerRepository herstellerRepository;

    public Optional<Hersteller> findById(long id) {
        return herstellerRepository.findById(id);
    }

    public Hersteller save(Hersteller entity) {
        return herstellerRepository.save(entity);
    }
}
