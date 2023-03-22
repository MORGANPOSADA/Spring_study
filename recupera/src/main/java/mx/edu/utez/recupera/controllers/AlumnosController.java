package mx.edu.utez.recupera.controllers;

import mx.edu.utez.recupera.dto.AlumnosDto;
import mx.edu.utez.recupera.models.Alumno;
import mx.edu.utez.recupera.service.AlumnosService;
import mx.edu.utez.recupera.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alumno/")
@CrossOrigin(origins = {"*"})
public class AlumnosController {
    @Autowired
    private AlumnosService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Alumno>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Alumno>> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<CustomResponse<Alumno>> insert(
            @RequestBody AlumnosDto alumnosDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.insert(alumnosDto.getDatos()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Alumno>> update(
            @RequestBody AlumnosDto alumnosDto, @Valid BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                this.service.update(alumnosDto.getDatos()),
                HttpStatus.CREATED
        );
    }

//    @PatchMapping("/")
//    public ResponseEntity<CustomResponse<Boolean>> enableOrDisable(
//            @RequestBody AlumnosDto alumnosDto) {
//        return new ResponseEntity<>(
//                this.service.changeStatus(alumnosDto.getDatos()),
//                HttpStatus.OK
//        );
//    }

}
