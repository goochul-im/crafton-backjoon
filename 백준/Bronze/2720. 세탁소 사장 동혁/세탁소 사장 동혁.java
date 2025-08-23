//  세탁소 사장 동혁

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int cost = Integer.parseInt(br.readLine());
            int quarter = 0, dime = 0, nickel = 0, penny = 0;
            while (cost > 0) {
                if (cost >= 25){
                    quarter++;
                    cost -= 25;
                } else if (cost >= 10) {
                    dime++;
                    cost -= 10;
                } else if (cost >= 5) {
                    nickel++;
                    cost -= 5;
                } else if (cost >= 1) {
                    penny++;
                    cost -= 1;
                } else {
                    break;
                }
            }

            System.out.printf("%d %d %d %d\n", quarter, dime, nickel, penny);
        }

    }
}
