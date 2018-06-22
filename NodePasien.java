package rsQueue;

public class NodePasien {
    String nama;
    int noAntrian;
    NodePasien next, prev;

    NodePasien(NodePasien prev, String nama, int noAntrian, NodePasien next) {
        this.prev = prev;
        this.nama = nama;
        this.noAntrian = noAntrian;
        this.next = next;
    }
}
