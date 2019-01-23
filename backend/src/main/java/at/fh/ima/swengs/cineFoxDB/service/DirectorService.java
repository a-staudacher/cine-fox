package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Director;
import at.fh.ima.swengs.cineFoxDB.model.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service()
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public Set<Director> getDirectors(Set<Long> dtos) {
        Set<Director> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(directorRepository.findById(dto).get()));
        }
        return entities;
    }

}
