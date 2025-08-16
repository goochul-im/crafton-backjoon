//  Soccer Standings

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            int[] list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int games = list[0];
            int score = list[1];
            printGames(i, games, score);

        }

    }

    private static void printGames(int gameNumber, int games, int score) {
        System.out.printf("Team #%d\n", gameNumber + 1);
        System.out.printf("Games: %d\n", games);
        System.out.printf("Points: %d\n", score);
        System.out.print("Possible records:\n");

        int wMax = Math.min(games, score / 3);      
        for (int w = wMax; w >= 0; w--) {           
            int t = score - 3 * w;                  
            if (t < 0) continue;                   
            if (t > games - w) continue;           
            int l = games - w - t;                  
            if (l < 0) continue;                   
            System.out.printf("%d-%d-%d\n", w, t, l);
        }
        System.out.println();                       
    }
}
