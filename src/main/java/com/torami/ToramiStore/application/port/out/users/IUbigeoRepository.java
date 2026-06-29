package com.torami.ToramiStore.application.port.out.users;

import com.torami.ToramiStore.domain.models.users.Ubigeo;

import java.util.List;

public interface IUbigeoRepository {
    List<Ubigeo> findAllDepartments();

    List<Ubigeo> findProvincesByDepartment(String departmentId);

    List<Ubigeo> findDistrictsByProvince(String provinceId);

    String findDistrictNameById(String districtId);
}