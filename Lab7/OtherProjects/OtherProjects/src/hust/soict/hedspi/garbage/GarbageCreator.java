package hust.soict.hedspi.garbage;

public class GarbageCreator {
    public static String readFileWithoutStringBuffer(String fileName) {
        String s = "";
        try {
            java.io.FileReader fr = new java.io.FileReader(fileName);
            int c;
            while ((c = fr.read()) != -1) {
                s += (char) c;
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    // main
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String fileName = "src/hust/soict/hedspi/garbage/text.txt";
        String s = readFileWithoutStringBuffer(fileName);

        System.out.println(System.currentTimeMillis() - start + " ms");

    }

}
