package mx.edu.utez.recupera.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.recupera.models.Alumno;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlumnosDto {
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String birthday;
    @NotEmpty
//    @Pattern(regexp = "^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0\\d|1[0-2])(?:[0-2]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$")
    private String curp;
    private String matricula=generador();
    private Boolean status = true;
    int contador=1;
    public String generador(){
        String matriculagenerada = null;
        matriculagenerada= "20213TN"+3;
        contador++;
        return matriculagenerada;
    }


    public Alumno getDatos(){
        return new Alumno(
                getId(),
                getName(),
                getSurname(),
                getLastname(),
                getBirthday(),
                getCurp(),
                getMatricula(),
                getStatus()
        );
    }
}
