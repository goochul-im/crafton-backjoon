//  그림

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int row;
    static int col;
    static int[][] map;
    static int answer = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);

        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        find();

        System.out.println(count);
        System.out.println(answer);

    }

    private static void find() {

        boolean[][] isVisited = new boolean[row][col];
        int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]){
                    count++;
                    isVisited[i][j] = true;
                    Queue<Point> Q = new LinkedList<>();
                    Q.add(new Point(i, j));

                    int drawSize = 1;

                    while (!Q.isEmpty()) {
                        int len = Q.size();
                        for (int T = 0; T < len; T++) {
                            Point poll = Q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nextRow = poll.row + moving[k][0];
                                int nextCol = poll.col + moving[k][1];

                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && !isVisited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                                    isVisited[nextRow][nextCol] = true;
                                    Q.add(new Point(nextRow, nextCol));
                                    drawSize++;
                                }
                            }
                        }
                    }

                    answer = Math.max(drawSize, answer);
                }
            }
        }
    }

    private static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}
