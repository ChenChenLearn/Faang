import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1
Time: O(NlogN), since array sort
Space: O(N)
 */
public class Q253_MeetingRoomTwo {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] >= pq.peek())
            {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}
