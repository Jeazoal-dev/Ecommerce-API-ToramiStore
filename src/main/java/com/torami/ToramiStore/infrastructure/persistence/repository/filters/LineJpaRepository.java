package com.torami.ToramiStore.infrastructure.persistence.repository.filters;

import com.torami.ToramiStore.infrastructure.persistence.entity.filters.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineJpaRepository extends JpaRepository<LineEntity, Integer> {
}
