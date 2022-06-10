package hust.soict.hedspi.garbage;

public class NoGarbage {
    public static String readFileWithStringBuffer(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            java.io.FileReader fr = new java.io.FileReader(fileName);
            int c;
            while ((c = fr.read()) != -1) {
                sb.append((char) c);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    // main
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String fileName = "src/hust/soict/hedspi/garbage/text.txt";
        String s = readFileWithStringBuffer(fileName);
        System.out.println(System.currentTimeMillis() - start + " ms");

    }

}
