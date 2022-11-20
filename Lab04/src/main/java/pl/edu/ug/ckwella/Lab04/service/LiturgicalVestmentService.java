package pl.edu.ug.ckwella.Lab04.service;

import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;

import java.util.List;

public interface LiturgicalVestmentService {

    LiturgicalVestment addVestment(LiturgicalVestment vestment);

    List<LiturgicalVestment> getAllVestments();

    boolean deleteVestment(String id);

    LiturgicalVestment editVestment(LiturgicalVestment vestment, String idOfVestmentToEdit);

    LiturgicalVestment findVestment(String id);



}
