package mx.edu.utez.recupera.service;

import mx.edu.utez.recupera.models.Alumno;
import mx.edu.utez.recupera.models.AlumnoRepository;
import mx.edu.utez.recupera.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class AlumnosService {
    @Autowired
    private AlumnoRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Alumno>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Alumno> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }

    @Transactional(rollbackFor = {SQLException.class, SQLException.class})
    public CustomResponse<Alumno> insert(Alumno alumno){
        if(this.repository.existsByCurp(alumno.getCurp()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Alumno ya ha sido registrada"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(alumno),
                false,
                200,
                "Alumno registrada correctamente"
        );
    }

    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Alumno> update(Alumno alumno){
        if(!this.repository.existsById(alumno.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Alumno no existe"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(alumno),
                false,
                200,
                "Alumno actualizada correctamente"
        );
    }

//    @Transactional(rollbackFor =  {SQLException.class})
//    public CustomResponse<Boolean> changeStatus(Alumno alumno){
//        if(!this.repository.existsById(alumno.getId())){
//            return new CustomResponse<>(
//                    null,
//                    true,
//                    400,
//                    "Alumno no existe"
//            );
//        }
//        return new CustomResponse<>(
//                this.repository.updateStatusById(
//                        alumno.getStatus(), alumno.getId())==1,
//                false,
//                200,
//                "Alumno actualizada correctamente"
//        );
//    }


}
