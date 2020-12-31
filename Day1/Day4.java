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
    private static final String[] eyeColor = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
    private static final char[] hairColor = {'a', 'b', 'c', 'd', 'e', 'f', '0', '1', '2', '3' , '4', '5', '6' , '7','8', '9'};
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
                int count = 0;
                for (int i = 0; i < 8; i++) {
                    if (array[i] != null && (!array[i].equals("")) && (!array[i].startsWith("cid"))) {
                        count++;
                    }
                }
                int partTwo = 0;
                if (count == 7) {
                    for (int j = 0; j < 8; j++) {
                        String d = array[j];
                        System.out.println("---------------------------------------------");
                        System.out.println(d);
                        if (array[j] != null && d.indexOf(':') > 0) {
                            String first = d.substring(0, d.indexOf(':'));
                            String sub = d.substring(d.indexOf(':') + 1);
                            System.out.println("Sub is " + sub);
                            if (first.equals("byr")) {
                                int num = Integer.parseInt(sub);
                                if (num >= 1920 && num <= 2002) {
                                    partTwo++;
                                    System.out.println("Part Two is " + partTwo);;
                                }
                            } else if (first.equals("iyr")) {
                                int num = Integer.parseInt(sub);
                                if (num >= 2010 && num <= 2020) {
                                    partTwo++;
                                    System.out.println("Part Two is " + partTwo);;
                                }
                            } else if (first.equals("eyr")) {
                                int num = Integer.parseInt(sub);
                                if (num >= 2020 && num <= 2030) {
                                    partTwo++;
                                    System.out.println("Part Two is " + partTwo);;
                                }
                            } else if (first.equals("hgt")) {
                                if (sub.indexOf("cm") > 0) {
                                    String asdf = sub.substring(0, sub.indexOf("c"));
                                    int height = Integer.parseInt(asdf);
                                    if (height >= 150 && height <= 193) {
                                        partTwo++;
                                        System.out.println("Part Two is " + partTwo);;
                                    }
                                } else if (sub.indexOf("in") > 0) {
                                    String asdf = sub.substring(0, sub.indexOf("i"));
                                    int height = Integer.parseInt(asdf);
                                    if (height >= 59 && height <= 76) {
                                        partTwo++;
                                        System.out.println("Part Two is " + partTwo);;
                                    }
                                }

                            } else if (first.equals("ecl")) {
                                for (String p : eyeColor) {
                                    if (sub.equals(p)) {
                                        partTwo++;
                                        System.out.println("Part Two is " + partTwo);;
                                        break;
                                    }
                                }
                            } else if (first.equals("pid")) {
                                if (sub.length() == 9) {
                                    String regex = "[0-9]+";
                                    if (sub.matches(regex)) {
                                        partTwo++;
                                    }
                                    System.out.println("Part Two is " + partTwo);;
                                }
                            } else if (first.equals("hcl")) {
                                if (sub.length() == 7) {
                                    int please = 0;
                                    for (int x = 1; x < 7; x++) {
                                        char temp = sub.charAt(x);
                                        for (char t: hairColor) {
                                            if (t == temp) {
                                                please++;
                                                break;
                                            }
                                        }
                                    }
                                    if (please == 6) {
                                        partTwo++;
                                        System.out.println("Part Two is " + partTwo);;
                                    }
                                }
                            }
                        }
                    }
                    if (partTwo == 7) {
                        System.out.println("hi");
                        result++;
                    }
                }
                if (count == 7) {
                    result++;
                }
                k = 0;
                for (int l = 0; l < 7; l++) {
                    array[l] = "";
                }
            }
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                array[k] = st.nextToken();
                k++;
            }
            s = br.readLine();
        }
        System.out.println("Total valid is " + result);
    }
//    public static void readInput() throws IOException {
////        lines = new ArrayList<String[]>();
//
//        File file = new File(filePath + fileName);
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        StringTokenizer st;
////        StringBuilder sb = new StringBuilder();
//        String s = br.readLine();
//        String[] array = new String[8];
//        int result = 0;
//        int k = 0;
//        while (!s.equals("qqq")){
//            if (s.equals("") && s.length() == 0) {
//                int count = 0;
//                for (int i = 0; i < 8; i++) {
//                    if (array[i] != null && (!array[i].equals("")) && (!array[i].startsWith("cid"))) {
//                        count++;
//                    }
////                    array[i] = "";
//                }
//                if (count == 7) {
//                    result++;
//                }
//                k = 0;
//            }
//            st = new StringTokenizer(s);
//            while(st.hasMoreTokens()){
//                array[k] = st.nextToken();
//                k++;
//            }
//            s = br.readLine();
//        }
//        System.out.println(result);
//    }

//    public static void alterArrays() {
//        System.out.println(lines.get(0)[1]);
//        System.out.println(lines.get(1)[1]);
//        for (int k = 0; k < lines.size(); k++) {
//            for (int j = 0; j < lines.get(k).length; j++) {
//                String b = lines.get(k)[j].substring(0, 3);
//                lines.get(k)[j] = b;
//            }
//
//        }
//        for (int k = 0; k < lines.size(); k++) {
//            for (int j = 0; j < lines.get(k).length; j++) {
//                if (lines.get(k)[j].equals("cid")) {
//                    lines.get(k)[j] = "";
//                }
//            }
//        }
//    }
//
//    public static void countPassports() {
//        int passwords = 0;
//        for (int k = 0; k <lines.size(); k++) {
//            if (lines.get(k).length == 7) {
//                passwords++;
//            }
//        }
//        System.out.println(passwords);
//    }

    public static void main(String[] args) throws IOException {
        readInput();
//        alterArrays();
//        countPassports();
    }
}
