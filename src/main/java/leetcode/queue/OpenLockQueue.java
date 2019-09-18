package leetcode.queue;

import java.util.*;

public class OpenLockQueue {

    public int openLock(String[] deadends, String target) {
        List<String> deadendsList = Arrays.asList(deadends);
        Queue<String> locks = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        String inits = "0000";
        if (target.equals(inits)) {
            return 1;
        }
        if (deadendsList.contains(inits)) {
            return -1;
        }
        if (deadendsList.contains(target)) {
            return -1;
        }
        locks.add(inits);
        visited.add(inits);
        int counts = 0;
        while (!locks.isEmpty()) {
            int sizequeue = locks.size();
            for (int i = 0; i < sizequeue; i++) {
                String top = locks.poll();
                List<String> neibors = findNeibors(top);
                for (String neibor : neibors) {
                    if (neibor.equals(target)) {
                        counts++;
                        return counts;
                    }
                    if (visited.contains(neibor) || deadendsList.contains(neibor)) {
                        continue;
                    }

                    locks.add(neibor);
                    visited.add(neibor);
                }
            }
            counts++;
        }
        return -1;
    }

    public List<String> findNeibors(String currentLock) {
        char[] chars = currentLock.toCharArray();
        List<String> locks = new ArrayList<String>();
        for (int i = 0; i < chars.length; i++) {
            char[] newChars = Arrays.copyOf(chars, chars.length);
            if (chars[i] == '9') {
                newChars[i] = '0';
            } else {
                newChars[i]++;
            }
            locks.add(String.valueOf(newChars));
            newChars = Arrays.copyOf(chars, chars.length);
            if (chars[i] == '0') {
                newChars[i] = '9';
            } else {
                newChars[i]--;
            }
            locks.add(String.valueOf(newChars));
        }
        return locks;
    }

    public static void main(String[] args) {
        int i = new OpenLockQueue().openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888");
        System.out.println(i);
    }
}
