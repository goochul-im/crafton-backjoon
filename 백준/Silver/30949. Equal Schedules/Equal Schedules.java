import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("------")) break;
            String[] parts = line.split("\\s+");
            int s = Integer.parseInt(parts[0]);
            int e = Integer.parseInt(parts[1]);
            String name = parts[2];
            map1.put(name, map1.getOrDefault(name, 0) + (e - s));
        }

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("======")) break;
            String[] parts = line.split("\\s+");
            int s = Integer.parseInt(parts[0]);
            int e = Integer.parseInt(parts[1]);
            String name = parts[2];
            map2.put(name, map2.getOrDefault(name, 0) + (e - s));
        }

        TreeSet<String> allNames = new TreeSet<>();
        allNames.addAll(map1.keySet());
        allNames.addAll(map2.keySet());

        boolean anyDiff = false;
        for (String name : allNames) {
            int v1 = map1.getOrDefault(name, 0);
            int v2 = map2.getOrDefault(name, 0);
            int diff = v2 - v1;
            if (diff != 0) {
                anyDiff = true;
                System.out.printf("%s %+d%n", name, diff);
            }
        }

        if (!anyDiff) {
            System.out.println("No differences found.");
        }
    }
}
