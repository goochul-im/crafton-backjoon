//  만남의 광장

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int ROW = Integer.parseInt(line[0]);
        int COL = Integer.parseInt(line[1]);
        int[] rowScore = new int[ROW];
        int[] colScore = new int[COL];
        int[][] map = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < COL; j++) {
                map[i][j] = Integer.parseInt(line[j]);
                rowScore[i] += map[i][j];
                colScore[j] += map[i][j];
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < ROW; i++) {
            for (int j = i+1; j<ROW; j++) {
                for (int k = 0; k < COL; k++) {
                    for (int l = k+1; l<COL; l++) {
                        int score = getScore(map, rowScore, colScore, i, j, k, l);
                        result = Math.max(result, score);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int getScore(int[][] map, int[] rowScore, int[] colScore, int row1, int row2, int col1, int col2) {
        int score = 0;
        score += rowScore[row1] + rowScore[row2] + colScore[col1] + colScore[col2]; // row, col 누적합
        score -= map[row1][col1] + map[row1][col2] + map[row2][col1] + map[row2][col2]; // 겹치는 부분 빼기

        if (row1 + 1 != row2 && col1 + 1 != col2) { // 내부에 녹지가 있을 때
            score += (row2 - row1 - 1) * (col2 - col1 - 1);
        }

        return score;
    }
}
