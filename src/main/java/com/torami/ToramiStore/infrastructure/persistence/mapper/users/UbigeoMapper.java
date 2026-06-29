package com.torami.ToramiStore.infrastructure.persistence.mapper.users;

import com.torami.ToramiStore.domain.models.users.Ubigeo;
import com.torami.ToramiStore.infrastructure.dto.response.users.UbigeoResponse;
import com.torami.ToramiStore.infrastructure.persistence.repository.users.UbigeoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UbigeoMapper {

    private final UbigeoJpaRepository ubigeoRepository;

    public UbigeoResponse toResponse(Ubigeo ubigeo) {
        if (ubigeo == null) return null;

        if (ubigeo.getDistrict() != null && !ubigeo.getDistrict().isEmpty()) {
            String name = ubigeoRepository.findDistrictNameById(ubigeo.getDistrict());
            return new UbigeoResponse(ubigeo.getDistrict(), name != null ? name : ubigeo.getDistrict());
        }

        if (ubigeo.getProvince() != null && !ubigeo.getProvince().isEmpty()) {
            return new UbigeoResponse(ubigeo.getCode(), ubigeo.getProvince());
        }

        return new UbigeoResponse(ubigeo.getCode(), ubigeo.getDepartment());
    }

    public List<UbigeoResponse> toDepartmentResponse(List<Ubigeo> departments) {
        return departments.stream()
                .map(u -> new UbigeoResponse(u.getCode(), u.getDepartment()))
                .collect(Collectors.toList());
    }

    public List<UbigeoResponse> toProvinceResponse(List<Ubigeo> provinces) {
        return provinces.stream()
                .map(u -> new UbigeoResponse(u.getCode(), u.getProvince()))
                .collect(Collectors.toList());
    }

    public List<UbigeoResponse> toDistrictResponse(List<Ubigeo> districts) {
        return districts.stream()
                .map(u -> new UbigeoResponse(u.getCode(), u.getDistrict()))
                .collect(Collectors.toList());
    }
}