package at.fh.ima.swengs.cineFoxDB.service;

import at.fh.ima.swengs.cineFoxDB.model.PersonRepository;
import at.fh.ima.swengs.cineFoxDB.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service()
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person save(Person entity) {
        return personRepository.save(entity);
    }
}
