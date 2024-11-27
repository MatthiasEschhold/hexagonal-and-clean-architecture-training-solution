package de.arkem.clean.arc.demo.garage.order.adapter.out.db;

import de.arkem.clean.arc.demo.garage.order.adapter.out.db.entity.GarageOrderDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageOrderJpaRepository extends JpaRepository<GarageOrderDbEntity, Integer> {
}
