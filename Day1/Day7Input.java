import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day7Input {
    private static final String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
    private static final String fileName = "Day7input.txt";
    public static ArrayList<String> array = new ArrayList<>();

    public static void readInput() throws IOException {
        File file = new File(filePath + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();

        while (s!=null && s.length() > 0){
            if (s.indexOf("shiny gold bag") >= 0) {
                array.add(s);
            }
            s = br.readLine();
        }
    }
}
