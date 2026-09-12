/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (Interval cur : intervals) {
            pq.offer(cur);
        }

        while (!pq.isEmpty()) {
            Interval first = pq.poll();
            Interval second = pq.peek();
            if (second != null) {
                if (first.end > second.start) {
                    return false;
                }
            } else {
                break;
            }

        }
        return true;
    }
}
