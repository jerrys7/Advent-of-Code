import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day4 {

    private static final String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
    private static final String fileName = "Day4Input.txt";
    private static ArrayList<String[]> lines;
    //    private static ArrayList<ArrayList<String>> hi;
    public static void readInput() throws IOException {
//        lines = new ArrayList<String[]>();

        File file = new File(filePath + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] array = new String[8];
        int result = 0;
        int k = 0;
        while (!s.equals("qqq")){
            if (s.equals("") && s.length() == 0) {
                System.out.println(array[0]);
                int count = 0;
                for (int i = 0; i < 8; i++) {
                    if (array[i] != null && (!array[i].equals("")) && (!array[i].startsWith("cid"))) {
                        count++;
                    }
                    array[i] = "";
                }
                if (count == 7) {
                    result++;
                }
                k = 0;
            }
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                array[k] = st.nextToken();
                k++;
            }
            s = br.readLine();
        }
        System.out.println(result);
    }

//    private static void addArrayList(ArrayList<String> passport) {
//        ArrayList<String> k = passport;
//        lines.add(k);
//    }

    public static void alterArrays() {
        System.out.println(lines.get(0)[1]);
        System.out.println(lines.get(1)[1]);
        for (int k = 0; k < lines.size(); k++) {
            for (int j = 0; j < lines.get(k).length; j++) {
                String b = lines.get(k)[j].substring(0, 3);
                lines.get(k)[j] = b;
            }

        }
        for (int k = 0; k < lines.size(); k++) {
            for (int j = 0; j < lines.get(k).length; j++) {
                if (lines.get(k)[j].equals("cid")) {
                    lines.get(k)[j] = "";
                }
            }
        }
//        System.out.println(hi.size());
//        System.out.println(hi.get(1));
//        System.out.println(hi.get(2));
//        System.out.println(hi.get(0));

    }

    public static void countPassports() {
        int passwords = 0;
        for (int k = 0; k <lines.size(); k++) {
            if (lines.get(k).length == 7) {
                passwords++;
            }
        }
        System.out.println(passwords);
    }

    public static void main(String[] args) throws IOException {
        readInput();
//        alterArrays();
//        countPassports();
    }
}
