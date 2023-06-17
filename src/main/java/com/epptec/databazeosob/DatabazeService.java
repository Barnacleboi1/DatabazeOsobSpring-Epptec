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
            throw new IllegalArgumentException("Zadávejte rodné číslo ve formátu YYMMDDXXXX nebo YYMMDD/XXXX.");
        }
        if (databaze.containsKey(osoba.getRodneCislo())) {
            throw new IllegalArgumentException("Tato osoba již v databázi je.");
        } else {
            databaze.put(osoba.getRodneCislo(), osoba);
            return ResponseEntity.ok("Osoba byla přidána úspěšně.");
        }
    }
    public ResponseEntity<?> odeberOsobu(String rodneCislo) {
        rodneCislo = rodneCislo.replace("/", "");
        if (!databaze.containsKey(rodneCislo)) {
            throw new IllegalArgumentException("Tato osoba v databázi není.");
        } else {
            databaze.remove(rodneCislo);
            return ResponseEntity.ok("Osoba byla úspěšně odebrána");
        }
    }
    public ResponseEntity<?> vyhledejOsobu(String rodneCislo) {
        rodneCislo = rodneCislo.replace("/", "");
        if (!databaze.containsKey(rodneCislo)) {
            throw new IllegalArgumentException("Tato osoba v databázi není.");
        } else {
            return ResponseEntity.ok(databaze.get(rodneCislo));
        }
    }
}
