package tn.microservices.RendezvousMicroService.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.microservices.RendezvousMicroService.Dto.RendezDto;
import tn.microservices.RendezvousMicroService.Entity.RendezVous;
import tn.microservices.RendezvousMicroService.Service.ServiceRendez;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class RendezController {


    private final ServiceRendez serviceRendez;

    @PostMapping("/Add")
    ResponseEntity<RendezDto> Create(@ModelAttribute RendezDto rendezDto) throws IOException {
        RendezDto rendezVous = serviceRendez.addrendezvous(rendezDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(rendezVous);
    }
    @GetMapping("")
    ResponseEntity<List<RendezDto>> GetAll(){
        List<RendezDto> list = serviceRendez.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<RendezDto> getcatById(@PathVariable Long id){
        RendezDto itemsDto = serviceRendez.getItemById(id);
        if (itemsDto != null){
            return ResponseEntity.ok(itemsDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Update/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RendezDto> updateItem(@PathVariable Long id ,@ModelAttribute RendezDto itemsDto) throws IOException {
        RendezDto itemDto1 = serviceRendez.updateDto(id,itemsDto);
        if (itemDto1 != null){
            return ResponseEntity.ok(itemDto1);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteitem(@PathVariable Long id){
        boolean delete = serviceRendez.delete(id);
        if (delete){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
