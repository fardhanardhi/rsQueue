package rsQueue;

public class NodeTransaksi {
    NodePasien pasien;
    String keluhan;
    int jumlahBayar;
    NodeTransaksi next,prev;
    
    NodeTransaksi(NodeTransaksi prev, NodePasien pasien, String keluhan, int jumlahBayar, NodeTransaksi next) {
        this.prev = prev;
        this.pasien = pasien;
        this.keluhan = keluhan;
        this.jumlahBayar = jumlahBayar;
        this.next = next;
    }
}
