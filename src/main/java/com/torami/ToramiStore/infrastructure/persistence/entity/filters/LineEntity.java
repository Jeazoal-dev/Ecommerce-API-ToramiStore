package com.torami.ToramiStore.infrastructure.persistence.entity.filters;

import com.torami.ToramiStore.infrastructure.persistence.entity.products.FigureEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "line", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FigureEntity> figures = new ArrayList<>();
}
