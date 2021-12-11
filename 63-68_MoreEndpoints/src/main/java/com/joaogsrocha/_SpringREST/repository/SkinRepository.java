package com.joaogsrocha._SpringREST.repository;

import com.joaogsrocha._SpringREST.model.skin.Skin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@CrossOrigin("http://localhost:4200")
public interface SkinRepository extends JpaRepository<Skin, Long> {
    Page<Skin> findByExpansionId(@RequestParam("id") Long id, Pageable pageable);
    Page<Skin> findByExpansionIdAndUnitsInStockBetweenAndPriceBetweenAndRarityContainingIgnoreCaseAndConditionContainingIgnoreCase(
            @RequestParam("id") Long id,
            @RequestParam("stockMin") Integer stockMin,
            @RequestParam("stockMax") Integer stockMax,
            @RequestParam("price1") BigDecimal price1,
            @RequestParam("price2") BigDecimal price2,
            String rarity,
            String condition,
            Pageable pageable);
    Page<Skin> findByUnitsInStockBetweenAndPriceBetweenAndRarityContainingIgnoreCaseAndConditionContainingIgnoreCase(
            @RequestParam("stockMin") Integer stockMin,
            @RequestParam("stockMax") Integer stockMax,
            @RequestParam("price1") BigDecimal price1,
            @RequestParam("price2") BigDecimal price2,
            String rarity,
            String condition,
            Pageable pageable);
    Page<Skin> findByExpansionIdAndUnitsInStockBetween(
            @RequestParam("id") Long id,
            @RequestParam("stockMin") Integer stockMin,
            @RequestParam("stockMax") Integer stockMax,
            Pageable pageable);
    Page<Skin> findByUnitsInStockBetween(
            @RequestParam("stockMin") Integer stockMin,
            @RequestParam("stockMax") Integer stockMax,
            Pageable pageable);
    Page<Skin> findByPriceBetween(
            @RequestParam("price1") BigDecimal price1,
            @RequestParam("price2") BigDecimal price2,
            Pageable pageable);
    Page<Skin> findByRarityContainingIgnoreCase(String rarity,
            Pageable pageable);
    Page<Skin> findByConditionContainingIgnoreCase(String condition,
                                                Pageable pageable);
}
