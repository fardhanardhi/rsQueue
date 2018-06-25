package rsQueue;

public class OperasiPasien {
    NodePasien head;
    int size, noAntrianBaru;

    OperasiTransaksi ot = new OperasiTransaksi();

    public OperasiPasien() {
        head = null;
        size = 0;
        noAntrianBaru = 1;
    }

    public boolean isEmpty() {
        return head == null;
    }

    private void addFirst(String nama, int noAntrian) {
        if (isEmpty()) {
            head = new NodePasien(null, nama, noAntrian, null);
        } 
        else {
            NodePasien newNode = new NodePasien(null, nama, noAntrian, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void enqueue(String nama) {
        int noAntrian = noAntrianBaru;
        noAntrianBaru++;
        if (isEmpty()) {
            addFirst(nama, noAntrian);
        } 
        else {
            NodePasien current = head;
            while (current.next != null) {
                current = current.next;
            }
            NodePasien newNode = new NodePasien(current, nama, noAntrian, null);
            current.next = newNode;
            size++;
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            NodePasien tmp = head;
            System.out.println(" Nomor");
            System.out.println("Antrian\t  Nama");
            System.out.println("----------------------");
            while (tmp != null) {
                System.out.println("  " + tmp.noAntrian + "\t  " + tmp.nama);
                tmp = tmp.next;
            }
        } 
        else
            System.out.println("Antrian kosong");
    }

    private int hargaKeluhan(String keluhan) {
        int harga = 0;
        if (keluhan.equals("ringan")) {
            harga = 50000;
        } 
        else if (keluhan.equals("dalam")) {
            harga = 100000;
        } 
        else {
            harga = 30000;
        }
        return harga;
    }

    public void dequeue(String keluhan, int jumlahBayar) throws Exception {
        if (isEmpty())
            throw new Exception("Antrian masih kosong, tidak dapat dequeue");
        else {
            if (hargaKeluhan(keluhan) > jumlahBayar) {
                System.out.println("Uang yang dibayarkan tidak mencukupi untuk membayar SPP");
            } 
            else {
                if (size == 1)
                    removeLast(keluhan, jumlahBayar);
                else {
                    NodePasien pasien = head;
                    head = head.next;
                    head.prev = null;
                    size--;
                    ot.addLast(pasien, keluhan, jumlahBayar, hargaKeluhan(keluhan));
                }
            }
        }
    }

    private void removeLast(String keluhan, int jumlahBayar) throws Exception {
        if (isEmpty())
            throw new Exception("Antrian masih kosong, tidak dapat dihapus");
        if (head.next == null) {
            NodePasien pasien = head;
            head = null;
            size--;
            ot.addLast(pasien, keluhan, jumlahBayar, hargaKeluhan(keluhan));
        } 
        else {
            NodePasien current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            NodePasien pasien = current.next;
            current.next = null;
            size--;
            ot.addLast(pasien, keluhan, jumlahBayar, hargaKeluhan(keluhan));
        }
    }

    public void searchNama(String nama) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar pasien masih kosong");
        boolean ditemukan = false;
        NodePasien tmp = head;
        for (int i = 0; i < size; i++) {
            if (!tmp.nama.equals(nama)) {
                tmp = tmp.next;
            } else {
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan)
            throw new Exception("Nama tidak ditemukan");
        else {
            System.out.println("Data ditemukan");
            System.out.println();
            System.out.println("- Nama\t\t\t: " + tmp.nama);
            System.out.println("- No. antrian\t\t: " + tmp.noAntrian);
            System.out.println("- Antrian sekarang\t: " + head.noAntrian);
            System.out.println();
            System.out.println("! Kurang " + (tmp.noAntrian - head.noAntrian) + " pasien lagi hinga giliran anda");
        }
    }

    public void searchNomor(int noAntrian) throws Exception {
        if (isEmpty())
            throw new Exception("Daftar pasien masih kosong");
        boolean ditemukan = false;
        NodePasien tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.noAntrian != noAntrian) {
                tmp = tmp.next;
            } else {
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan)
            throw new Exception("Nomor antrian tidak ditemukan");
        else {
            System.out.println("Data ditemukan");
            System.out.println();
            System.out.println("- Nama\t\t\t: " + tmp.nama);
            System.out.println("- No. antrian\t\t: " + tmp.noAntrian);
            System.out.println("- Antrian sekarang\t: " + head.noAntrian);
            System.out.println();
            System.out.println("! Kurang " + (tmp.noAntrian - head.noAntrian) + " pasien lagi hinga giliran anda");
        }
    }
}
