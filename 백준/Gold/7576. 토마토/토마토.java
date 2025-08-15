//  토마토

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        int[][] prob = new int[N][M];

        Queue<Point> Q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                prob[i][j] = Integer.parseInt(line[j]);
                if (prob[i][j] == 1)
                    Q.add(new Point(i, j));
            }
        }

        int[][] moving = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int count = -1;
        while (!Q.isEmpty()) {

            count++;
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Point p = Q.poll();
                for (int[] move : moving) {
                    int nextRow = p.row + move[0];
                    int nextCol = p.col + move[1];
                    if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && prob[nextRow][nextCol] == 0) {
                        prob[nextRow][nextCol] = 1;
                        Q.add(new Point(nextRow, nextCol));
                    }
                }
            }

        }

        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (prob[i][j] == 0) {
                    count = -1;
                    break outer;
                }
            }
        }

        System.out.println(count);

    }

    private static class Point {
        int row;
        int col;

        public Point(int x, int y) {
            this.row = x;
            this.col = y;
        }
    }
}
