package com.bank.service;

import com.bank.Entity.Nasabah;
import com.bank.dto.NasabahDTO;
import com.bank.dao.NasabahRepository;
import com.bank.dto.UpsertNasabahDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NasabahService {
    @Autowired
    private NasabahRepository nasabahRepository;

    public List<NasabahDTO> getAllDataNasabah(){
        return nasabahRepository.getAllDataNasabah();
    };

    public NasabahDTO getOneDataNasabahByNoKtp(String nomorKtp){
        var entity = nasabahRepository.findById(nomorKtp).get();
        return new NasabahDTO(
            entity.getNomorKtp(),
            entity.getNamaLengkap(),
            entity.getAlamat(),
            entity.getTempatLahir(),
            entity.getTanggalLahir(),
            entity.getNomorHp()
        );
    };

    public void deleteOneNasabah(String nomorKtp){
        nasabahRepository.deleteById(nomorKtp);
    };

    public void insertNasabah(UpsertNasabahDTO dto){
        var entity = new Nasabah();
        entity.setNomorKtp(dto.getNomorKtp());
        entity.setNamaLengkap(dto.getNamaLengkap());
        entity.setAlamat(dto.getAlamat());
        entity.setTempatLahir(dto.getTempatLahir());
        entity.setTanggalLahir(dto.getTanggalLahir());
        entity.setNomorHp(dto.getNomorHp());
        nasabahRepository.save(entity);
    };

}
