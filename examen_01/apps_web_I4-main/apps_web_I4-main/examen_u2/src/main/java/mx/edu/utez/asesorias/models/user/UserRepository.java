package mx.edu.utez.asesorias.models.user;

import mx.edu.utez.asesorias.models.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    int existsById(int id);



}
