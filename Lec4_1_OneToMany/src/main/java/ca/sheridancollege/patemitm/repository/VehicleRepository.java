package ca.sheridancollege.patemitm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.patemitm.beans.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
