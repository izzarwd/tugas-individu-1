package com.apap.tugas.service;

import java.util.List;

import com.apap.tugas.model.PustakawanModel;


public interface PustakawanService {
	void addPustakawan (PustakawanModel pustakawan);
	List <PustakawanModel> listAll();
	void generateNIP(PustakawanModel pustakawan);
	PustakawanModel getPustakawanByNIP(String nip);
	PustakawanModel getPustakawanById(int id);
	void updatePustakawan(int id, PustakawanModel pustakawan);
	void deletePustakawan(int id);
}
