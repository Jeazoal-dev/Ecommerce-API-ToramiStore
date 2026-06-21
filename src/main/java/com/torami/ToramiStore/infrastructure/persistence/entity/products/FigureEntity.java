package com.torami.ToramiStore.infrastructure.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

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
}
