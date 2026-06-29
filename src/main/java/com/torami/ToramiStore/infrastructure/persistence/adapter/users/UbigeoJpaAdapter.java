package com.torami.ToramiStore.infrastructure.persistence.adapter.users;

import com.torami.ToramiStore.application.port.out.users.IUbigeoRepository;
import com.torami.ToramiStore.domain.models.users.Ubigeo;
import com.torami.ToramiStore.infrastructure.persistence.repository.users.UbigeoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UbigeoJpaAdapter implements IUbigeoRepository {

    private final UbigeoJpaRepository ubigeoRepository;

    @Override
    public List<Ubigeo> findAllDepartments() {
        return ubigeoRepository.findAllDepartments().stream()
                .map(row -> new Ubigeo((String) row[0], (String) row[1]))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ubigeo> findProvincesByDepartment(String departmentId) {
        return ubigeoRepository.findProvincesByDepartment(departmentId).stream()
                .map(row -> new Ubigeo((String) row[0], (String) row[1], true))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ubigeo> findDistrictsByProvince(String provinceId) {
        return ubigeoRepository.findDistrictsByProvince(provinceId).stream()
                .map(row -> new Ubigeo((String) row[0], (String) row[1], ""))
                .collect(Collectors.toList());
    }

    @Override
    public String findDistrictNameById(String districtId) {
        return ubigeoRepository.findDistrictNameById(districtId);
    }
}