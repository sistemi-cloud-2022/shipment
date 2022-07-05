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
@Table(name = "shipments")
public class Shipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name="_from")
	@NotNull
	String _from;
	
	@Column(name = "tracking_number")
	@NotNull
	String trackingNumber;
	
	@Column(name = "received_at")
	@NotNull
	String receivedAt;
	
	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	@NotNull
	StaticShipmentStatus statusId;
	
	@ManyToOne
	@JoinColumn(name = "condition_id", referencedColumnName = "id")
	@NotNull
	StaticShipmentCondition conditionId;
	
	String note;
	
	public Integer getId() {
	    return id;
	  }

	public void setId(Integer id) {
	    this.id = id;
	  }
	
	public String getFrom() {
	    return _from;
	  }

	public void setFrom(String _from) {
	    this._from = _from;
	  }
	
	public String getTrackingNumber() {
	    return trackingNumber;
	  }

	public void setTrackingNumber(String trackingNumber) {
	    this.trackingNumber = trackingNumber;
	  }
	
	public String getReceivedAt() {
	    return receivedAt;
	  }

	public void setReceivedAt(String receivedAt) {
	    this.receivedAt = receivedAt;
	  }
	
	public StaticShipmentStatus getStatusId() {
	    return statusId;
	  }

	public void setStatusId(StaticShipmentStatus statusId) {
	    this.statusId = statusId;
	  }
	
	public StaticShipmentCondition getConditionId() {
	    return conditionId;
	  }

	public void setConditionId(StaticShipmentCondition conditionId) {
	    this.conditionId = conditionId;
	  }
	
	public String getNote() {
	    return note;
	  }

	public void setNote(String note) {
	    this.note = note;
	  }
	
}
