package com.torami.ToramiStore.application.port.in.users;

import com.torami.ToramiStore.domain.models.users.Ubigeo;

import java.util.List;

public interface IUbigeoService {

    List<Ubigeo> getAllDepartments();

    List<Ubigeo> getProvincesByDepartment(String departmentId);

    List<Ubigeo> getDistrictsByProvince(String provinceId);

    String getDistrictNameById(String districtId);
}
