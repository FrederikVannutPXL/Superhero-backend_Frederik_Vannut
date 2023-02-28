package be.pxl.ja.superherobackend.repository;

import be.pxl.ja.superherobackend.Domain.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperheroRepository extends JpaRepository<Superhero,Long> {
}
