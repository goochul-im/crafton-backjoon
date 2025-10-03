//  왕위 계승

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    private static HashMap<String, Node> family;
    private static HashMap<String, Double> values;
    private static String king;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        family = new HashMap<>();
        values = new HashMap<>();
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = line[0];
        int M = line[1];

        king = br.readLine();

        for (int i = 0; i < N; i++) {

            String[] strings = br.readLine().split(" ");

            Node child = family.computeIfAbsent(strings[0], Node::new);
            Node parent1 = family.computeIfAbsent(strings[1], Node::new);
            Node parent2 = family.computeIfAbsent(strings[2], Node::new);

            child.setParents(new Node[]{parent1, parent2});

        }

        String answer = "";
        double maxBlood = -1.0;
        for (int i = 0; i < M; i++) {
            String heiress = br.readLine();

            double findBlood = findBloodValue(heiress);

            if (findBlood > maxBlood) {
                maxBlood = findBlood;
                answer = heiress;
            }
        }

        System.out.println(answer);
    }

    private static double findBloodValue(String name) {
        if (name.equals(king)) return 1.0;

        if (values.containsKey(name)) return values.get(name);

        if (!family.containsKey(name)) return 0.0;

        Node node = family.get(name);

        Node[] parents = node.parents;
        Node parent1 = parents[0];
        Node parent2 = parents[1];

        double p1value = (parent1 == null) ? 0.0 : findBloodValue(parent1.name);
        double p2value = (parent2 == null) ? 0.0 : findBloodValue(parent2.name);

        double myValue = (p1value + p2value) / 2.0;
        values.put(name, myValue);
        return myValue;
    }

    private static class Node {

        Node[] parents = new Node[2];
        String name;

        public Node(String name) {
            this.name = name;
        }

        public void setParents(Node[] parents) {
            this.parents = parents;
        }
    }
}
