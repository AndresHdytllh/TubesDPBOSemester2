package Main;

import Database.KoneksiDB;
import Database.KatalogMenu;
import Database.UserLogin;
import UserPackage.Admin;
import UserPackage.Pelanggan;
import Database.UserRegist;
import MenuPackage.Menu;
import MenuPackage.DetailPesanan;
import MenuPackage.Reservasi;
import PesananPackage.Pesanan;
import PesananPackage.Kasir;
import PesananPackage.Promo;
import PembayaranPackage.PembayaranTunai;
import PembayaranPackage.PembayaranNonTunai;
import StatusPackage.StatusPesanan;
import StatusPackage.StatusPembayaran;
import LaporanPackage.Invoice;
import LaporanPackage.LaporanKeuangan;
import LaporanPackage.Meja;
import java.util.ArrayList;
import java.util.Scanner;

public class BuanaCoffee {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        KatalogMenu menu = new KatalogMenu();

        boolean run = true;

        while (run) {
            
            System.out.println("\n=== APLIKASI KASIR BUANA COFFEE ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan role (admin/pelanggan): ");
                    String role = input.nextLine();

                    System.out.print("Masukkan username : ");
                    String usn = input.nextLine();

                    System.out.print("Masukkan password : ");
                    String pw = input.nextLine();

                    System.out.println("Sedang memproses registrasi...");
                    
                    UserRegist userregist = new UserRegist(usn, pw, role);
                    
                    boolean berhasil = userregist.registerUser();

                    if (berhasil) {
                        System.out.println("Registrasi akun '" + usn + "' dengan role [" + role + "] BERHASIL!");
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
                        role = "admin";
                    } else if (pilihanRole.equals("2")) {
                        role = "pelanggan";
                    } else {
                        System.out.println("Pilihan role tidak valid.");
                        break;
                    }

                    System.out.print("Masukkan username : ");
                    usn = input.nextLine();

                    System.out.print("Masukkan password : ");
                    pw = input.nextLine();

                    System.out.println("Sedang memproses login...");
                    
                    UserLogin userlogin = new UserLogin(usn, pw, role);

                    boolean loginBerhasil = userlogin.loginUser();

                    if (loginBerhasil) {
                        System.out.println("Anda berhasil login sebagai " + role + "!");

                        if (role.equals("pelanggan")) {
                            Menu menu1 = new Menu("M001", "Kopi Susu", 18000);
                            Menu menu2 = new Menu("M002", "Cafe Latte", 25000);
                            Menu menu3 = new Menu("M003", "Americano", 15000);

                            DetailPesanan detail =
                                    new DetailPesanan("M001", "Kopi Susu", 18000, 2, 36000);

                            ArrayList<Meja> daftarMeja = new ArrayList<>();

                            for (int i = 1; i <= 10; i++) {
                                daftarMeja.add(new Meja(i, 4));
                            }

                            System.out.println("\n=== DAFTAR MENU ===");

                            System.out.println("\nMenu 1");
                            System.out.println("ID Menu : " + menu1.getIdMenu());
                            System.out.println("Nama : " + menu1.getNamaProduk());
                            System.out.println("Harga : " + menu1.getHarga());

                            System.out.println("\nMenu 2");
                            System.out.println("ID Menu : " + menu2.getIdMenu());
                            System.out.println("Nama : " + menu2.getNamaProduk());
                            System.out.println("Harga : " + menu2.getHarga());

                            System.out.println("\nMenu 3");
                            System.out.println("ID Menu : " + menu3.getIdMenu());
                            System.out.println("Nama : " + menu3.getNamaProduk());
                            System.out.println("Harga : " + menu3.getHarga());

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

                            Reservasi reservasi = new Reservasi("M002", "Cafe Latte", 25000, idReservasi, jumlahOrang);

                            Meja mejaDipilih = daftarMeja.get(nomorMeja - 1);
                            mejaDipilih.pesanMeja();

                            System.out.println("\n=== DETAIL PESANAN ===");
                            System.out.println("ID Menu : " + detail.getIdMenu());
                            System.out.println("Nama : " + detail.getNamaProduk());
                            System.out.println("Harga : " + detail.getHarga());
                            System.out.println("Qty : " + detail.getQuantity());
                            System.out.println("Subtotal : " + detail.getSubtotal());

                            System.out.println("\n=== RESERVASI ===");
                            System.out.println("Nomor Meja : " + nomorMeja);
                            System.out.println("ID Menu : " + reservasi.getIdMenu());
                            System.out.println("Nama Menu : " + reservasi.getNamaProduk());
                            System.out.println("Harga : " + reservasi.getHarga());
                            System.out.println("ID Reservasi : " + reservasi.getIdReservasi());
                            System.out.println("Jumlah Orang : " + reservasi.getJumlahOrang());
                            System.out.println("Status Meja : " + mejaDipilih.getStatusMeja());
                        }
                        
                    } else {
                        System.out.println("Login GAGAL. Periksa kembali username, password, atau role.");
                    }
                    break;

                case 0:
                    System.out.println("Bye!");
                    run = false;
                    break;

                default:
                    System.out.println("Opsi tidak valid, silakan coba lagi.");
                    break;
            }
        }
        input.close();

    }
}
