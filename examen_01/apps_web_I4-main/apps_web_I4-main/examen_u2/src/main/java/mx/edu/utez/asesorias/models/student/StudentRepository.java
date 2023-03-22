package mx.edu.utez.asesorias.models.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
    extends JpaRepository<Student, Long> {
    //Operaciones CRUD y operacione específicas
}
