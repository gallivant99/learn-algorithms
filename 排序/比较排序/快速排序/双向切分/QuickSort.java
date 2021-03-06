package 比较排序.快速排序.双向切分;

import java.util.Random;

public class QuickSort {

    // 生成随机数随机抽取切分元素
    private static final Random RANDOM = new Random();

    /**
     * 调用快速排序
     * @param nums
     */
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序
     * @param nums
     * @param left
     * @param right
     */
    private static void sort(int[] nums, int left, int right){
        if (left >= right) {
            return;
        }

        //区间长度小于10改用插入排序
        if (right - left + 1 <= 10) {
            InsertionSort(nums, left, right);
            return;
        }

        int mid = partition(nums, left, right);
        sort(nums, left, mid - 1);
        sort(nums, mid + 1, right);
    }

    /**
     * 插入排序
     * @param nums
     * @param left
     * @param right
     */
    public static void InsertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            int temp = nums[i];
            while (j >= left + 1 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }

            nums[j] = temp;
        }
    }

    /**
     * 双向切分函数
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] nums, int left, int right) {
        int index = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, index);

        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && nums[i] < nums[left]) {
                i++;
            }
            while (j > left && nums[j] > nums[left]) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
            i++;
            j--;
        }

        swap(nums, left, j);
        return j;
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
