package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Kategorie;
import at.fh.ima.swengs.cineFoxDB.model.KategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service()
public class KategorieService {

    @Autowired
    private KategorieRepository kategorieRepository;

    public Optional<Kategorie> findById(long id) {
        return kategorieRepository.findById(id);
    }

    public Kategorie save(Kategorie entity) {
        return kategorieRepository.save(entity);
    }
}
