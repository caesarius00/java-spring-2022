package pl.edu.ug.ckwella.Lab04.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.ckwella.Lab04.domain.Description;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalFunction;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;
import pl.edu.ug.ckwella.Lab04.domain.Material;
import pl.edu.ug.ckwella.Lab04.repository.LiturgicalVestmentRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LiturgicalVestmentService  {
    private final LiturgicalVestmentRepository liturgicalVestmentRepository;

    public LiturgicalVestmentService(LiturgicalVestmentRepository liturgicalVestmentRepository) {
        this.liturgicalVestmentRepository = liturgicalVestmentRepository;
    }

    public LiturgicalVestment addVestment(LiturgicalVestment vestment) {
        return liturgicalVestmentRepository.save(vestment);
    }

    public Iterable<LiturgicalVestment> getAllVestments() {
        return liturgicalVestmentRepository.findAll();
    }

    public boolean deleteVestment(long id) {
        liturgicalVestmentRepository.deleteById(id);
        return true;
    }

    public LiturgicalVestment getVestment(long id) {
        Optional<LiturgicalVestment> vestment = liturgicalVestmentRepository.findById(id);
        return vestment.orElse(null);
    }

    public LiturgicalVestment editVestment(LiturgicalVestment vestment, long idOfVestmentToEdit) {
        Optional<LiturgicalVestment> toEdit = liturgicalVestmentRepository.findById(idOfVestmentToEdit);
        if (toEdit.isPresent()) {
            toEdit.get().setName(vestment.getName());
            toEdit.get().setPrimaryColor(vestment.getPrimaryColor());
            toEdit.get().setSecondaryColor(vestment.getSecondaryColor());
            toEdit.get().setMaterial(vestment.getMaterial());
            toEdit.get().setLiningMaterial(vestment.getLiningMaterial());
            toEdit.get().setCutType(vestment.getCutType());
            toEdit.get().setSize(vestment.getSize());
            toEdit.get().setDescription(vestment.getDescription());
            liturgicalVestmentRepository.save(toEdit.get());
            return toEdit.get();
        }
        return null;
    }

    public void learning(){
        LiturgicalVestment vestment = new LiturgicalVestment("kapa", "czarny", "złoty", "gotycki", "M");

        Description description = new Description("Brak uszkodzeń","Bardzo ładna kapa");
        vestment.setDescription(description);

        LiturgicalFunction liturgicalFunction = new LiturgicalFunction("Diakon", "just a regular diakon");
        ArrayList<LiturgicalFunction> guyToAdd = new ArrayList<>();
        guyToAdd.add(liturgicalFunction);
        vestment.setUsers(guyToAdd);

        Material material = new Material("linen", 3, 10);
        vestment.setMaterial(material);

        Material liningMaterial = new Material("cotton", 5, 13);
        vestment.setLiningMaterial(liningMaterial);

        LiturgicalVestment x = liturgicalVestmentRepository.save(vestment);

        LiturgicalVestment vest1 = new LiturgicalVestment("ornat", "biały", "żółty", "rzymski", "L");
        LiturgicalVestment y = liturgicalVestmentRepository.save(vest1);
        liturgicalVestmentRepository.delete(y);

        List<LiturgicalVestment> z = liturgicalVestmentRepository.findByCutType("gotycki");
        System.out.println(z);

        List<LiturgicalVestment> a = liturgicalVestmentRepository.findByCutTypeOrPrimaryColor("gotycki", "czarny");
        System.out.println(a);

        List<LiturgicalVestment> b = liturgicalVestmentRepository.findByCutTypeAndSize("gotycki", "M");
        System.out.println(b);


        System.out.println(liturgicalVestmentRepository.findById(x.getId()));
    }
}
