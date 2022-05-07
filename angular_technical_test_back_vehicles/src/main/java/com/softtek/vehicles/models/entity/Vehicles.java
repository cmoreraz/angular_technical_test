package com.softtek.vehicles.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="vehicles")
public class Vehicles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	
	@NotEmpty
	@Column(nullable = false)
    public String placa;
	@NotEmpty
	@Column(nullable = false)
	public String marca;
	@NotEmpty
	@Column(nullable = false)
    public String model;
	@NotEmpty
	@Column(nullable = false)
	public Double driverIdentification;
	@NotEmpty
	@Column(nullable = false)
    public String driverName;
	@NotEmpty
	@Column(nullable = false)
	public String status;
    
    @Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
    public Date createAt;
    
    @PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDriverIdentification() {
		return driverIdentification;
	}

	public void setDriverIdentification(Double driverIdentification) {
		this.driverIdentification = driverIdentification;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
