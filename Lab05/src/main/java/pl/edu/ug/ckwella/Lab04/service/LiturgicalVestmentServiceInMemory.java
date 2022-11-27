package pl.edu.ug.ckwella.Lab04.service;

import org.springframework.stereotype.Component;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class LiturgicalVestmentServiceInMemory implements LiturgicalVestmentService {

    List<LiturgicalVestment> db = new ArrayList<>();

    @Override
    public LiturgicalVestment addVestment(LiturgicalVestment vestment) {
        LiturgicalVestment vestmentToAdd = new LiturgicalVestment(UUID.randomUUID().toString(), vestment.getName(), vestment.getPrimaryColor(), vestment.getSecondaryColor(), vestment.getMaterial(), vestment.getLiningMaterial(), vestment.getCutType(), vestment.getSize(), vestment.getDescription());
        db.add(vestmentToAdd);
        return vestmentToAdd;
    }

    @Override
    public List<LiturgicalVestment> getAllVestments() {
        return db;
    }

    @Override
    public boolean deleteVestment(String id) {
        return db.removeIf(vestment -> vestment.getId().equals(id));
    }

    @Override
    public LiturgicalVestment editVestment(LiturgicalVestment vestment, String idOfVestmentToEdit) {
        LiturgicalVestment vestmentToEdit = findVestment(idOfVestmentToEdit);
        if (vestmentToEdit != null) {
            vestmentToEdit.setName(vestment.getName());
            vestmentToEdit.setPrimaryColor(vestment.getPrimaryColor());
            vestmentToEdit.setSecondaryColor(vestment.getSecondaryColor());
            vestmentToEdit.setMaterial(vestment.getMaterial());
            vestmentToEdit.setLiningMaterial(vestment.getLiningMaterial());
            vestmentToEdit.setCutType(vestment.getCutType());
            vestmentToEdit.setSize(vestment.getSize());
            vestmentToEdit.setDescription(vestment.getDescription());
        }
        return vestmentToEdit;
    }

    @Override
    public LiturgicalVestment findVestment(String id) {
        for(LiturgicalVestment vestment : db){
            if(vestment.getId().equals(id)){
                return vestment;
            }
        }
        return null;
    }
}
