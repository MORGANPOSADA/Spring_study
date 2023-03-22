package mx.edu.utez.asesorias.models.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.asesorias.models.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentKey;
    private String group;
    @OneToOne
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;
}
