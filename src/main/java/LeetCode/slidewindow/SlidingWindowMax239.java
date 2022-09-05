package LeetCode.slidewindow;

import java.util.*;

public class SlidingWindowMax239 {

    public static void main(String[] args) {


        Deque<Integer> deque = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        deque.add(1);
        deque.offer(2);
        deque.addLast(3);
        deque.offerFirst(0);
        deque.addFirst(-1);

        deque.removeFirst();
        deque.pollFirst();
        deque.poll();
        deque.remove();

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 18));
        System.out.println(arrayList.set(2, 10));
        System.out.println(Arrays.toString(arrayList.toArray()));

    }

    //best solution
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if( nums == null|| nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            // ensure all element of the queue is within the window
            while (!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            // remove all the element less than the new element
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i-k+1>=0){
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k>nums.length){
            return new int[]{nums[findMaxIndex(0,nums.length-1,nums)]};
        }
        int[] res = new int[nums.length-k+1];
        int mIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<=nums.length-k;i++){
            if(i>mIndex){
                mIndex = findMaxIndex(i,i+k-1,nums);
                max = nums[mIndex];
            }
            if(max<nums[i+k-1]){
                mIndex = i+k-1;
                max = nums[mIndex];
            }
            res[i] = max;
        }
        return res;
    }

    private int findMaxIndex(int start, int end, int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = start;
        for (int i = start; i <= end; i++) {
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

}
