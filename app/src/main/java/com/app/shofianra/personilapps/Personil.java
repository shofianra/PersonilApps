package com.app.shofianra.personilapps;

import java.io.Serializable;

public class Personil implements Serializable {

    String nama, jenisKelamin, alamat, tanggalLahir, image;

    public Personil(String nama, String jenisKelamin, String alamat, String tanggalLahir, String image) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getImage() {
        return image;
    }
}
