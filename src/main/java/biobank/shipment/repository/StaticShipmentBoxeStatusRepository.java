package biobank.shipment.repository;

import org.springframework.data.repository.CrudRepository;

import biobank.shipment.domain.StaticShipmentBoxeStatus;

public interface StaticShipmentBoxeStatusRepository extends CrudRepository<StaticShipmentBoxeStatus, Integer> {

}
