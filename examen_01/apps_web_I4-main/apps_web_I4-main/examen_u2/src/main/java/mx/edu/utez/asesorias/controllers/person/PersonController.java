package mx.edu.utez.asesorias.controllers.person;

import mx.edu.utez.asesorias.models.person.Person;
import mx.edu.utez.asesorias.services.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api-market/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/")
    @GetMapping("/{id}")
    // api-market/person/?name=Mike
    public Person getOne(@NotNull @PathVariable("id") Long id,
                         @RequestParam("name") String name){
        return null;
    }
    @PostMapping("/")
    @PutMapping("/")
    @DeleteMapping("/")
}
