package argorithm.sort;

import java.util.Arrays;

public class TestBubbleSort {

    public static void main(String[] args) {

        int[] array = new int[]{6, 5, 4, 3, 2, 1};

        bubbleSort(array, 6);

        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        //i 表示什么 i表示需要进行冒泡的次数。即只需要n-1次循环比较就可以排序
        //0~n-2次，共计 n-1次比较，每一次比较将最大的值摘出来

        //j 表示什么
        //j表示数组的下标，每轮比较，从数组0 1 2 ...
        for (int i = 0; i < n - 1; i++) {
            boolean switchFlag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    switchFlag = true;
                }
            }
            if (!switchFlag) {
                //当一次比较没有交换。证明已经排序完毕
                break;
            }
        }
    }
}
