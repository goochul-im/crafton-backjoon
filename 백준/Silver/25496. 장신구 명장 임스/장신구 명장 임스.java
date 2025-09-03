//  장신구 명장 임스

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int P = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);

        int[] prob = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        int idx = 0;
        while (P < 200 && idx < N) {
            P += prob[idx];
            idx++;
        }

        System.out.println(idx);
    }
}
