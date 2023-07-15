// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int solution = solution(new int[]{3, 2, 7, 5, 4, 1, 6});
        System.out.println(solution);
        solution = solution1(new int[]{3, 2, 7, 5, 4, 1, 6});
        System.out.println(solution);
    }
    public static int solution1(int[] client) {
        long l=System.nanoTime();
        Map<Integer, Boolean> shelf = new HashMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= client.length; i++) {
            deque.offerLast(i);
        }
        int shift = 0;
        for (int i = 0; i < client.length; i++) {
            if (shelf.containsKey(client[i])) {
                shelf.remove(client[i]);
            }
            else if (!deque.isEmpty() && client[i] == deque.getFirst()) {
                deque.pollFirst();
            } else {
                while (deque.getFirst() != client[i]) {
                    shelf.put(deque.pollFirst(), true);
                }
                if (deque.getFirst() == client[i]) {
                    deque.pollFirst();
                }
                shift = Math.max(shift, shelf.size());
            }
        }
        long r=System.nanoTime();
        System.out.println(r-l);
        return shift;
    }

    public static int solution(int[] client) {
        long l=System.nanoTime();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 1; i <= client.length; i++) {
            priorityQueue.add(i);
        }
        int size = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < client.length; i++) {
            if (priorityQueue.size() == 0) {
                continue;
            }
            if (priorityQueue.peek() == client[i]) {
                priorityQueue.remove();
            } else if (priorityQueue.peek() > client[i]) {
                size--;
            } else {
                while (priorityQueue.peek() != client[i]) {
                    priorityQueue.remove();
                    size++;
                }
                priorityQueue.remove();
            }
            System.out.println(priorityQueue);
            max = Math.max(size, max);
        }
        long r=System.nanoTime();
        System.out.println(r-l);
        return max;
    }
}
