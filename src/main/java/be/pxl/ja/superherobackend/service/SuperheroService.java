package be.pxl.ja.superherobackend.service;

import be.pxl.ja.superherobackend.api.SuperheroDTO;
import be.pxl.ja.superherobackend.api.SuperheroRequest;

import java.util.List;

public interface SuperheroService {
    List<SuperheroDTO> findAllSuperheroes();
    SuperheroDTO findSuperheroById(Long superheroId);
    Long createSuperhero(SuperheroRequest superheroRequest);
    SuperheroDTO updateSuperhero(Long superheroId, SuperheroRequest superheroRequest);
    boolean deleteSuperhero(Long superheroId);
}
