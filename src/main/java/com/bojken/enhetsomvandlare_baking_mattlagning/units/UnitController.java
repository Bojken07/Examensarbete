package com.bojken.enhetsomvandlare_baking_mattlagning.units;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UnitController {

    private UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping("/api/v1/auth/getAllUnits")
    public ResponseEntity<List<Unit>>getAllUnits() {
        return unitService.getAllUnits();
    }
}
