package biobank.shipment.repository;

import org.springframework.data.repository.CrudRepository;

import biobank.shipment.domain.StaticShipmentStatus;

public interface StaticShipmentStatusRepository extends CrudRepository<StaticShipmentStatus, Integer> {

}
