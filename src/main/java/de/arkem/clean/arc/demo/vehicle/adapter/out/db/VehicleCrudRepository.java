package de.arkem.clean.arc.demo.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.vehicle.adapter.out.db.entity.VehicleDbEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface VehicleCrudRepository extends CrudRepository<VehicleDbEntity, String> {
    @Query("SELECT v FROM VehicleDbEntity v WHERE v.licensePlate = :licensePlate")
    Optional<VehicleDbEntity> findByLicensePlate(@Param("licensePlate") String licensePlate);
}
