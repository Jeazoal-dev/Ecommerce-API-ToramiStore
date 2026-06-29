package com.torami.ToramiStore.infrastructure.persistence.repository.products;

import com.torami.ToramiStore.infrastructure.persistence.entity.products.FigureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FigureJpaRepository extends JpaRepository<FigureEntity, Integer> {

    @Query("SELECT f FROM FigureEntity f WHERE " +
            "(:keyword IS NULL OR LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
            "(:categoryId IS NULL OR f.category.id = :categoryId) AND " +
            "(:manufacturerId IS NULL OR f.manufacturer.id = :manufacturerId) AND " +
            "(:lineId IS NULL OR f.line.id = :lineId) AND " +
            "(:serieId IS NULL OR f.serie.id = :serieId) AND " +
            "(:minPrice IS NULL OR f.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR f.price <= :maxPrice) AND " +
            "(:inStock IS NULL OR f.quantity > 0)")
    Page<FigureEntity> searchFigures(
            @Param("keyword") String keyword,
            @Param("categoryId") Integer categoryId,
            @Param("manufacturerId") Integer manufacturerId,
            @Param("lineId") Integer lineId,
            @Param("serieId") Integer serieId,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            @Param("inStock") Boolean inStock,
            Pageable pageable);
}

