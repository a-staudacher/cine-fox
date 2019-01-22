package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Person;
import at.fh.ima.swengs.cineFoxDB.model.PersonRepository;
import at.fh.ima.swengs.cineFoxDB.model.Serie;
import at.fh.ima.swengs.cineFoxDB.model.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
