package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service()
public class SeriesService {

    @Autowired
    private SerieRepository serieRepository;

    public Optional<Serie> findById(long id) {
        return serieRepository.findById(id);
    }

    public Serie save(Serie entity) {
        return serieRepository.save(entity);
    }


    public List<Serie> getAll() {return serieRepository.findAll();}

    public Set<String> getNames (Set<Long> directorIds) {
        Set<String> directors = new HashSet<>();
        if (directorIds != null) {
            directorIds.forEach((id) -> directors.add(serieRepository.findNameById(id)));
        }
        return directors;
    };

    public Set<Serie> getDirectors (Set<String> directorNames) {
        Set<Serie> directors = new HashSet<>();
        if (directorNames != null) {
            directorNames.forEach((director) -> directors.add(serieRepository.findByName(director)));
        }
        return directors;
    }


}
