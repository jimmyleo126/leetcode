package leetcode.queue;

import java.util.*;

public class KeyAndRoom {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> keys = new Stack<>();
        keys.add(0);
        Set<Integer> opened = new HashSet<>();
        opened.add(0);
        while (!keys.isEmpty()) {
            int key = keys.pop();

            for (Integer integer : rooms.get(key)) {
                if (!opened.contains(integer)) {
                    keys.add(integer);
                    opened.add(integer);
                    if (rooms.size() == opened.size()) {
                        return true;
                    }
                }
            }
        }
        return rooms.size() == opened.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms0 = new ArrayList<>();
        List<Integer> room00 = new ArrayList<>();
        room00.add(1);
        List<Integer> room01 = new ArrayList<>();
        room01.add(2);
        List<Integer> room02 = new ArrayList<>();
        room02.add(3);
        List<Integer> room03 = new ArrayList<>();

        rooms0.add(room00);
        rooms0.add(room01);
        rooms0.add(room02);
        rooms0.add(room03);
        System.out.println(new KeyAndRoom().canVisitAllRooms(rooms0));

        // [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms1 = new ArrayList<>();
        List<Integer> room10 = new ArrayList<>();
        room10.add(1);
        room10.add(3);
        List<Integer> room11 = new ArrayList<>();
        room11.add(3);
        room11.add(0);
        room11.add(1);
        List<Integer> room12 = new ArrayList<>();
        room12.add(2);
        List<Integer> room13 = new ArrayList<>();
        room13.add(0);
        rooms1.add(room10);
        rooms1.add(room11);
        rooms1.add(room12);
        rooms1.add(room13);
        System.out.println(new KeyAndRoom().canVisitAllRooms(rooms1));
    }
}
