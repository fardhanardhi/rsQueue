package rsQueue;

import java.util.*;

public class RsMain {
    public static void main(String[] args) {
        OperasiPasien op = new OperasiPasien();
        // OperasiTransaksi ot = new OperasiTransaksi();

        Scanner sci = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);
        boolean ulang = true;
        int pilihan, noAntrian, jumlahBayar;
        String nama, keluhan = "";
        // NodeSiswa siswa;

        op.enqueue("Rika Belinda Safitri");
        op.enqueue("Gilda Anita Lailasari");
        op.enqueue("Rahmi Hastuti");
        op.enqueue("Dagel Oman Halim");
        op.enqueue("Mahdi Sirait");
        op.enqueue("Prakosa Kusumo");
        op.enqueue("Cakrawala Narpati");
        op.enqueue("Zamira Suartini");
        op.enqueue("Mahfud Mahendra");
        op.enqueue("Jarwa Abyasa Rajasa");
        op.enqueue("Warsita Tarihoran");
        op.enqueue("Pardi Harjo Waluyo");
        op.enqueue("Caket Rahmat Prabowo");
        op.enqueue("Ida Hastuti");
        op.enqueue("Vanesa Siska Yulianti");

        try {
            while (ulang) {
                System.out.println();
                System.out.println("+-----------------------------------------+");
                System.out.println("|       PUSAT PENGOBATAN ALTERNATIF       |");
                System.out.println("|               \"MBAH AGUS\"               |");
                System.out.println("+-----------------------------------------+");
                System.out.println("| [1] Tambah Pasien (enqueue)             |");
                System.out.println("| [2] Layani Pasien Selanjutnya (dequeue) |");
                System.out.println("| [3] Tampilkan data Transaksi            |");
                System.out.println("| [4] Tampilkan antrian pasien            |");
                System.out.println("| [5] Cari pasien (nama)                  |");
                System.out.println("| [6] Cari pasien (no. antrian)           |");
                System.out.println("| [7] Sort berdasarkan keluhan            |");
                System.out.println("| [0] Keluar                              |");
                System.out.println("+-----------------------------------------+");
                System.out.print("-> Masukan Pilihan: ");
                pilihan = sci.nextInt();
                switch (pilihan) {
                case 1:
                    System.out.println();
                    System.out.print("Masukan nama pasien: ");
                    noAntrian = op.noAntrianBaru;
                    nama = scs.nextLine();
                    op.enqueue(nama);
                    System.out.println("Anda mendapat no antrian ke: " + noAntrian);                    
                    break;
                case 2:
                    System.out.println();
                    if (op.isEmpty())
                        System.out.println("Belum ada pasien yang mengantri");
                    else {
                        System.out.println("Nama Pasien: " + op.head.nama);
                        System.out.println("Daftar Keluhan");
                        System.out.println("--------------------");
                        System.out.println("[1] Penyakit ringan");
                        System.out.println("[2] Penyakit dalam");
                        System.out.println("[3] Penyakit gigi");
                        System.out.println("--------------------");
                        System.out.print("Masukan keluhan (nomor)\t: ");
                        pilihan = sci.nextInt();
                        switch (pilihan) {
                            case 1:
                                keluhan = "ringan";
                                break;
                            case 2:
                                keluhan = "dalam";
                                break;
                            case 3:
                                keluhan = "gigi";
                                break;
                            default:
                                System.out.print("Input salah! ");
                                break;
                        }
                        System.out.println();
                        System.out.print("Bayar\t\t: ");
                        jumlahBayar = sci.nextInt();
                        op.dequeue(keluhan, jumlahBayar);
                    }
                    break;
                case 3:
                    System.out.println();
                    op.ot.print();
                    System.out.println();
                    op.ot.printTotalKeluhan();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Antrian pasien mbah Agus");
                    System.out.println("------------------------");
                    op.print();
                    break;
                case 5:
                    System.out.println();
                    System.out.print("Masukan nama yang dicari: ");
                    nama = scs.nextLine();
                    op.searchNama(nama);
                    break;
                case 6:
                    System.out.println();
                    System.out.print("Masukan nomor antrian yang dicari: ");
                    noAntrian = sci.nextInt();
                    op.searchNomor(noAntrian);
                    break;
                case 7:
                    System.out.println();
                    System.out.println("Daftar Keluhan");
                    System.out.println("--------------------");
                    System.out.println("[1] Penyakit ringan");
                    System.out.println("[2] Penyakit dalam");
                    System.out.println("[3] Penyakit gigi");
                    System.out.println("--------------------");
                    System.out.print("Masukan keluhan (nomor)\t: ");
                    pilihan = sci.nextInt();
                    switch (pilihan) {
                    case 1:
                        keluhan = "ringan";
                        break;
                    case 2:
                        keluhan = "dalam";
                        break;
                    case 3:
                        keluhan = "gigi";
                        break;
                    default:
                        System.out.print("Input salah! ");
                        break;
                    }
                    System.out.println();
                    op.ot.printByKeluhan(keluhan);
                    break;
                case 0:
                    System.out.print("Keluar ");
                    ulang = false;
                    break;
                default:
                    System.out.print("Input salah, ulangi! ");
                    break;
                }
                System.out.println();
                System.out.print("Tekan [ENTER]");
                scs.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
