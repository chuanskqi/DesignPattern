package argorithm.sort;

import java.util.Arrays;

public class TestSelectSort {

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 4, 3, 2, 1};

        selectSort(array, 6);

        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * 从未排序区间内找到最小的元素，然后放到已排序区间的最大索引上
     * 稳定性：涉及到元素的交换，不稳定排序算法 [5,6,5,1]  查找到1会和5交换位置
     * 时间复杂度：o(n²)
     * 空间复杂度:o(1)
     */
    public static void selectSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

}
