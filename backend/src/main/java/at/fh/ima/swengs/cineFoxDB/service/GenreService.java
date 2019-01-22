package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Genre;
import at.fh.ima.swengs.cineFoxDB.model.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service()
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Optional<Genre> findById(long id) {
        return genreRepository.findById(id);
    }

    public Genre save(Genre entity) {
        return genreRepository.save(entity);
    }
}
