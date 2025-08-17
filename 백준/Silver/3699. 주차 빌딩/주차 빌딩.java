//  주차 빌딩

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[] line = br.readLine().split(" ");
            int totalHeight = Integer.parseInt(line[0]); // h
            int totalCol = Integer.parseInt(line[1]);    // l

            Point[] idx = new Point[totalHeight * totalCol];

            int[][] cars = new int[totalHeight][];
            int maxR = 0; // 마지막 차
            for (int i = 0; i < totalHeight; i++) {
                cars[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < totalCol; j++) {
                    if (cars[i][j] != -1) {
                        int r = cars[i][j];
                        idx[r - 1] = new Point(i, j);
                        if (r > maxR) maxR = r;
                    }
                }
            }

            // 층별 컨베이어 오프셋(0이면 원래 0번 열이 엘리베이터 위치에 있음)
            int[] offset = new int[totalHeight]; // 모두 0으로 시작

            int time = 0;

            for (int curIdx = 0; curIdx < maxR; curIdx++) {
                Point p = idx[curIdx];
                if (p == null) continue;

                int floor = p.height;  // 0-base: (f-1)
                int j = p.col;         // "원래" 열 인덱스(0-base)

                // 현재 이 차의 "엘리베이터 기준 위치(0..l-1)" = (원래열 - 현재오프셋) mod l
                int pos = ((j - offset[floor]) % totalCol + totalCol) % totalCol;

                // 최소 회전 칸 수 (시계/반시계 중 작은 값)
                int cw = pos;                 // 시계로 pos칸 돌리면 0으로 옴
                int ccw = totalCol - pos;     // 반시계로 totalCol - pos칸
                int steps = Math.min(cw, ccw);

                // 회전 시간
                time += steps * 5;

                // 실제 회전 방향에 따라 offset 갱신
                if (cw <= ccw) {
                    // 시계 방향으로 cw칸
                    offset[floor] = (offset[floor] + cw) % totalCol;
                } else {
                    // 반시계 방향으로 ccw칸
                    offset[floor] = (offset[floor] - ccw) % totalCol;
                    if (offset[floor] < 0) offset[floor] += totalCol;
                }

                time += 20 * floor;

            }

            System.out.println(time);
        }
    }

    private static class Point {
        int height; 
        int col;    

        public Point(int height, int col) {
            this.height = height;
            this.col = col;
        }
    }
}
