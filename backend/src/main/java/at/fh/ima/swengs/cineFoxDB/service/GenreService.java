package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.Genre;
import at.fh.ima.swengs.cineFoxDB.model.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

    public Set<Genre> getGenres(Set<String> dtos) {
        Set<Genre> entities = new HashSet<>();
        if (dtos != null) {
            dtos.forEach((dto) -> entities.add(genreRepository.findByName(dto)));
        }
        return entities;
    }
}
