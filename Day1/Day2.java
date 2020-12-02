import java.io.*;
import java.util.*;

public class Day2 {
    private static final String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
    private static final String fileName = "Day2input.txt";
    private static ArrayList<String> num;
    private static ArrayList<String> letter;
    private static ArrayList<String> password;
    private static ArrayList<String> chars;
    private static ArrayList<Character> chars2;
    private static ArrayList<int[]> limits;
    public static void readInput() throws IOException {

            num = new ArrayList<>();
            letter = new ArrayList<>();
            password = new ArrayList<>();

            File file = new File(filePath + fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));

            StringTokenizer st;
            String s = br.readLine();

            while (s!=null && s.length() > 0){
                st = new StringTokenizer(s);
                num.add((st.nextToken()));
                while(st.hasMoreTokens()){
                    letter.add(st.nextToken());
                    password.add(st.nextToken());
                }
                s = br.readLine();
            }
    }

    public static void alterArrays() {
        chars = new ArrayList<>();
        limits = new ArrayList<>();
        chars2 = new ArrayList<>();

        for (int k = 0; k < num.size(); k++) {
            int[] temp = new int[2];
            String s = num.get(k);
            int index = s.indexOf('-');
            temp[0] = Integer.parseInt(s.substring(0,index));
            temp[1] = Integer.parseInt(s.substring(index + 1));
            limits.add(temp);
        }

        for (int k = 0; k < letter.size(); k++) {
            chars.add(letter.get(k).substring(0, 1));
            chars2.add(letter.get(k).charAt(0));
        }
    }

    /**
     * loop through all words
     * count the chars of the specified char
     * check if it is within bounds
     * if yes ++
     */
    private static int numValidPasswords() {
        int valid = 0;
        for (int k = 0; k < limits.size(); k++) {
            String pw = password.get(k);
            String s = chars.get(k);
            int occurence = pw.length() - pw.replace(s, "").length();
            if (occurence >= limits.get(k)[0] && occurence <= limits.get(k)[1]) {
                valid++;
            }
        }
        return valid;
    }

    private static int changedPolicy() {
        int valid = 0;
        for (int k = 0; k < limits.size(); k++) {
            String s = password.get(k);
            char c = chars2.get(k);
            int bound1 = limits.get(k)[0] - 1;
            int bound2 = limits.get(k)[1] - 1;
            int temp = 0;
            if (s.charAt(bound1) == c) {
                temp++;
            }
            if (s.charAt(bound2) == c) {
                temp++;
            }
            if (temp == 1) {
                valid++;
            }
        }
        return valid;
    }

    public static void main(String[] args) throws IOException {
        readInput();
        alterArrays();
        System.out.println(numValidPasswords());
        System.out.println(changedPolicy());
    }
}

