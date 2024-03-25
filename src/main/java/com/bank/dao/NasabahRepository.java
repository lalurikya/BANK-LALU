package com.bank.dao;

import com.bank.Entity.Nasabah;
import com.bank.dto.NasabahDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NasabahRepository extends JpaRepository<Nasabah, String> {
    @Query("""
        SELECT new com.bank.dto.NasabahDTO(
        nas.nomorKtp,
        nas.namaLengkap,
        nas.alamat,
        nas.tempatLahir,
        nas.tanggalLahir,
        nas.nomorHp)   
        FROM Nasabah AS nas
        """)
    public List<NasabahDTO> getAllDataNasabah();

}
