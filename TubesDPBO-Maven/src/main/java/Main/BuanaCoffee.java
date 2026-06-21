package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Database.EditMenu;
import Database.KatalogMenu;
import Database.UserLogin;
import Database.UserRegist;
import LaporanPackage.LaporanKeuangan;
import LaporanPackage.Meja;
import MenuPackage.Reservasi;

public class BuanaCoffee {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        KatalogMenu menu = new KatalogMenu();
        EditMenu editMenu = new EditMenu();
        
        boolean run = true;

        while (run) {

            
            

            
            System.out.println("=== APLIKASI BUANA COFFEE ===");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1:

                    System.out.print("Masukkan username : ");
                    String usn = input.nextLine();

                    System.out.print("Masukkan password : ");
                    String pw = input.nextLine();

                    System.out.println("Sedang memproses registrasi...");
                    
                    UserRegist userregist = new UserRegist(usn, pw);
                    userregist.setRole("pelanggan");
                    
                    boolean berhasil = userregist.registerUser();

                    if (berhasil) {
                        System.out.println("Registrasi akun berhasil!!!");
                        System.out.println("\nSilakan login untuk menikmati layanan kami.");
                    } else {
                        System.out.println("Registrasi GAGAL. Periksa kembali koneksi atau ketersediaan username.");
                    }
                    break;
                    
                    
                case 2:
                    System.out.println("Login sebagai?");
                    System.out.println("1. Admin");
                    System.out.println("2. Pelanggan");
                    System.out.print("Pilih Opsi : ");
                    String pilihanRole = input.nextLine();

                    if (pilihanRole.equals("1")) {
                        pilihanRole = "admin";

                    } else if (pilihanRole.equals("2")) {
                        pilihanRole = "pelanggan";
                    } else {
                        System.out.println("Pilihan role tidak valid.");
                        break;
                    }

                    System.out.print("Masukkan username : ");
                    usn = input.nextLine();

                    System.out.print("Masukkan password : ");
                    pw = input.nextLine();

                    System.out.println("Sedang memproses login...");
                    
                    UserLogin userlogin = new UserLogin(usn, pw, pilihanRole);

                    boolean loginBerhasil = userlogin.loginUser();

                    if (loginBerhasil) {
                        System.out.println("Anda berhasil login sebagai " + pilihanRole + "!");
                        System.out.println("\nSelamat datang di Buana Coffee, " + usn + "!");

                        if (pilihanRole.equals("admin")) {
                            System.out.println("1. Lihat Laporan Penjualan");
                            System.out.println("2. Kelola Menu");
                            System.out.print("3. Pilih Opsi : ");
                            int pilihanAdmin = input.nextInt();
                            input.nextLine();

                            switch (pilihanAdmin) {
                                case 1:
                                    LaporanKeuangan laporan = new LaporanKeuangan("LP001", "Januari 2024"); //INI MASIH DATA TES TES AN
                                    laporan.tampilkanLaporan();
                                    break;
                                case 2:
                                    menu.tampilkanMenu();
                                    System.out.println("\n=== Edit Menu ===");      //ADA RENCANA BUAT TAMBAH MENu / HAPUS MENU, TAPI KYKNNYA BAKAL BANYAK BGT -UPADANA MUNING-
                                    System.out.println("Masukkan ID Menu yang ingin diedit : ");
                                    String idMenu = input.nextLine();
                                    System.out.println("Masukkan Nama Menu baru : ");
                                    String namaMenu = input.nextLine();
                                    System.out.println("Masukkan Harga Menu baru : ");  
                                    double hargaMenu = input.nextDouble();
                                    input.nextLine();
                                    editMenu.editMenu(idMenu, namaMenu, hargaMenu);

                                    break;
                                default:
                                    System.out.println("Opsi tidak valid.");
                                    break;
                            }

                        } else if (pilihanRole.equals("pelanggan")) {   //INI BELUM SELESAI, MASIH HARUS DITAMBAH FITUR PESAN MENU
                            System.out.println("1. Lihat Menu");
                            System.out.println("2. Pesan Menu");
                            System.out.println("3. Pilih Opsi : ");
                            int pilihanPelanggan = input.nextInt();

                            switch (pilihanPelanggan){
                                case 1:
                                    System.out.println("==Daftar Menu Buana Coffee");
                                    menu.tampilkanMenu();
                                    System.out.println("2. Pesan Menu");
                                    System.out.println("3. Pilih Opsi : ");
                                    pilihanPelanggan = input.nextInt();
                                    break;
                                case 2:
                                    System.out.println("==Daftar Menu Buana Coffee");
                                    menu.tampilkanMenu();
                                    System.out.println("Masukkan ID Menu yang ingin dipesan : ");
                                    String idMenuPesan = input.nextLine();
                                    System.out.println("Masukkan jumlah pesanan : ");
                                    int jumlahPesanan = input.nextInt();
                                    input.nextLine();

                                    ArrayList<Meja> daftarMeja = new ArrayList<>();

                                    for (int i = 1; i <= 10; i++) {
                                        daftarMeja.add(new Meja(i, 4));
                                    }

                                    System.out.println("\n=== DAFTAR MEJA ===");
                                    for (Meja meja : daftarMeja) {
                                        System.out.println("Meja " + meja.getNoMeja() + " | Kapasitas : " + meja.getKapasitas() + " | Status : " + meja.getStatusMeja());
                                    }

                                    System.out.print("\nPilih nomor meja (1-10): ");
                                    int nomorMeja = input.nextInt();

                                    if (nomorMeja < 1 || nomorMeja > 10) {
                                        System.out.println("Nomor meja tidak valid!");
                                        break;
                                    }

                                    input.nextLine();

                                    System.out.print("Masukkan ID Reservasi: ");
                                    String idReservasi = input.nextLine();

                                    System.out.print("Masukkan Jumlah Orang: ");
                                    int jumlahOrang = input.nextInt();
                                    input.nextLine();

                                    Reservasi reservasi = new Reservasi(idReservasi, jumlahOrang);

                                    Meja mejaDipilih = daftarMeja.get(nomorMeja - 1);
                                    mejaDipilih.pesanMeja();

                                    System.out.println("Pesanan berhasil! Silakan lanjutkan ke pembayaran.");

                                    System.out.println("\n=== RESERVASI ===");
                                    System.out.println("Nomor Meja : " + nomorMeja);
                                    System.out.println("ID Reservasi : " + reservasi.getIdReservasi());
                                    System.out.println("Jumlah Orang : " + reservasi.getJumlahOrang());
                                    System.out.println("Status Meja : " + mejaDipilih.getStatusMeja());
                                    break;
                                default:
                                    System.out.println("Opsi tidak valid.");
                                    break;
                            }
                        }

                    } else {
                        System.out.println("Login GAGAL. Periksa kembali username, password, atau role.");
                        System.out.println("tes");
                        System.out.println("bjjibi");
                    }
                    break;

                case 0:
                    System.out.println("Terimakaish sudah menggunakan layanan kami :D");
                    run = false;
                    System.out.println("commit");
                    break;

                default:
                    System.out.println("Opsi tidak valid, silakan coba lagi.");
                    break;


            }


        }
        input.close();

    }
}
