package pl.edu.ug.ckwella.Lab04.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;

import java.util.List;

@Repository
public interface LiturgicalVestmentRepository extends CrudRepository<LiturgicalVestment, Long> {

    List<LiturgicalVestment> findByCutType(String cutType);

    List<LiturgicalVestment> findByCutTypeAndSize(String cutType, String size);

    List<LiturgicalVestment> findByCutTypeOrPrimaryColor(String cutType, String primaryColor);
}
