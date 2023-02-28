package be.pxl.ja.superherobackend.service.impl;

import be.pxl.ja.superherobackend.Domain.Superhero;
import be.pxl.ja.superherobackend.Exception.ResourceNotFoundException;
import be.pxl.ja.superherobackend.api.SuperheroDTO;
import be.pxl.ja.superherobackend.api.SuperheroRequest;
import be.pxl.ja.superherobackend.repository.SuperheroRepository;
import be.pxl.ja.superherobackend.service.SuperheroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    private final SuperheroRepository superheroRepository;
    public SuperheroServiceImpl(SuperheroRepository superheroRepository){
        this.superheroRepository = superheroRepository;
    }
    @Override
    public List<SuperheroDTO> findAllSuperheroes() {
        return superheroRepository.findAll()
                .stream().map(SuperheroDTO::new)
                .toList();
    }

    @Override
    public SuperheroDTO findSuperheroById(Long superheroId) {
        return superheroRepository.findById(superheroId)
                .map(SuperheroDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Superhero", "ID", superheroId));

    }

    @Override
    public Long createSuperhero(SuperheroRequest superheroRequest) {
        Superhero superhero = new Superhero();
        superhero.setFirstName(superheroRequest.getFirstName());
        superhero.setLastName(superheroRequest.getLastName());
        superhero.setSuperheroName(superheroRequest.getSuperheroName());
        Superhero newSuperhero = superheroRepository.save(superhero);
        return newSuperhero.getId();
    }

    @Override
    public SuperheroDTO updateSuperhero(Long superheroId, SuperheroRequest superheroRequest) {
        return superheroRepository.findById(superheroId).map(superhero -> {
            superhero.setFirstName(superheroRequest.getFirstName());
            superhero.setLastName(superheroRequest.getLastName());
            superhero.setSuperheroName(superheroRequest.getSuperheroName());
            return new SuperheroDTO(superheroRepository.save(superhero));
        }).orElseThrow(() -> new ResourceNotFoundException("Superhero","id", superheroId));

    }

    @Override
    public boolean deleteSuperhero(Long superheroId) {
        return superheroRepository.findById(superheroId)
                .map(superhero -> {
                    superheroRepository.delete(superhero);
                    return true;
                }).orElseThrow(() -> new ResourceNotFoundException("Superhero", "id", superheroId));

    }
}
