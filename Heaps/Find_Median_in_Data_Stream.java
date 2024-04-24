import java.util.*;

class Find_Median_in_Data_Stream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    int count;

    public Find_Median_in_Data_Stream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        count = 0;
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);
        count++;
        if (count % 2 == 0) {
            while (maxHeap.size() != minHeap.size())
                minHeap.add(maxHeap.poll());
        } else {
            while (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (count % 2 == 0)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}