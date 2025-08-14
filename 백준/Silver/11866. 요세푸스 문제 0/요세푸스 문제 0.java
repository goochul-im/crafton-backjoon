//  요세푸스 문제 0

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int count = K;
            while (--count > 0) {
                queue.add(queue.poll());
            }
            result.add(queue.poll());
        }
        String resultList = result.stream()
                        .map(String::valueOf)
                                .collect(Collectors.joining(", "));

        System.out.printf("<%s>", resultList);
    }
}
