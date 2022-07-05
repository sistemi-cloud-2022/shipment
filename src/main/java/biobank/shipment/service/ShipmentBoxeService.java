package biobank.shipment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biobank.shipment.repository.ShipmentBoxeRepository;
import biobank.shipment.domain.ShipmentBoxe;

@Service
public class ShipmentBoxeService {
	
	@Autowired
	ShipmentBoxeRepository shipmentBoxeRepository;
	
	public ShipmentBoxe createShipmentBoxe(ShipmentBoxe sb) {
		return shipmentBoxeRepository.save(sb);
	}
	
	public List<ShipmentBoxe> getAllShipmentBoxe(){
		List<ShipmentBoxe> shipment_boxes = new ArrayList<>();
		shipmentBoxeRepository.findAll().forEach(shipment_boxes::add);
		return shipment_boxes;
	}
	
	public Optional<ShipmentBoxe> getShipmentBoxe (Integer id){
		return shipmentBoxeRepository.findById(id);
	}
}
