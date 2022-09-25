import java.util.*;
/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Time complexity: O(Nlogk), k is the number of linked list.
Space complexity: O(n), creating a new list costs O(n) space
Idea: use priorityQueue, to store the node, and poll every time
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class Q23_MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists)
    {
        if (lists == null) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a - b);
        for (ListNode node : lists)
        {
            while (node != null)
            {
                pq.add(node.val);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty())
        {
            curr.next = new ListNode(pq.poll());
            curr = curr.next;
        }
        return dummy.next;
    }
}
