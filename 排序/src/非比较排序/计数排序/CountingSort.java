package 非比较排序.计数排序;

import java.util.Random;

public class CountingSort {

    public static int base = 0;
    public static int[] record = null;

    /**
     * 计数排序
     * @param nums
     */
    public static void sort(int[] nums) {

        initCountingSort(nums);

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] + base;
            record[index]++;
        }

        for (int i = 1; i < record.length; i++) {
            record[i] += record[i - 1];
        }

        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        for (int i = temp.length - 1; i >= 0; i--) {
            int val = temp[i] + base;
            int index = record[val] - 1;
            nums[index] = temp[i];
            record[val]--;
        }
    }

    /**
     * 完成计数排序前的准备工作
     * @param nums
     */
    public static void initCountingSort(int[] nums) {
        int minValue = nums[0];
        int maxValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            }
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        base = -minValue;
        record = new int[maxValue - minValue + 1];
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
            nums[i] = random.nextInt(50000000);
        }

        System.out.println(isSorted(nums));
        sort(nums);
        System.out.println(isSorted(nums));
    }
}
