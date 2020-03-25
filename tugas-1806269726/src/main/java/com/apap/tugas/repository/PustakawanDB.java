package com.apap.tugas.repository;

import com.apap.tugas.model.PustakawanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PustakawanDB extends JpaRepository<PustakawanModel, Integer>{
	PustakawanModel findBynip(String nip);
	PustakawanModel findById(int id);
	void deleteById(int id);
}
