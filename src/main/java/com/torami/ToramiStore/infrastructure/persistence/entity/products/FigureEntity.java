package com.torami.ToramiStore.infrastructure.persistence.entity.products;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.CategoryEntity;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.LineEntity;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.ManufacturerEntity;
import com.torami.ToramiStore.infrastructure.persistence.entity.filters.SerieEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "figures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FigureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private Integer code;

    private String name;
    private Double price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "line_id")
    private LineEntity line;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerEntity manufacturer;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private SerieEntity serie;

}
