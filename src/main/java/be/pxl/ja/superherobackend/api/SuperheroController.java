package be.pxl.ja.superherobackend.api;

import be.pxl.ja.superherobackend.Domain.Superhero;
import be.pxl.ja.superherobackend.service.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
public class SuperheroController {
    private final SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }
    @GetMapping()
    public List<SuperheroDTO> getAllSuperheroes(){
        return superheroService.findAllSuperheroes();
    }
    @GetMapping("/{superheroId}")
    public SuperheroDTO getSuperheroById(@PathVariable Long superheroId){
        return superheroService.findSuperheroById(superheroId);
    }
    @PostMapping
    public ResponseEntity<Long> createSuperhero(@RequestBody SuperheroRequest superheroRequest){
        return new ResponseEntity<>(superheroService.createSuperhero(superheroRequest), HttpStatus.CREATED);
    }
    @PutMapping("/{superheroId}")
    public SuperheroDTO updateSuperhero(@PathVariable Long superheroId, @RequestBody SuperheroRequest superheroRequest){
        return superheroService.updateSuperhero(superheroId,superheroRequest);
    }
    @DeleteMapping("/{superheroId}")
    public ResponseEntity<Void> deleteSuperhero(@PathVariable Long superheroId){
        boolean deleted = superheroService.deleteSuperhero(superheroId);
        return deleted? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
