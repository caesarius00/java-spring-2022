package pl.edu.ug.ckwella.Lab04.controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;
import pl.edu.ug.ckwella.Lab04.service.LiturgicalVestmentService;

import java.util.List;

@RestController
public class LiturgicalVestmentController{
    private final LiturgicalVestmentService service;

    public LiturgicalVestmentController(LiturgicalVestmentService service) {
        this.service = service;
    }

    @GetMapping("/api/liturgicalVestments")
    Iterable<LiturgicalVestment> getAllVestments(){
        return service.getAllVestments();
    }

    @PostMapping("/api/liturgicalVestments")
    LiturgicalVestment addVestment(@RequestBody LiturgicalVestment vestment){
        return service.addVestment(vestment);
    }

    @PutMapping("/api/liturgicalVestments/{id}")
    LiturgicalVestment updateVestment(@RequestBody LiturgicalVestment vestment, @PathVariable("id") Long id){
        return service.editVestment(vestment, id);
    }

    @DeleteMapping("/api/liturgicalVestments/{id}")
    boolean deleteVestment(@PathVariable("id") Long id){
        return service.deleteVestment(id);
    }

    @GetMapping("/api/liturgicalVestments/{id}")
    LiturgicalVestment getVestment(@PathVariable("id") Long id){
        return service.getVestment(id);
    }


}
