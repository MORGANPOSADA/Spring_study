package mx.edu.utez.asesorias.models.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository
    extends JpaRepository<Person, Long> {
    //Operaciones CRUD y operacione específicas
    boolean existsByCurp(String curp);
    //findBy
    //existsBy
    //findAllBy
    //save
    //delete
}
