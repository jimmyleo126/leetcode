package leetcode.queue;


import java.util.*;


public class NumSquares {

    public class Pair<K, V> {
        private K key;
        private V value;

        public Pair() {
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> steps = new LinkedList<>();
        steps.add(new Pair<>(n, 0));
        List<Boolean> visited = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            visited.add(false);
        }
        while (!steps.isEmpty()) {
            Pair<Integer, Integer> numMap = steps.poll();
            int num = numMap.getKey();
            int step = numMap.getValue();
            int i = 1;
            while (num - i * i >= 0) {
                int temp = num - i * i;
                if (temp == 0) {
                    return step + 1;
                }
                if (temp > 0) {
                    if (!visited.get(temp)) {
                        steps.add(new Pair<>(temp, step + 1));
                        visited.set(temp, true);
                    }
                }
                i++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(4));
    }
}
