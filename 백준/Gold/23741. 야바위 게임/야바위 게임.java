//  야바위 게임

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int X = Integer.parseInt(line[2]);
        int Y = Integer.parseInt(line[3]);

        ArrayList<Integer>[] map = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }
        Set<Integer> answer = new HashSet<>();

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            map[start].add(end);
            map[end].add(start);
        }

        answer.add(X);
        for (int i = 0; i < Y; i++) {
            var tempSet = new HashSet<Integer>();

            for (Integer now : answer) {
                tempSet.addAll(map[now]);
            }

            answer = tempSet;
        }

        int[] array = answer.stream().sorted().mapToInt(Integer::intValue).toArray();
        if (array.length != 0) {
            String str = Arrays.stream(array)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(str);
        } else {
            System.out.println(-1);
        }
    }

}
