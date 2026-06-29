package com.torami.ToramiStore.domain.models.users;

import lombok.Getter;

@Getter
public class Ubigeo {
    private final Integer id;
    private final String code;
    private final String department;
    private final String province;
    private final String district;

    public Ubigeo(String code, String department) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Ubigeo code cannot be empty");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.id = null;
        this.code = code;
        this.department = department;
        this.province = null;
        this.district = null;
    }

    public Ubigeo(String code, String province, boolean isProvince) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Ubigeo code cannot be empty");
        }
        if (province == null || province.trim().isEmpty()) {
            throw new IllegalArgumentException("Province cannot be empty");
        }
        this.id = null;
        this.code = code;
        this.department = null;
        this.province = province;
        this.district = null;
    }

    public Ubigeo(String code, String district, String dummy) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Ubigeo code cannot be empty");
        }
        if (district == null || district.trim().isEmpty()) {
            throw new IllegalArgumentException("District cannot be empty");
        }
        this.id = null;
        this.code = code;
        this.department = null;
        this.province = null;
        this.district = district;
    }

    public Ubigeo(Integer id, String code, String department, String province, String district) {
        this.id = id;
        this.code = code;
        this.department = department;
        this.province = province;
        this.district = district;
    }
}