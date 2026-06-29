package com.torami.ToramiStore.infrastructure.persistence.entity.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ubigeo_districts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UbigeoEntity {
    @Id
    private String id;
    private String name;
    @Column(name = "province_id")
    private String provinceId;
    @Column(name = "department_id")
    private String departmentId;
}
