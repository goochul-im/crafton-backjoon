//  체스판 다시 칠하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static String[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        map = new String[N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                int minCount = Math.min(countDiffChar(i,j,false), countDiffChar(i, j, true));
                minVal = Math.min(minVal, minCount);
            }
        }

        System.out.println(minVal);
    }

    private static int countDiffChar(int row, int col, boolean toggle) {
        String compareLineA = "WBWBWBWB";
        String compareLineB = "BWBWBWBW";

        int count = 0;

        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if (toggle) {
                    if (map[i].charAt(j) != compareLineA.charAt(j - col)) {
                        count++;
                    }
                } else {
                    if (map[i].charAt(j) != compareLineB.charAt(j - col)) {
                        count++;
                    }
                }
            }
            toggle = !toggle;
        }

        return count;
    }
}
