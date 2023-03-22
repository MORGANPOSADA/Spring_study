package mx.edu.utez.asesorias.services.person;

import mx.edu.utez.asesorias.models.person.Person;
import mx.edu.utez.asesorias.models.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class PersonService {
    @Autowired // Inyección de dependencias
    private PersonRepository repository;

    @Transactional( readOnly= true)
    public List<Person> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    public Person getOne(Long id) {
        return this.repository.findById(id).get();
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Person register(Person person) {
        if (this.repository.existsByCurp(person.getCurp()))
            return null;
        return this.repository.saveAndFlush(person);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Person update(Person person) {
        if (this.repository.existsByCurp(person.getCurp()))
            return this.repository.saveAndFlush(person);
        return null;
    }

    @Transactional(rollbackFor = {SQLException.class})
    public boolean changeStatus(Person person) {
        if (this.repository.existsByCurp(person.getCurp())) {
            Person aux = this.repository.findById(person.getId()).get();
            aux.setStatus(person.getStatus());
            this.repository.saveAndFlush(aux);
            return true;
        }
        return false;
    }

}
