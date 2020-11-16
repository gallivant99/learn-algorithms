package 比较排序.堆排序.递归;

import java.util.Random;

public class MergeSort {

    // 辅助数组
    private static int[] help = null;

    /**
     * 调用归并排序
     * @param nums
     */
    public static void sort(int[] nums) {

        //辅助数组扩容初始化
        help = new int[nums.length];

        sort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序
     * @param nums
     * @param left
     * @param right
     */
    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    /**
     * 归并两个有序部分
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] nums, int left, int mid, int right) {
        for (int k = left; k <= right; k++) {
            help[k] = nums[k];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = help[j];
                j++;
            } else if (j > right) {
                nums[k] = help[i];
                i++;
            } else if (help[i] < help[j]) {
                nums[k] = help[i];
                i++;
            } else {
                nums[k] = help[j];
                j++;
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
