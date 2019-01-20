package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Charakter;
import at.fh.ima.swengs.cineFoxDB.model.CharakterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service()
public class CharakterService {

    @Autowired
    private CharakterRepository charakterRepository;

    public Set<Charakter> getCharakter(Set<Long> dtos) {
        Set<Charakter> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(charakterRepository.findById(dto).get()));
        }
        return entities;
    }

}
