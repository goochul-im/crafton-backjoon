//  NBA 농구

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int lastTime = 0;
        int team1WinningTime = 0;
        int team2WinningTime = 0;
        int team1Score = 0;
        int team2Score = 0;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int team = Integer.parseInt(line[0]);
            String[] times = line[1].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);

            if (team1Score > team2Score) {
                team1WinningTime += (time - lastTime);
            } else if (team2Score > team1Score) {
                team2WinningTime += (time - lastTime);
            }

            if (team == 1) team1Score++;
            else team2Score++;

            lastTime = time;
        }

        if (team1Score > team2Score) {
            team1WinningTime += (48 * 60 - lastTime);
        } else if (team2Score > team1Score) {
            team2WinningTime += (48 * 60 - lastTime);
        }

        System.out.printf("%02d:%02d\n%02d:%02d", team1WinningTime / 60, team1WinningTime % 60, team2WinningTime / 60, team2WinningTime % 60);
    }
}
