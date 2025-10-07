//  최종 순위

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] inDegree = new int[N + 1];
            Set<Integer>[] graph = new Set[N + 1];

            for (int j = 0; j < N; j++) {
                inDegree[prob[j]] = j;
            }

            for (int j = 0; j < N + 1; j++) {
                graph[j] = new HashSet<>();
            }

            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    graph[prob[j]].add(prob[k]);
                }
            }

            int M = Integer.parseInt(br.readLine());

            for (int j = 0; j < M; j++) {
                String[] line = br.readLine().split(" ");
                int start = Integer.parseInt(line[0]);
                int end = Integer.parseInt(line[1]);

                if (graph[start].contains(end)) {
                    graph[start].remove(end);
                    graph[end].add(start);
                    inDegree[start]++;
                    inDegree[end]--;
                } else {
                    graph[end].remove(start);
                    graph[start].add(end);
                    inDegree[end]++;
                    inDegree[start]--;
                }



            }

            // 위상정렬 시~작!!
            Queue<Integer> Q = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                if (inDegree[prob[j]] == 0) {
                    Q.add(prob[j]);
                }
            }

            int count = 0;
            StringBuilder sb = new StringBuilder();

            while (!Q.isEmpty()) {

                count++;
                if (Q.size() >= 2) {
                    System.out.println("?");
                    return;
                }

                Integer poll = Q.poll();

                Set<Integer> nows = graph[poll];
                sb.append(poll).append(" ");

                for (Integer now : nows) {
                    inDegree[now]--;
                    if (inDegree[now] == 0) Q.add(now);
                }

            }

            if (count != N) {
                System.out.println("IMPOSSIBLE");
            }else {
                System.out.println(sb);
            }

        }

    }
}
