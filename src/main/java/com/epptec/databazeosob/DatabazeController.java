package com.epptec.databazeosob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databaze")
public class DatabazeController {
    @Autowired
    DatabazeService databazeService = new DatabazeService();
    @PostMapping("/pridej")
    public ResponseEntity<?> pridejOsobu(@RequestBody Osoba osoba)  {
        return databazeService.pridejOsobu(osoba);
    }

}
