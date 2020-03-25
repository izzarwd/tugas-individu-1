package com.apap.tugas.service;

import java.util.List;

import com.apap.tugas.model.PerpustakaanModel;

public interface PerpustakaanService {
	void addPerpustakaan (PerpustakaanModel perpustakaan);
	List <PerpustakaanModel> listAll();
	void deletePerpustakaan(int id);
}
