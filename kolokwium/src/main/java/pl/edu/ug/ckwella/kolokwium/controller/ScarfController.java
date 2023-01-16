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

    @GetMapping("/api/scarfs")
    Iterable<Scarf> getAllVestments(){
        return service.getAllScarfs();
    }

    @PostMapping("/api/scarfs")
    Scarf addScarf(@RequestBody Scarf scarf){
        return service.addScarf(scarf);
    }

    @PutMapping("/api/scarfs/{id}")
    Scarf updateVestment(@RequestBody Scarf scarf, @PathVariable("id") Long id){
        return service.editScarf(scarf, id);
    }

    @DeleteMapping("/api/scarfs/{id}")
    boolean deleteScarf(@PathVariable("id") Long id){
        return service.deleteScarf(id);
    }

    @GetMapping("/api/liturgicalVestments/{id}")
    Scarf getScarf(@PathVariable("id") Long id){
        return service.getScarf(id);
    }


}
