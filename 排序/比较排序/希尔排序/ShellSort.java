package 比较排序.希尔排序;

import java.util.Random;

public class ShellSort {

    /**
     * 调用插入排序
     * @param nums
     */
    public static void sort(int[] nums) {
        int len = nums.length;

        int step = 1;
        while (step * 3 + 1 < len) {
            step = step * 3 + 1;
        }

        while (step > 0) {
            InsertionSort(nums, step);
            step /= 3;
        }
    }

    /**
     * 选定步长的插入排序
     * @param nums
     * @param step
     */
    private static void InsertionSort(int[] nums, int step) {
        int len = nums.length;

        for (int i = step; i < len; i++) {
            int temp = nums[i];

            int j = i;
            while (j >= step && temp < nums[j - step]) {
                nums[j] = nums[j - step];
                j -= step;
            }

            nums[j] = temp;
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
