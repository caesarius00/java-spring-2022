package pl.edu.ug.ckwella.Lab04.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;
import pl.edu.ug.ckwella.Lab04.service.LiturgicalVestmentService;

import java.util.List;

@RestController
public class LiturgicalVestmentController {

    private final LiturgicalVestmentService vestmentService;


    public LiturgicalVestmentController(@Autowired LiturgicalVestmentService vestmentService) {
        this.vestmentService = vestmentService;
    }

    @PostMapping("api/vestment")
    public ResponseEntity<LiturgicalVestment> addVestment(@RequestBody LiturgicalVestment vestment){
        LiturgicalVestment vest = vestmentService.addVestment(vestment);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/vestment/" + vest.getId());

        return new ResponseEntity<>(vest, headers, HttpStatus.CREATED);

    }

    @DeleteMapping("api/vestment/{id}")
    public boolean deleteVestment(@PathVariable String id){
        if (vestmentService.findVestment(id) == null) {
            throw new VestmentNotFoundException();
        }
       return vestmentService.deleteVestment(id);
    }

    @GetMapping("api/vestment")
    public List<LiturgicalVestment> getAllVestments(){
        return vestmentService.getAllVestments();
    }

    @PutMapping("api/vestment/{id}")
    public LiturgicalVestment editVestment(@RequestBody LiturgicalVestment vestment, @PathVariable String id){
        if (vestmentService.findVestment(id) == null) {
            throw new VestmentNotFoundException();
        }
        return vestmentService.editVestment(vestment, id);
    }

    @GetMapping("api/vestment/{id}")
    public LiturgicalVestment findVestment(@PathVariable String id){
        LiturgicalVestment vestment = vestmentService.findVestment(id);
        if (vestment == null) {
            throw new VestmentNotFoundException();
        }
        return vestment;
    }


}
