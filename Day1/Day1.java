import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day1 {

    private int[] array;
    private static ArrayList<Integer> num;


    public static void readInput() throws IOException {
        num = new ArrayList<>();
        String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
        File file = new File(filePath + "Day1Input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringTokenizer st;
        String s = br.readLine();

        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            num.add(Integer.parseInt((st.nextToken())));
            while(st.hasMoreTokens()){
                num.add(Integer.parseInt(st.nextToken()));
            }
            s = br.readLine();
        }
    }

    public static int calculateTwoSum() throws IOException {
        readInput();
        ArrayList<Integer> numbers = num;
        for (int k = 0; k < num.size(); k++) {
            for (int j = 1; j < num.size(); j++) {
                if (numbers.get(k) + numbers.get(j) == 2020) {
                    return numbers.get(k) * numbers.get(j);
                }
            }
        }
        return 0;
    }

    public static int calculateThreeSum() throws IOException {
        readInput();
        ArrayList<Integer> numbers = num;
        for (int k = 0; k < num.size(); k++) {
            for (int j = 1; j < num.size(); j++) {
                for (int l = 1; l < num.size(); l++) {
                    if (numbers.get(k) + numbers.get(j)  + numbers.get(l) == 2020) {
                        return numbers.get(k) * numbers.get(j) * numbers.get(l);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(calculateTwoSum());
        System.out.println(calculateThreeSum());
    }

}