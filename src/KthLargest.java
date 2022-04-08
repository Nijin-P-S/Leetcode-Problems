/*
One way to solve this problem is to sort the array. However, you would need to sort the array everytime.
Another way is to use a BST that is efficient. However, the most common and popular way is to use a heap (priority queue).
Some folks may think about using a max priority queue for this problem since it asks for the kth max.
However, that is a wrong choice since the max heap keeps the max value at the top and the kth max may be
somewhere at the bottom of the heap. If you keep a min heap of size k then the kth max will stay at the
top and very easy to extract. With that in mind, here is the code.

Another benefit of using a min heap is we just need to store k elements out of n given elements from the array.
If you are worried about loosing any elements then remember the rejected elements are not in top k,
so they will never be a candidate since we don't remember any elements.
 */



/*
-----------------------------------Question-----------------------------------
Design a class to find the kth largest element in a stream.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Implement KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the
kth largest element in the stream.


 */
import java.util.PriorityQueue;
class KthLargest {
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (Integer i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}