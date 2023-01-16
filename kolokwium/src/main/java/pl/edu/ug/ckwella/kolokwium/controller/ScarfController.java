package pl.edu.ug.ckwella.kolokwium.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ckwella.kolokwium.domain.Scarf;
import pl.edu.ug.ckwella.kolokwium.service.ScarfService;

@RestController
public class ScarfController {
    private final ScarfService service;

    public ScarfController(ScarfService service) {
        this.service = service;
    }

//    @GetMapping("/api/liturgicalVestments")
//    Iterable<Scarf> getAllVestments(){
//        return service.getAllScarfs();
//    }

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
