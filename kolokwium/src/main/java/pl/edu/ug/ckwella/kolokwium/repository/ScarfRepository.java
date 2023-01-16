package pl.edu.ug.ckwella.kolokwium.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ckwella.kolokwium.domain.Scarf;

import java.util.List;

@Repository
public interface ScarfRepository extends CrudRepository<Scarf, Long> {

    List<Scarf> findByMaterial(String material);


}
