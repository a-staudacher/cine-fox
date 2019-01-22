package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Director;
import at.fh.ima.swengs.cineFoxDB.model.DirectorRepository;
import at.fh.ima.swengs.cineFoxDB.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service()
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public Set<Director> getDirectors(Set<Serie> dtos) {
        Set<Director> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(directorRepository.findDirectorByPerson(dto)));
        }
        return entities;
    }

    public Set<Director> getSerieNames(Set<String> dtos) {
        Set<Director> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(directorRepository.findByName(dto)));
        }
        return entities;
    }



}
