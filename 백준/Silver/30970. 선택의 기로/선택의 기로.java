//  선택의 기로

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Miniature> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int q = line[0];
            int p = line[1];
            arr.add(new Miniature(q, p));
        }

        arr.sort(Comparator.comparing(
                Miniature::getQuality, Comparator.reverseOrder()
        ).thenComparing(Miniature::getPrice));

        System.out.printf("%d %d ",arr.get(0).quality, arr.get(0).price);
        System.out.printf("%d %d\n",arr.get(1).quality, arr.get(1).price);

        arr.sort(Comparator.comparing(Miniature::getPrice).thenComparing(Miniature::getQuality, Comparator.reverseOrder()));
        System.out.printf("%d %d ",arr.get(0).quality, arr.get(0).price);
        System.out.printf("%d %d",arr.get(1).quality, arr.get(1).price);
    }

    private static class Miniature {

        int quality;
        int price;

        public Miniature(int quality, int price) {
            this.quality = quality;
            this.price = price;
        }

        public int getQuality() {
            return quality;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Miniature{" +
                    "quality=" + quality +
                    ", price=" + price +
                    '}';
        }
    }
}
