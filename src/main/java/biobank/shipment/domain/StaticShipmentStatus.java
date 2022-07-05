package biobank.shipment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "static_shipments_status")
public class StaticShipmentStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull
	String name;
	
	public Integer getId() {
	    return id;
	  }

	public void setId(Integer id) {
	    this.id = id;
	  }
	
	public String getName() {
	    return name;
	  }
	
	public void setName(String name) {
	    this.name = name;
	  }
	
}
