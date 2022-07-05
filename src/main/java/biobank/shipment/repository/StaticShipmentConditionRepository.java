package biobank.shipment.repository;

import org.springframework.data.repository.CrudRepository;

import biobank.shipment.domain.StaticShipmentCondition;

public interface StaticShipmentConditionRepository extends CrudRepository<StaticShipmentCondition, Integer> {

}
