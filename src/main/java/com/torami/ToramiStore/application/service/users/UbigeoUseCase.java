package com.torami.ToramiStore.application.service.users;

import com.torami.ToramiStore.application.port.in.users.IUbigeoService;
import com.torami.ToramiStore.application.port.out.users.IUbigeoRepository;
import com.torami.ToramiStore.domain.models.users.Ubigeo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UbigeoUseCase implements IUbigeoService {

    private final IUbigeoRepository ubigeoRepository;

    @Override
    public List<Ubigeo> getAllDepartments() {
        return ubigeoRepository.findAllDepartments();
    }

    @Override
    public List<Ubigeo> getProvincesByDepartment(String departmentId) {
        return ubigeoRepository.findProvincesByDepartment(departmentId);
    }

    @Override
    public List<Ubigeo> getDistrictsByProvince(String provinceId) {
        return ubigeoRepository.findDistrictsByProvince(provinceId);
    }

    @Override
    public String getDistrictNameById(String districtId) {
        return ubigeoRepository.findDistrictNameById(districtId);
    }
}
