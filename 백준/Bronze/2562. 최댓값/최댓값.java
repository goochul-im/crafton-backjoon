//  최댓값

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 10; i++) {
            treeMap.put(Integer.parseInt(br.readLine()), i);
        }
        Integer key = treeMap.firstKey();
        System.out.println(key);
        System.out.println(treeMap.get(key));
    }
}
