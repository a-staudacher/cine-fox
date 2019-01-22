package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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

    public Set<Serie> getSerieNames(Set<String> dtos) {
        Set<Serie> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(serieRepository.findByName(dto)));
        }
        return entities;
    }


    public Set<Serie> getSeries(Set<Director> dtos) {
        Set<Serie> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(serieRepository.findSerieByDirector(dto)));
        }
        return entities;
    }

}
