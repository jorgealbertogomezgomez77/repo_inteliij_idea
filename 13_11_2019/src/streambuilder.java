public class streambuilder {
    public static void main(String[] args) {
        StringBuilder sbld1 = new StringBuilder("Hello");
        StringBuilder sbld2 = new StringBuilder("Hello");

        if (sbld1.toString().equals(sbld2.toString())) {
            System.out.println("StringBuilder object are equal");
        }
        else {
            System.out.println("StringBuilder object are not equal");
        }
    }
}
