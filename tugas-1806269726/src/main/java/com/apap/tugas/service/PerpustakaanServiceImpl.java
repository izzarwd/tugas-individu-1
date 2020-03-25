package com.apap.tugas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.repository.PerpustakaanDB;

@Service
@Transactional
public class PerpustakaanServiceImpl implements PerpustakaanService {

	@Autowired
	private PerpustakaanDB perpustakaanDB;
	
	@Override
	public void addPerpustakaan(PerpustakaanModel perpustakaan) {
		perpustakaanDB.save(perpustakaan);
	}
	
	@Override
	public List <PerpustakaanModel> listAll() {
        return perpustakaanDB.findAll();
    }
	
	@Override
	public void deletePerpustakaan(int id) {
		perpustakaanDB.deleteById(id);
	}
}
