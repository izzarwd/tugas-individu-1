package com.apap.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apap.tugas.model.PerpustakaanModel;
import org.springframework.stereotype.Repository;

@Repository
public interface PerpustakaanDB extends JpaRepository <PerpustakaanModel, Integer>{
	void deleteById(int id);
}
