package 比较排序.堆排序;

import java.util.Random;

public class HeapSort {

    /**
     * 堆排序
     * @param nums
     */
    public static void sort(int[] nums) {
        buildHeap(nums);

        int i = nums.length - 1;
        while (i > 0) {
            swap(nums, 0, i);
            i--;
            sink(nums, 0, i);
        }
    }

    /**
     * 建堆
     * @param nums
     */
    private static void buildHeap(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            sink(nums, i, len - 1);
        }
    }

    /**
     * 对元素下沉操作
     * @param nums
     * @param i
     * @param len 能取到
     */
    private static void sink(int[] nums, int i, int len) {
        while (i * 2 + 1 <= len) {
            int j = i * 2 + 1;
            if (j + 1 <= len && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[i]) {
                swap(nums, i, j);
                i = j;
            } else {
                break;
            }
        }
    }

    /**
     * 交换数组中两个给定下标元素的位置
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 判断数组是否有序
     * @param nums
     * @return
     */
    public static boolean isSorted(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[50000000];

        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt();
        }

        System.out.println(isSorted(nums));
        sort(nums);
        System.out.println(isSorted(nums));
    }
}
