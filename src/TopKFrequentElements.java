import java.util.Arrays;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );

        int i = 0;

        while (i < nums.length) {

            int num = nums[i];
            int count = 0;

            while (i < nums.length && nums[i] == num) {
                count++;
                i++;
            }

            minHeap.offer(new int[]{num, count});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        for (int j = k - 1; j >= 0; j--) {
            res[j] = minHeap.poll()[0];
        }

        return res;
    }
}