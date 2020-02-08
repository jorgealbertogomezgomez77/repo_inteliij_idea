
public class Proof {
    public static void main(String[] args) {

    }
    public static int gdc(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gdc(q, r);
    }
}
