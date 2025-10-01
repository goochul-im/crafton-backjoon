//  색종이와 공예

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        char[][] prob = new char[N][M];
        for (int i = 0; i < N; i++) {
            prob[i] = br.readLine().toCharArray();
        }

        boolean[][] isVisited = new boolean[N][M];
        int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int curRow = 0; curRow < N; curRow++) {
            for (int curCol = 0; curCol < M; curCol++) {
                if (!isVisited[curRow][curCol]) {
                    Queue<Point> Q = new LinkedList<>();
                    Q.add(new Point(curRow, curCol));
                    isVisited[curRow][curCol] = true;

                    int count = 0;

                    int minRow = curRow;
                    int minCol = curCol;
                    int maxRow = curRow;
                    int maxCol = curCol;

                    while (!Q.isEmpty()) {

                        int len = Q.size();
                        for (int i = 0; i < len; i++) {
                            Point poll = Q.poll();
                            count++;

                            for (int dir = 0; dir < 4; dir++) {
                                int nextRow = poll.row + moving[dir][0];
                                int nextCol = poll.col + moving[dir][1];

                                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !isVisited[nextRow][nextCol] && prob[curRow][curCol] == prob[nextRow][nextCol]) {
                                    Q.add(new Point(nextRow, nextCol));
                                    isVisited[nextRow][nextCol] = true;
                                    minRow = Math.min(minRow, nextRow);
                                    minCol = Math.min(minCol, nextCol);
                                    maxRow = Math.max(maxRow, nextRow);
                                    maxCol = Math.max(maxCol, nextCol);
                                }
                            }

                        }

                    }

                    int realRow = maxRow - minRow + 1;
                    int realCol = maxCol - minCol + 1;

                    if (realRow * realCol != count) {
                        System.out.println("BaboBabo");
                        return;
                    }

                }
            }
        }

        System.out.println("dd");
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
