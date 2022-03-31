package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//Anggota Perpus
class Anggota {
    // Atribut
    String nama;
    int noKartu;
    int usia;
    Buku judul;

    //Constructor
    Anggota(String nama, int noKartu, int usia) {
        this.nama = nama;
        this.noKartu = noKartu;
        this.usia = usia;
    }

    //Method
    void pinjamBuku(Buku judul) {
        this.judul = judul;
    }

    void informasiPeminjaman() {
        System.out.println("Nama : " + this.nama);
        System.out.println("No Kartu : " + this.noKartu);
        System.out.println("Usia : " + this.usia);
        System.out.println("Peminjaman buku : ");
        judul.detailBuku();
        SimpleDateFormat ssdfdate = new SimpleDateFormat("dd-MM-yyyy");
        Date pinjam = new Date();
        System.out.println("Tanggal Peminjaman : " + ssdfdate.format(pinjam));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5); //  5 Hari dari peminjaman
        Date kembali = cal.getTime();
        System.out.println("Tanggal Pengembalian : " + ssdfdate.format(kembali));
        System.out.println("Denda dikenakan apabila tidak mengembalikan buku dengan sesuai");
        System.out.println();
    }

    void informasiPengembalian() {
        System.out.println("Nama : " + this.nama);
        System.out.println("No Kartu : " + this.noKartu);
        System.out.println("Usia : " + this.usia);
        System.out.println("Pengembalian buku : ");

        judul.detailBuku();
        SimpleDateFormat ssdfdate = new SimpleDateFormat("dd-MM-yyyy");
        Date kembali = new Date();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -5); //  5 Hari dari peminjaman
        Date pinjam = cal.getTime();

        int status;
        System.out.println("Telat Pengembalian?(Y/T)");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.print("Pilihan : ");
        Scanner inputUser = new Scanner(System.in);
        status = inputUser.nextInt();

        if (status == 1 ) {
            System.out.println("Pengembalian Buku Telat");
            System.out.println("Tanggal Peminjaman   : " + ssdfdate.format(pinjam));
            System.out.print("Tanggal Pengembalian : ");
            String telat;
            Scanner inputTelat = new Scanner(System.in);
            telat = inputTelat.next();
            System.out.print("Lama keterlambatan : ");
            int jumlahTelat;
            Scanner inputJmlhTelat = new Scanner(System.in);
            jumlahTelat = inputJmlhTelat.nextInt();
            System.out.println("Status               : Denda");
            System.out.println("Jumlah Denda         : Rp." + jumlahTelat*500);
            System.out.println();
        }
        else{
            System.out.println("Pembalikan Tepat Waktu");
            System.out.println("Tanggal Peminjaman   : " + ssdfdate.format(pinjam));
            System.out.println("Tanggal Pengembalian : " + ssdfdate.format(kembali));
            System.out.println("Status               : Tidak Denda");
            System.out.println();
        }
    }
}

//Buku
class Buku{
    // Atribut
    String judul;

    //Constructor
    Buku (String judul) {
        this.judul = judul;
    }

    //Method
    void detailBuku(){
        System.out.println("Judul Buku : " + this.judul);
    }
}

public class Main {

    public static void main(String[] args) {
        String cekStatus;
        do {
            int pilihMenu;

            System.out.println("============================================");
            System.out.println("PENCATATAN TRANSAKASI PERPUSTAKAAN SEDERHANA");
            System.out.println("==============================================");

            //Pembutan Objek Anggota
            Anggota amanda = new Anggota("Amanda Hs", 201, 20);
            Anggota sinta = new Anggota("Sinta Dw ", 506, 20);
            Anggota atika = new Anggota("Atika Mr",1073, 21);

            //Pembuatan Objek Buku
            Buku buku1 = new Buku ("Pemprograman Berorientasi Objek");
            Buku buku2 = new Buku ("Mengetahui Sistem Operasi");
            Buku buku3 = new Buku ("Rekayasa Perangkat Lunak");

            System.out.println("Menu Perpustakaan Sederhana: ");
            System.out.println(" 1. Data Peminjaman");
            System.out.println(" 2. Data Pengembalian");
            System.out.println(" Lain-lain :  Keluar");
            System.out.print("Pilih Menu :  ");
            Scanner inputUser = new Scanner(System.in);
            pilihMenu = inputUser.nextInt();
            System.out.println();

            switch (pilihMenu) {
                case 1:
                    System.out.println("Data Peminjaman");
                    System.out.println();
                    amanda.pinjamBuku(buku1);
                    amanda.informasiPeminjaman();

                    sinta.pinjamBuku(buku2);
                    sinta.informasiPeminjaman();
                    break;

                case 2:
                    System.out.println("Data Pengembalian");
                    System.out.println();

                    amanda.pinjamBuku(buku1);
                    amanda.informasiPengembalian();

                    sinta.pinjamBuku(buku2);
                    sinta.informasiPengembalian();
                    break;

                default:
                    System.exit(0);
            }
            System.out.print("Kembali ke Menu Awal? (Y/T) : ");
            cekStatus = inputUser.next();

        } while (cekStatus.equals("Y") || cekStatus.equals("y"));
    }
}
