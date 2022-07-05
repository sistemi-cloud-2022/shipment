package biobank.shipment.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "shipment_boxes")
public class ShipmentBoxe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@ManyToOne
	@JoinColumn(name = "shipment_id", referencedColumnName = "id")
	@NotNull
	Shipment shipmentId;
	
	@Column(name = "box_id")
	@NotNull
	String boxId;
	
	@NotNull
	String name;
	
	@Column(name = "location_id")
	@NotNull
	Integer locationId;
	
	@Column(name = "location_path")
	@NotNull
	String locationPath;

	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	@NotNull
	StaticShipmentBoxeStatus statusId;
	
	
	public Integer getId() {
	    return id;
	  }

	public void setId(Integer id) {
	    this.id = id;
	  }
	
	public Shipment getShipmentId() {
	    return shipmentId;
	  }

	public void setShipmentId(Shipment shipmentId) {
	    this.shipmentId = shipmentId;
	  }
	
	public String getBoxId() {
	    return boxId;
	  }
	
	public void setBoxId(String boxId) {
	    this.boxId = boxId;
	  }
	
	public String getName() {
	    return name;
	  }
	
	public void setName(String name) {
	    this.name = name;
	  }
	
	public Integer getLocationId() {
	    return locationId;
	  }

	public void setLocationId(Integer locationId) {
	    this.locationId = locationId;
	  }
	
	public String getLocationPath() {
	    return locationPath;
	  }

	public void setLocationPath(String locationPath) {
	    this.locationPath = locationPath;
	  }
	
	
	public StaticShipmentBoxeStatus getStatusId() {
	    return statusId;
	  }

	public void setStatusId(StaticShipmentBoxeStatus statusId) {
	    this.statusId = statusId;
	  }
	
}
