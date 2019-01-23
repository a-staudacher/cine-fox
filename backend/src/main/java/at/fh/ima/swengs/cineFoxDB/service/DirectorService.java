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

    /*public Set<Director> getDirectors(Set<String> dtos) {
        Set<Director> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(directorRepository.findSerieName(dto)));
        }
        return entities;
    }*/

}
