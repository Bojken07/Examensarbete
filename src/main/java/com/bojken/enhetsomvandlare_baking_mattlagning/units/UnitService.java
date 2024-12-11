package com.bojken.enhetsomvandlare_baking_mattlagning.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UnitService {

    private UnitRepository unitRepository;

    @Autowired
    public UnitService(unitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }
    public ResponseEntity<List<Unit>> getAllUnits() {
        try {
            List<Unit> units = new ArrayList<>();
            unitRepository.findAll().forEach(units::add);
            if (units.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(units, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Unit> create(Unit unit) {
        Optional<Unit> unitOptional = unitRepository.existsByName(unit.getUnitName());
        if (unitOptional.isPresent()){
            return  new ResponseEntity("Unit already exist", HttpStatus.BAD_REQUEST);
        }
        unitRepository.save(unit);
        return new ResponseEntity("insert ok", HttpStatus.OK);
    }
}
