package leetcode.queue.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public class Pair<K, V> {
        K key;
        V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int[] days = new int[T.length];
        Stack<Pair<Integer, Integer>> pairs = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (pairs.isEmpty()) {
                pairs.push(new Pair<>(T[i], i));
            } else {
                Pair<Integer, Integer> outpop = pairs.peek();
                while (!pairs.isEmpty() && T[i] > outpop.key) {
                    outpop = pairs.pop();
                    int popIndex = outpop.value;
                    days[popIndex] = i - popIndex;
                    if (!pairs.isEmpty()) {
                        outpop = pairs.peek();
                    }
                }
                pairs.push(new Pair<>(T[i], i));
            }



        }
        return days;
    }

    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        new DailyTemperature().dailyTemperatures(t);
    }


}
