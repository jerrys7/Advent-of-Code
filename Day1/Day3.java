import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day3 {
    private static final String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
    private static final String fileName = "Day3Input.txt";
    private static ArrayList<String> lines;
    private static final char tree = '#';
    private static final char open = '.';

    public static void readInput() throws IOException {
        lines = new ArrayList<>();

        File file = new File(filePath + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringTokenizer st;
        String s = br.readLine();

        while (s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            lines.add((st.nextToken()));
            while(st.hasMoreTokens()){
                lines.add(st.nextToken());
            }
            s = br.readLine();
//            System.out.println(s);
        }
    }

    public static int countTrees(int x, int y) {
        int trees = 0;
        int length = lines.get(0).length();
        int currentIndex = 0;
        for (int k = 0; k < lines.size() - y; k = k + y) {
            currentIndex = (currentIndex + x) % length;
            if (lines.get(k + y).charAt(currentIndex) == tree) {
                trees++;
            }
        }
        return trees;
    }

    public static void main(String[] args) throws IOException {
        readInput();
        int answer = countTrees(1, 1) * countTrees(3, 1) * countTrees(5, 1) * countTrees(7, 1);
        int answer2 = countTrees(1, 2);
        System.out.println(answer);
        System.out.println(answer2);
    }
}
