import java.util.Arrays;
import java.util.PriorityQueue;

// Q1. Find maximum events
public class FindMaxEvents {
    public static int maxEvents(int[][] events) {
        int dayCount = 0;
        int i = 0;
        int n = events.length;
        Arrays.sort(events, (e1, e2) -> Integer.compare(e1[0], e2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int d=1; d<=100000; d++) {
            while (i<n && events[i][0] == d)
                pq.add(events[i++][1]);
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            if (!pq.isEmpty()) {
                dayCount += 1;
                pq.poll();
            }
        }
        return dayCount;
    }

    public static void main(String[] args) {

        int[][] events1 = { {1, 2}, {2, 3}, {3, 4} };
        System.out.println(maxEvents(events1));

        int[][] events2 = { {1, 2}, {2, 3}, {3, 4}, {1, 2} };
        System.out.println(maxEvents(events2));
    }
}
