package com.torami.ToramiStore.infrastructure.controller;

import com.torami.ToramiStore.application.port.in.users.IUbigeoService;
import com.torami.ToramiStore.domain.models.users.Ubigeo;
import com.torami.ToramiStore.infrastructure.dto.response.ApiResponse;
import com.torami.ToramiStore.infrastructure.dto.response.users.UbigeoResponse;
import com.torami.ToramiStore.infrastructure.persistence.mapper.users.UbigeoMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ubigeo")
@RequiredArgsConstructor
public class UbigeoController {

    private final IUbigeoService ubigeoService;
    private final UbigeoMapper ubigeoMapper;

    @GetMapping("/departments")
    public ResponseEntity<ApiResponse<List<UbigeoResponse>>> getDepartments(HttpServletRequest request) {
        List<Ubigeo> departments = ubigeoService.getAllDepartments();
        List<UbigeoResponse> data = ubigeoMapper.toDepartmentResponse(departments);

        ApiResponse<List<UbigeoResponse>> response = ApiResponse.success(
                data,
                "Departments retrieved successfully",
                request.getRequestURI()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/provinces/{departmentId}")
    public ResponseEntity<ApiResponse<List<UbigeoResponse>>> getProvinces(
            @PathVariable String departmentId,
            HttpServletRequest request) {
        List<Ubigeo> provinces = ubigeoService.getProvincesByDepartment(departmentId);
        List<UbigeoResponse> data = ubigeoMapper.toProvinceResponse(provinces);

        ApiResponse<List<UbigeoResponse>> response = ApiResponse.success(
                data,
                "Provinces retrieved successfully",
                request.getRequestURI()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/districts/{provinceId}")
    public ResponseEntity<ApiResponse<List<UbigeoResponse>>> getDistricts(
            @PathVariable String provinceId,
            HttpServletRequest request) {
        List<Ubigeo> districts = ubigeoService.getDistrictsByProvince(provinceId);
        List<UbigeoResponse> data = ubigeoMapper.toDistrictResponse(districts);

        ApiResponse<List<UbigeoResponse>> response = ApiResponse.success(
                data,
                "Districts retrieved successfully",
                request.getRequestURI()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/district/{districtId}/name")
    public ResponseEntity<ApiResponse<UbigeoResponse>> getDistrictName(
            @PathVariable String districtId,
            HttpServletRequest request) {
        String name = ubigeoService.getDistrictNameById(districtId);
        UbigeoResponse data = new UbigeoResponse(districtId, name != null ? name : districtId);

        ApiResponse<UbigeoResponse> response = ApiResponse.success(
                data,
                "District name retrieved successfully",
                request.getRequestURI()
        );
        return ResponseEntity.ok(response);
    }
}