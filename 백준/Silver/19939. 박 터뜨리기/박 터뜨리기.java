//  박 터뜨리기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int minimum = (K * (K+1)) / 2;

        if (N < minimum) System.out.println(-1);
        else if ((N - minimum) % K == 0) System.out.println(K-1);
        else System.out.println(K);

    }
}
