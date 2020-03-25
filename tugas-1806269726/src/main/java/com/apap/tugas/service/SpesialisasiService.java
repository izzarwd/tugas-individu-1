package com.apap.tugas.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugas.model.SpesialisasiModel;

public interface SpesialisasiService {
	void addSpesialisasi (SpesialisasiModel spesialisasi);
	List <SpesialisasiModel> listAll();
	Optional<SpesialisasiModel> getSpesialisasiDetailById(int id);
}
