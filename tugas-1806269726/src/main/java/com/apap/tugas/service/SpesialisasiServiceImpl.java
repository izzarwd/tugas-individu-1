package com.apap.tugas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.repository.SpesialisasiDB;

@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService{
	@Autowired
	private SpesialisasiDB spesialisasiDB;
	
	@Override
	public void addSpesialisasi (SpesialisasiModel spesialisasi){
		spesialisasiDB.save(spesialisasi);
	}
	
	@Override
	public List <SpesialisasiModel> listAll() {
        return spesialisasiDB.findAll();
    }
	
	@Override
	public Optional<SpesialisasiModel> getSpesialisasiDetailById(int id) {
		return spesialisasiDB.findById(id);
	}
}
