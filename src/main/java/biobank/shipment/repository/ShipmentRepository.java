package biobank.shipment.repository;

import org.springframework.data.repository.CrudRepository;

import biobank.shipment.domain.Shipment;

public interface ShipmentRepository extends CrudRepository<Shipment, Integer>{

}
