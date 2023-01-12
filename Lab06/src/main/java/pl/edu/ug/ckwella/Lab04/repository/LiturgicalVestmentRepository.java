package pl.edu.ug.ckwella.Lab04.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;

import java.util.List;

@Repository
public interface LiturgicalVestmentRepository extends CrudRepository<LiturgicalVestment, Long> {

    List<LiturgicalVestment> findByCutType(String cutType);

    List<LiturgicalVestment> findByCutTypeAndSize(String cutType, String size);

    List<LiturgicalVestment> findByCutTypeOrPrimaryColor(String cutType, String primaryColor);

    @Query("SELECT l FROM LiturgicalVestment l WHERE l.material.density < ?1 ")
    List<LiturgicalVestment> getByMaterialHavingLessThicknessThan(double thickness);

    @Query("SELECT l FROM LiturgicalVestment l WHERE l.description.damages IS NOT NULL")
    List<LiturgicalVestment> getByDescriptionHavingDamages();

    @Query("SELECT l FROM LiturgicalVestment l JOIN l.users u WHERE u.name = ?1")
    List<LiturgicalVestment> getByUser(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM Liturgical_Vestment WHERE SIZE=?")
    List<LiturgicalVestment> getBySize(String size);

}
