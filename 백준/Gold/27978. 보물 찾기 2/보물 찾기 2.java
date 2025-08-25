//  보물 찾기 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int ROW = Integer.parseInt(line[0]);
        int COL = Integer.parseInt(line[1]);
        char[][] map = new char[ROW][COL];
        int[][] costMap = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            line = br.readLine().split(" ");
            map[i] = line[0].toCharArray();
        }

        int startRow = 0;
        int startCol = 0;
        int endRow = 0;
        int endCol = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == 'K') {
                    startRow = i;
                    startCol = j;
                }
                if (map[i][j] == '*') {
                    endRow = i;
                    endCol = j;
                }
                costMap[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] moving = {{1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}};

        Deque<Point> Q = new LinkedList<>();
        costMap[startRow][startCol] = 0;
        Q.add(new Point(startRow, startCol));
        int result = 0;
        int cost = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            Point p = Q.pollFirst();
            int curCost = costMap[p.row][p.col];

            for (int[] move : moving) {
                int nextRow = p.row + move[0];
                int nextCol = p.col + move[1];
                if (nextRow < 0 || nextRow >= ROW || nextCol < 0 || nextCol >= COL) continue;
                if (map[nextRow][nextCol] == '#') continue;

                int weight = (move[1] == 1) ? 0 : 1;
                int nowCost = curCost + weight;

                if (nowCost < costMap[nextRow][nextCol]) {
                    costMap[nextRow][nextCol] = nowCost;
                    if (weight == 0) Q.addFirst(new Point(nextRow, nextCol));
                    else Q.addLast(new Point(nextRow, nextCol));
                }

            }

        }

        if (costMap[endRow][endCol] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(costMap[endRow][endCol]);
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
