//  인간-컴퓨터 상호작용

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] prob = br.readLine().toCharArray();
        String[] line = br.readLine().split(" ");

        int q = Integer.parseInt(line[0]);
        int[][] arr = new int[prob.length][26];

        arr[0][prob[0] - 97]++;

        for (int i = 1; i < prob.length; i++) {
            int now = prob[i] - 97;

            arr[i][now]++;
            for (int j = 0; j < 26; j++) {
                arr[i][j] += arr[i - 1][j];
            }
        }

        for (int i = 0; i < q; i++) {
            line = br.readLine().split(" ");

            int find = line[0].charAt(0) - 97;
            int start = Integer.parseInt(line[1]);
            int end = Integer.parseInt(line[2]);

            int answer = arr[end][find];
            if (start > 0) {
                answer -= arr[start - 1][find];
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }
}
