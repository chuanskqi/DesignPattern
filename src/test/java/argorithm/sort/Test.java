package argorithm.sort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        bubbleSort(new int[] {6,5,4,3,2,1}, 6);
    }


    /**
     * 冒泡排序
     * @param a
     * @param n
     */
    public static void bubbleSort(int[] a, int n) {
        //i 表示什么 i表示需要进行冒泡的次数。即只需要n-1次循环比较就可以排序
        //0~n-2次，共计 n-1次比较，每一次比较将最大的值摘出来

        //j 表示什么
        //j表示数组的下标，每轮比较，从数组0 1 2 ...
        for (int i = 0; i < n - 1; i++) {
            System.out.println("第" + (i + 1) + "次外层循环开始:" + Arrays.toString(a));
            for (int j = 0; j < n - 1 - j; j ++) {
                System.out.println("进入处理");
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次外层循环结束:" + Arrays.toString(a));
        }
    }
}
