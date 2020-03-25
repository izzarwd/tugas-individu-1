package com.apap.tugas.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.RandomStringGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "nip", nullable = false, unique =true)
	private String nip;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "tempat_lahir")
	private String tempatLahir;
	
	@NotNull
	@Column(name = "tanggal_lahir", nullable = false)
	private Date tanggalLahir;
	
	@NotNull
	@Column(name = "jenis_kelamin", nullable = false)
	private int jenisKelamin;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "punya",
	joinColumns = { @JoinColumn(name = "pustakawan_id") },
	inverseJoinColumns = { @JoinColumn(name = "spesialisasi_id") })
	private List<SpesialisasiModel> pustakawanSpes=new ArrayList<SpesialisasiModel>();;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "tugasDi",
	joinColumns = { @JoinColumn(name = "pustakawan_id") },
	inverseJoinColumns = { @JoinColumn(name = "perpustakaan_id") })
	private List<PerpustakaanModel> pustakawanPerpus=new ArrayList<PerpustakaanModel>();
	
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

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public int getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(int jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public List<SpesialisasiModel> getPustakawanSpes() {
		return pustakawanSpes;
	}

	public void setPustakawanSpes(List<SpesialisasiModel> pustakawanSpes) {
		this.pustakawanSpes = pustakawanSpes;
	}
	
	public List<PerpustakaanModel> getPustakawanPerpus() {
		return pustakawanPerpus;
	}

	public void setPustakawanPerpus(List<PerpustakaanModel> pustakawanPerpus) {
		this.pustakawanPerpus = pustakawanPerpus;
	}
	
	public String generateNIP(){
		return LocalDate.now().getYear() + new SimpleDateFormat("ddMMyy").format(getTanggalLahir()) + this.getJenisKelamin() + new RandomStringGenerator.Builder().withinRange('A','Z').build().generate(2);
	}
	
}
