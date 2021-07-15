import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day7 {
    /** variables */
    private static final String comma = ",";
    private static final String period = ".";
    private static final String contain = "contain";
    private static final String numbers = "0123456789";
    private static final String filePath = "C:/Users/yuanc/Documents/Github/Advent-of-Code/Day1/";
    private static final String fileName = "Day7input.txt";

    public static ArrayList<String> array = new ArrayList<>();
    public static Graph g;
    public static Set<Integer> set = new HashSet();
    public static Map<String, Integer> m = new HashMap<>();
    public static int size = 1;


    public static void readInput() throws IOException {
        File file = new File(filePath + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = br.readLine();
//        StringTokenizer st;
        while (s!=null && s.length() > 0){
//            st = new StringTokenizer(s);
//            while (st.hasMoreTokens()) {
//                array.add(st.nextToken());
//            }
            array.add(s);
            s = br.readLine();
            size++;
        }
    }

    public static void createGraph() {
        g = new Graph(size);
        m.put("shinygoldbags", 0);
        int counter = 1;
        for (int k = 0; k < array.size(); k++) {
            String current = array.get(k);
            String initial = current.substring(0, current.indexOf(contain));
            initial = initial.replace(" ", "");
            current = current.substring(current.indexOf(contain) + contain.length());
            current = current.replace(".", " .");
            StringTokenizer st = new StringTokenizer(current);
            StringBuilder sb = new StringBuilder();
            ArrayList<String> otherEdges = new ArrayList<>();
                ArrayList<Integer> values = new ArrayList<>();
            if (current.indexOf("no other bags") < 0) {
                while (st.hasMoreTokens()) {
                    String temp = st.nextToken();
                    if (temp.equals(period)) {
                        String t = sb.toString();
                        t = t.replace(".", "");
                        otherEdges.add(t);
                        sb.setLength(0);
                        break;
                    } else if (temp.equals(comma)) {
                        String t = sb.toString();
                        t = t.replace(".", "");
                        otherEdges.add(t);
                        sb.setLength(0);
                    } else if (numbers.indexOf(temp) > -1){
                        values.add(Integer.parseInt(temp));
                    } else {
                        sb.append(temp);
                    }
                }
            }
            if (!m.containsKey(initial)) {
                m.put(initial, counter);
                counter++;
            }
            for (int j = 0; j < otherEdges.size(); j++) {
                String currEdge = otherEdges.get(j);
                if (!m.containsKey(currEdge)) {
                    m.put(currEdge, counter);
                    counter++;
                }
                g.addEdge(m.get(initial), m.get(currEdge), values.get(j));
                System.out.println("printed" + (initial) + " " + (currEdge) + " " +(j));
            }
        }
    }

    private static void countPaths() {
        Queue<WeightedEdge<Integer>> q = new ArrayDeque<>();
//        Queue<Integer> q = new ArrayDeque<>();
        List<WeightedEdge<Integer>> neighbors  = g.neighbors(0);
        for (int k = 0; k < neighbors.size(); k++) {
            q.add(neighbors.get(k));
            set.add(neighbors.get(k).from());
        }
//        q.add(0);
        System.out.println("reached line 89");
        while (!q.isEmpty()) {
            WeightedEdge<Integer> vertex = q.remove();
            for (WeightedEdge<Integer> v: g.neighbors(vertex.from())) {
                q.add(v);
                set.add(v.from());
            }
            System.out.println(set.size());
        }
    }

    public static void main(String[] args) throws IOException {
        readInput();
        createGraph();
        countPaths();
    }


}
