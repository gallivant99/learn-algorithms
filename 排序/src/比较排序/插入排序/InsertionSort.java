package 比较排序.插入排序;

import java.util.Random;

public class InsertionSort {

    /**
     * 调用插入排序
     * @param nums
     */
    public static void sort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int temp = nums[i];

            while (i > 0 && temp < nums[i - 1]) {
                nums[i] = nums[i - 1];
                i--;
            }

            nums[i] = temp;
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
        int[] nums = new int[50000];

        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt();
        }

        System.out.println(isSorted(nums));
        sort(nums);
        System.out.println(isSorted(nums));
    }
}
