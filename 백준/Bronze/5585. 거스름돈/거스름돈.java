//  거스름돈

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cost = 1000 - Integer.parseInt(br.readLine());

        int count = 0;
        while (cost > 0) {
            if (cost >= 500) {
                cost -= 500;
                count++;
            } else if (cost >= 100) {
                cost -= 100;
                count++;
            } else if (cost >= 50) {
                cost -= 50;
                count++;
            } else if (cost >= 10) {
                cost -= 10;
                count++;
            } else if (cost >= 5) {
                cost -= 5;
                count++;
            } else {
                cost -= 1;
                count++;
            }
        }

        System.out.println(count);
    }
}
