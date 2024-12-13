package com.bojken.enhetsomvandlare_baking_mattlagning.units;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnitRepository extends JpaRepository <Unit, Long> {

    @Query("SELECT u FROM Unit u WHERE u.unitName = ?1")
    Optional<Unit> existByName(String unitName);
}
