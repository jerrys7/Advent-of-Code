import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day6 {

    private static final String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
    private static final String fileName = "Day6Input.txt";
    private static ArrayList<String> lines = new ArrayList<>();

    public static void readInput() throws IOException {

        File file = new File(filePath + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        while (!s.equals("qqq")) {
            if (s.equals("") && s.length() == 0) {
                lines.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(s + " ");
            s = br.readLine();
        }
    }

    public static void checkDuplicates() {
        int result = 0;
        for (int k = 0; k < lines.size(); k++) {
            Set<Character> sv = new HashSet();
            String temp = lines.get(k);
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) != ' ') {
                    sv.add(temp.charAt(j));
                }
            }
            result += sv.size();
        }
        System.out.println(result);
    }

    public static void checkSame() {
        int result = 0;
        for (int k = 0; k < lines.size(); k++) {
            Map<Character, Integer> hm = new HashMap<>();
            String s = lines.get(k);
            int people = -1;
            for (char c: lines.get(k).toCharArray()) {
                if (c == ' ') {
                    people++;
                }
                if (hm.containsKey(c)) {
                    int newValue = hm.get(c) + 1;
                    hm.replace(c, newValue);
                } else {
                    hm.put(c, 1);
                }
            }
            for (Map.Entry<Character, Integer> entry: hm.entrySet()) {
                char c = entry.getKey();
                int occurence = entry.getValue();
                if (occurence == people && (c != ' ')) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        readInput();
//        checkDuplicates();
        checkSame();
    }
}
