package com.apap.tugas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.repository.PustakawanDB;

@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService{
	@Autowired
	private PustakawanDB pustakawanDB;
	
	@Override
	public void generateNIP(PustakawanModel pustakawan) {
		pustakawan.setNip(pustakawan.generateNIP());
	}
	
	@Override
	public void addPustakawan(PustakawanModel pustakawan) {
		this.generateNIP(pustakawan);
		for (PustakawanModel p : this.listAll()) {
			if (p.getNip().equals(pustakawan.getNip())) {
				this.generateNIP(pustakawan);
			}
		}
		pustakawanDB.save(pustakawan);
	}
	
	@Override
	public List <PustakawanModel> listAll() {
        return pustakawanDB.findAll();
    }
	
	@Override
	public PustakawanModel getPustakawanByNIP(String nip) {
		return pustakawanDB.findBynip(nip);
	}
	
	@Override
	public PustakawanModel getPustakawanById(int id) {
		return pustakawanDB.findById(id);
	}
	
	@Override
	public void updatePustakawan(int id, PustakawanModel updatePustakawan) {
		PustakawanModel pustakawan = this.getPustakawanById(id);
		pustakawan.setNama(updatePustakawan.getNama());
		pustakawan.setTempatLahir(updatePustakawan.getTempatLahir());
		pustakawan.setTanggalLahir(updatePustakawan.getTanggalLahir());
		pustakawan.setJenisKelamin(updatePustakawan.getJenisKelamin());
		pustakawan.setPustakawanSpes(updatePustakawan.getPustakawanSpes());
	}
	
	@Override
	public void deletePustakawan(int id) {
		pustakawanDB.deleteById(id);
	}
}
