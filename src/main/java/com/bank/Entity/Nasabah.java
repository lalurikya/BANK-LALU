package com.bank.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Nasabah")
public class Nasabah {
    @Id
    @Column(name = "NoKtp")
    private String nomorKtp;

    @Column(name = "NamaLengkap")
    private String namaLengkap;

    @Column(name = "Alamat")
    private String alamat;

    @Column(name = "TempatLahir")
    private String tempatLahir;

    @Column(name = "TanggalLahir")
    private LocalDate tanggalLahir;

    @Column(name = "NomorHp")
    private String nomorHp;
}
