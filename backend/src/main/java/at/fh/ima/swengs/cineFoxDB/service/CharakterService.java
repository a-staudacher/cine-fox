package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Charakter;
import at.fh.ima.swengs.cineFoxDB.model.CharakterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

@Service()
public class CharakterService {

    @Autowired
    private CharakterRepository charakterRepository;

    public Set<Charakter> getCharakters(Set<String> dtos) {
        Set<Charakter> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(charakterRepository.findByName(dto)));
        }
        return entities;
    }

    public Optional<Charakter> findById(long id) {
        return charakterRepository.findById(id);
    }

    public Charakter save(Charakter entity) {
        return charakterRepository.save(entity);
    }
}
