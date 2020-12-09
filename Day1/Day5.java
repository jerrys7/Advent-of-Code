import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day5 {

    private static ArrayList<String> num;
    private static int[] array = new int [128];
    public static void fillNumbers() {
        for (int k = 0; k < 128; k++) {
            array[k] = k;
        }
    }

    public static void readInput() throws IOException {
        num = new ArrayList<>();
        String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
        File file = new File(filePath + "Day5Input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringTokenizer st;
        String s = br.readLine();

        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            num.add(st.nextToken());
            while(st.hasMoreTokens()){
                num.add(st.nextToken());
            }
            s = br.readLine();
        }
    }

    public static void calculateID() {
        int maxID = 0;
        for (int k = 0; k < num.size(); k++) {
            String s = num.get(k);
            char[] array = s.toCharArray();
            int currentSize = 64;
            int currentPointer = 64;
            int otherSize = 4;
            int otherPointer = 4;
            int row = 0;
            int column = 8;
            int id;
            for (char c: array) {
                if (c == 'F') {
                    currentPointer = currentPointer - (int) (0.5 * currentSize);
                    currentSize = currentSize / 2;
                } else if (c == 'B') {
                    currentPointer = currentPointer + (int) (0.5 * currentSize);
                    currentSize = currentSize / 2;;
                } else if (c == 'R') {
                    otherPointer = otherPointer + (int) (0.5 * otherSize);
                    otherSize = otherSize / 2;
                } else if (c == 'L') {
                    otherPointer = otherPointer - (int) (0.5 * otherSize);
                    otherSize = otherSize / 2;
                }
            }
            id = (currentPointer - 1) * 8 + otherPointer;
            System.out.println(id);
            if (id > maxID) {
                maxID = id;
            }
        }
        System.out.println(maxID);
    }

    public static void main(String[] args) throws IOException {
        fillNumbers();
        readInput();
        calculateID();;
    }
}
