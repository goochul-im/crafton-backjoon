//  양치기 꿍

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int row;
    static int col;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] isVisited = new boolean[row][col];
        Queue<Point> Q = new LinkedList<>();
        int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int totalWolf = 0;
        int totalSheep = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != '#' && !isVisited[i][j]) {
                    //bfs
//                    System.out.printf("row = %d, col = %d\n",i,j);
                    isVisited[i][j] = true;
                    Q.add(new Point(i, j));

                    int wolf = 0;
                    int sheep = 0;

                    while (!Q.isEmpty()) { // 영역 한번 검사
                        int len = Q.size();

                        for (int k = 0; k < len; k++) {
                            Point poll = Q.poll();

                            if (map[poll.row][poll.col] == 'v') {
                                wolf++;
                            } else if (map[poll.row][poll.col] == 'k') {
                                sheep++;
                            }

                            for (int l = 0; l < 4; l++) {
                                int nextRow = poll.row + moving[l][0];
                                int nextCol = poll.col + moving[l][1];

                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && map[nextRow][nextCol] != '#' && !isVisited[nextRow][nextCol]) {
                                    isVisited[nextRow][nextCol] = true;
                                    Q.add(new Point(nextRow, nextCol));
                                }
                            }

                        }
                    }

                    if (sheep > wolf) {
                        totalSheep += sheep;
//                        System.out.printf("wolf = %d, sheep = %d, row = %d, col = %d\n", wolf, sheep, i, j);
                    } else totalWolf += wolf;

                }
            }
        }

        System.out.printf("%d %d",totalSheep, totalWolf);
    }

    private static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
