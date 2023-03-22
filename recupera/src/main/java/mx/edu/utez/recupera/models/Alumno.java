package mx.edu.utez.recupera.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "alumnos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false,length = 150)
    private String name;
    private String surname;
    private String lastname;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private String birthday;
    @Column(unique = true,nullable = false,length = 18)
    private String curp;
    private String matricula;
    @Column(name = "status",nullable = false,columnDefinition = "tinyint default 1")
    private Boolean status;

}
