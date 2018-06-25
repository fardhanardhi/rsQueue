package rsQueue;

public class OperasiTransaksi {
    NodeTransaksi head;
    int size;

    public OperasiTransaksi() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private void addFirst(NodePasien pasien, String keluhan, int jumlahBayar, int hargaKeluhan) {
        if (isEmpty()) {
            head = new NodeTransaksi(null, pasien, keluhan, jumlahBayar, null);
        } else {
            NodeTransaksi newNode = new NodeTransaksi(null, pasien, keluhan, jumlahBayar, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(NodePasien pasien, String keluhan, int jumlahBayar, int hargaKeluhan) {
        if (isEmpty()) {
            addFirst(pasien, keluhan, jumlahBayar, hargaKeluhan);
        } else {
            NodeTransaksi current = head;
            while (current.next != null) {
                current = current.next;
            }
            NodeTransaksi newNode = new NodeTransaksi(current, pasien, keluhan, jumlahBayar, null);
            current.next = newNode;
            size++;
        }
        System.out.println("Kembalian\t: Rp." + hitungKembalian(jumlahBayar, hargaKeluhan));
    }

    private int hargaKeluhan(String keluhan) {
        int harga = 0;
        if (keluhan.equals("ringan")) {
            harga = 50000;
        } else if (keluhan.equals("dalam")) {
            harga = 100000;
        } else {
            harga = 30000;
        }
        return harga;
    }

    public int hitungKembalian(int jumlahBayar, int hargaKeluhan) {
        int kembalian = jumlahBayar - hargaKeluhan;
        return kembalian;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        int jumlah = 0;
        if (!isEmpty()) {
            NodeTransaksi tmp = head;
            System.out.println("Data Transaksi");
            System.out.println("-----------------------------");
            while (tmp != null) {
                System.out.println("Nama\t\t: " + tmp.pasien.nama);
                System.out.println("No. Antrian\t: " + tmp.pasien.noAntrian);
                System.out.println("Jenis Keluhan\t: Penyakit " + tmp.keluhan);
                System.out.println("Total Harga\t: " + hargaKeluhan(tmp.keluhan));
                System.out.println("Uang yg dibayar\t: " + tmp.jumlahBayar);
                System.out.println("Kembalian\t: Rp." + hitungKembalian(tmp.jumlahBayar, hargaKeluhan(tmp.keluhan)));
                System.out.println("-----------------------------");
                tmp = tmp.next;
                jumlah++;
            }
            System.out.println("Total: " + jumlah + " transaksi ditemukan");
        } else
            System.out.println("Transaksi kosong");
    }

    public void printTotalKeluhan() {
        int ringan, dalam, gigi;
        ringan = dalam = gigi = 0;
        if (!isEmpty()) {
            NodeTransaksi tmp = head;
            while (tmp != null) {
                if (tmp.keluhan.equals("ringan")) {
                    ringan++;
                }
                else if (tmp.keluhan.equals("dalam")) {
                    dalam++;
                }
                else if (tmp.keluhan.equals("gigi")) {
                    gigi++;
                }
                tmp = tmp.next;
            }
            System.out.println("Jumlah keluhan pasien");
            System.out.println("- Penyakit Ringan : " + ringan);
            System.out.println("- Penyakit Dalam  : " + dalam);
            System.out.println("- Penyakit Gigi   : " + gigi);
        } else
            System.out.println("Transaksi kosong");
    }

    public void printByKeluhan(String keluhan) {
        if (isEmpty())
            System.out.println("Transaksi masih kosong");
        else {
            boolean ditemukan = false;
            NodeTransaksi tmp = head;
            int jumlah = 0;
            System.out.println("Transaksi dengan keluhan: penyakit " + keluhan);
            for (int i = 0; i < size; i++) {
                if (tmp.keluhan.equalsIgnoreCase(keluhan)) {
                    ditemukan = true;
                    System.out.println("-----------------------------");
                    System.out.println("Nama\t\t: " + tmp.pasien.nama);
                    System.out.println("No. Antrian\t: " + tmp.pasien.noAntrian);
                    System.out.println("Jenis Keluhan\t: Penyakit " + tmp.keluhan);
                    System.out.println("Total Harga\t: " + hargaKeluhan(tmp.keluhan));
                    System.out.println("Uang yg dibayar\t: " + tmp.jumlahBayar);
                    System.out.println("Kembalian\t: Rp." + hitungKembalian(tmp.jumlahBayar, hargaKeluhan(tmp.keluhan)));
                    jumlah++;
                }
                tmp = tmp.next;
            }
            if (!ditemukan) {
                System.out.println("----------------------");
                System.out.println("Transaksi tidak ditemukan");
            } else {
                System.out.println("----------------------");
                System.out.println("-> " + jumlah + " Data ditemukan");
            }
        }
    }
}
