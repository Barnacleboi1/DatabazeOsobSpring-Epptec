package com.epptec.databazeosob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class DatabazeController {
    @Autowired
    DatabazeService databazeService = new DatabazeService();
    @PostMapping
    public ResponseEntity<?> pridejOsobu(@RequestBody Osoba osoba)  {
        try {
            return databazeService.pridejOsobu(osoba);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Osoba nebyla přidána: " + e.getMessage());
        }
    }
    @DeleteMapping("/{rodneCislo}")
    public ResponseEntity<?> odeberOsobu(@PathVariable String rodneCislo) {
        try {
            return databazeService.odeberOsobu(rodneCislo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Osoba nebyla úspěšně odebrána: " + e.getMessage());
        }
    }
    @GetMapping("/{rodneCislo}")
    public ResponseEntity<?> vyhledejOsobu(@PathVariable String rodneCislo) {
        try {
            return databazeService.vyhledejOsobu(rodneCislo);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Osoba nebyla vyhledána: " + e.getMessage());
        }
    }
}
