package Main;

import java.util.Scanner;

import Database.KatalogMenu;
import Database.UserLogin;
import Database.UserRegist;
import UserPackage.Admin;

public class BuanaCoffee {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        KatalogMenu menu = new KatalogMenu();

        boolean run = true;

        while (run) {
            System.out.println("test123");
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
