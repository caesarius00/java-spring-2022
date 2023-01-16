package pl.edu.ug.ckwella.kolokwium.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.ckwella.kolokwium.domain.Scarf;
import pl.edu.ug.ckwella.kolokwium.repository.ScarfRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ScarfService {

    private final ScarfRepository scarfRepository;

    public ScarfService(ScarfRepository scarfRepository) {
        this.scarfRepository = scarfRepository;
    }

    public Scarf addScarf(Scarf scarf) {
        return scarfRepository.save(scarf);
    }

    public Iterable<Scarf> getAllScarfs() {
        return scarfRepository.findAll();
    }

    public boolean deleteScarf(long id) {
        scarfRepository.deleteById(id);
        return true;
    }

    public Scarf editScarf(Scarf scarf, long id) {
        Optional<Scarf> oldScarf = scarfRepository.findById(id);
        if(oldScarf.isPresent()){
            oldScarf.get().setColor(scarf.getColor());
            oldScarf.get().setMaterial(scarf.getMaterial());
            oldScarf.get().setName(scarf.getName());
            oldScarf.get().setSize(scarf.getSize());
            return oldScarf.get();
        }
        return null;
    }

    public Scarf getScarf(long id) {
        Optional<Scarf> scarf = scarfRepository.findById(id);
        return scarf.orElse(null);
    }


    public void learning() {
        System.out.println("WORKING");
    }
}
