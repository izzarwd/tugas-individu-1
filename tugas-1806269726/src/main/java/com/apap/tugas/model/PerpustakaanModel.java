package com.apap.tugas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "perpustakaan")
public class PerpustakaanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 500)
	@Column(name = "lokasi")
	private String lokasi;
	
	@ManyToMany(mappedBy = "pustakawanPerpus", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<PustakawanModel> pustakawanPerpus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public List<PustakawanModel> getPustakawanPerpus() {
		return pustakawanPerpus;
	}

	public void setPustakawanPerpus(List<PustakawanModel> pustakawanPerpus) {
		this.pustakawanPerpus = pustakawanPerpus;
	}
	
}
