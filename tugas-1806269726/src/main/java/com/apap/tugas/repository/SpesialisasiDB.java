package com.apap.tugas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apap.tugas.model.SpesialisasiModel;

@Repository
public interface SpesialisasiDB extends JpaRepository<SpesialisasiModel, Integer> {

}
