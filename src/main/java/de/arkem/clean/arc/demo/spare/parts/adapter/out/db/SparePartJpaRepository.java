package de.arkem.clean.arc.demo.spare.parts.adapter.out.db;

import de.arkem.clean.arc.demo.spare.parts.adapter.out.db.entity.SparePartDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartJpaRepository extends JpaRepository<SparePartDbEntity, Long> {
}
