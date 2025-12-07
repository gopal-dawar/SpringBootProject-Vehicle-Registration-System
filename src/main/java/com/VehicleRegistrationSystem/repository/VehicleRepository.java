package com.VehicleRegistrationSystem.repository;

import com.VehicleRegistrationSystem.entity.Vehicles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicles, Integer> {

    @Query(value = "Select * from Vehicles where model =:model", nativeQuery = true)
    public List<Vehicles> findByModelNumber(@Param("model") String model);


    @Query(value = "Select * from Vehicles where registration_year =:registration_year", nativeQuery = true)
    public List<Vehicles> findByYear(@Param("registration_year") int registration_year);

}
