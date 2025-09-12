//  곰팡이

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] prob;
    static int[][] copyProb;
    static int row;
    static int col;
    static Queue<Point> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        row = Integer.parseInt(line[0]);
        col = Integer.parseInt(line[1]);
        Q = new LinkedList<>();

        prob = new int[row][col];
        copyProb = new int[row][col];
        for (int i = 0; i < row; i++) {
            prob[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            copyProb[i] = Arrays.copyOf(prob[i], col);
            for (int j = 0; j < col; j++) {
                if (prob[i][j] != 0) Q.add(new Point(i, j));
            }
        }

//        System.out.println("0 day =====");
//        printProb();

        int day = 0;
        if (isOne()) {
            System.out.println(day);
            return;
        }


        while (!Q.isEmpty()) {
            int len = Q.size();

            copyProb = new int[row][col];
            for (int i = 0; i < row; i++) {
                copyProb[i] = Arrays.copyOf(prob[i], col);
            }

            day++;
            for (int i = 0; i < len; i++) {
                Point point = Q.poll();
                infection(point.row, point.col);
            }
            prob = copyProb;

            if (isOne()) break;
        }

        System.out.println(day);
    }

    private static class Point {
        public int row;
        public int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static void infection(int mRow, int mCol) {
        int power = prob[mRow][mCol];
        int startRow = Math.max(0, mRow - power);
        int startCol = Math.max(0, mCol - power);
        int endRow = Math.min(row - 1, mRow + power);
        int endCol = Math.min(col - 1, mCol + power);

        for (int nowRow = startRow; nowRow <= endRow; nowRow++) {
            for (int nowCol = startCol; nowCol <= endCol; nowCol++) {
                if (copyProb[nowRow][nowCol] < power) {
                    copyProb[nowRow][nowCol] = power;
                    Q.add(new Point(nowRow, nowCol));
//                    System.out.printf("mRow : %d, mCol : %d ,nowRow : %d, nowCol : %d, power : %d\n",mRow, mCol, nowRow, nowCol,power);
                }
            }
        }
    }

    private static boolean isOne() {

        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        Queue<Point> check = new LinkedList<>();
        boolean[][] isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (prob[i][j] > 0 && !isVisited[i][j]) {
                    check.add(new Point(i, j));
                    isVisited[i][j] = true;
                    count++;

                    if (count > 1) {
                        return false;
                    }

                    while (!check.isEmpty()) {
                        int len = check.size();
                        for (int k = 0; k < len; k++) {
                            Point nowPoint = check.poll();

                            for (int x = 0; x < 4; x++) {
                                int nextRow = nowPoint.row + move[x][0];
                                int nextCol = nowPoint.col + move[x][1];

                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && prob[nextRow][nextCol] != 0 && !isVisited[nextRow][nextCol]) {
                                    isVisited[nextRow][nextCol] = true;
                                    check.add(new Point(nextRow, nextCol));
                                }
                            }
                        }
                    }

                }
            }
        }

        return count == 1;
    }

    private static void printProb() {
        for (var line : prob) {
            System.out.println(Arrays.toString(line));
        }
    }
}
