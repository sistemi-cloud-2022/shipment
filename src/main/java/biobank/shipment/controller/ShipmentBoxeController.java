package biobank.shipment.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import biobank.shipment.service.ShipmentBoxeService;
import biobank.shipment.domain.ShipmentBoxe;

@RestController
@RequestMapping("/shipment/shipments-boxes")
public class ShipmentBoxeController {

	@Autowired
	ShipmentBoxeService shipmentBoxeService;

	@Value("${app.biobankService}")
	String biobankServicePath;

	@Value("${app.sampleService}")
	String sampleServicePath;

	@Autowired
	KeycloakRestTemplate restTemplate;

	// SECOND USE CASE
	@PostMapping("")
	public ResponseEntity<String> createShipmentBoxe(@RequestParam Integer sampleId,
			@Valid @RequestBody ShipmentBoxe newShipmentBoxe) {

		ResponseEntity<String> response;
		String endpoint = "";
		Integer location_id = newShipmentBoxe.getLocationId();
		Integer sample_id = sampleId;

		try {
			if (sample_id != null) {
				endpoint = sampleServicePath + "/sample/samples/" + String.valueOf(sample_id);
				response = restTemplate.getForEntity(endpoint, String.class);
			}
			if (location_id != null) {
				endpoint = biobankServicePath + "/biobank/freezers/" + location_id;
				response = restTemplate.getForEntity(endpoint, String.class);
			}

			// Creazione Spedizione
			ShipmentBoxe s = shipmentBoxeService.createShipmentBoxe(newShipmentBoxe);
			// Aggiornamento Campione
			endpoint = sampleServicePath + "/sample/samples/" + String.valueOf(sample_id) + "/?boxId=" + s.getId();
			response = restTemplate.exchange(endpoint, HttpMethod.PUT, null, String.class);

		} catch (final HttpClientErrorException e) {
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
			return ResponseEntity.status(e.getStatusCode()).build();
		}

		return ResponseEntity.ok().body("ShipmentBoxe Created! \n Sample Updated!");
	}

	@GetMapping("")
	public @ResponseBody List<ShipmentBoxe> getAllShipmentBoxes() {
		return shipmentBoxeService.getAllShipmentBoxe();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShipmentBoxe> getShipmentBoxe(@PathVariable Integer id) {
		Optional<ShipmentBoxe> shipmentBoxe = shipmentBoxeService.getShipmentBoxe(id);
		if (shipmentBoxe.isPresent())
			return ResponseEntity.ok().body(shipmentBoxe.get());
		return ResponseEntity.notFound().build();
	}
}
