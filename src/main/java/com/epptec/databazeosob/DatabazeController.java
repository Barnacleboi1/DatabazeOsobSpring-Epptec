package com.epptec.databazeosob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/databaze")
public class DatabazeController {
    @Autowired
    DatabazeService databazeService = new DatabazeService();
    @PostMapping("/pridej")
    public ResponseEntity<?> pridejOsobu(@RequestBody Osoba osoba)  {
        return databazeService.pridejOsobu(osoba);
    }
    @DeleteMapping("/odeber")
    public ResponseEntity<?> odeberOsobu(@RequestParam String rodneCislo) {
        return databazeService.odeberOsobu(rodneCislo);
    }
    @GetMapping("/vyhledej")
    public ResponseEntity<?> vyhledejOsobu(@RequestParam String rodneCislo) {
        return databazeService.vyhledejOsobu(rodneCislo);
    }
}
