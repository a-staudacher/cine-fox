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

}
