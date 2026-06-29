package com.torami.ToramiStore.infrastructure.persistence.repository.users;

import com.torami.ToramiStore.infrastructure.persistence.entity.users.UbigeoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbigeoJpaRepository extends JpaRepository<UbigeoEntity, String> {

    @Query(value = "SELECT id, name FROM ubigeo_departments ORDER BY name", nativeQuery = true)
    List<Object[]> findAllDepartments();

    @Query(value = "SELECT id, name FROM ubigeo_provinces WHERE department_id = :departmentId ORDER BY name", nativeQuery = true)
    List<Object[]> findProvincesByDepartment(@Param("departmentId") String departmentId);

    @Query(value = "SELECT id, name FROM ubigeo_districts WHERE province_id = :provinceId ORDER BY name", nativeQuery = true)
    List<Object[]> findDistrictsByProvince(@Param("provinceId") String provinceId);

    @Query("SELECT u.name FROM UbigeoEntity u WHERE u.id = :id")
    String findDistrictNameById(@Param("id") String id);
}
