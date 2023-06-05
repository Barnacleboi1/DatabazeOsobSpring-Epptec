package com.epptec.databazeosob;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;


import java.util.HashMap;
import java.util.Map;


@Service
public class DatabazeService {
    private Map<String, Osoba> databaze = new HashMap<>();
    public ResponseEntity<?> pridejOsobu(Osoba osoba) {
        if (!osoba.getRodneCislo().matches("\\d{6}/?\\d{4}")) {
            return new ResponseEntity<>(Map.of("Chyba", "Rodné číslo musí být ve formátu YYMMDD/XXX nebo YYMMDDXXX")
                    , HttpStatus.BAD_REQUEST);
        }
        if (databaze.containsKey(osoba.getRodneCislo())) {
            return new ResponseEntity<>(Map.of("Chyba", "Tato osoba už v databázi je."), HttpStatus.BAD_REQUEST);
        } else {
            databaze.put(osoba.getRodneCislo(), osoba);
            return ResponseEntity.ok("Osoba byla přidána úspěšně.");
        }
    }
}
