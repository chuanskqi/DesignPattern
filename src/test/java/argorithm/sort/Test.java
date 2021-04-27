package argorithm.sort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        bubbleSort(new int[]{6, 5, 4, 3, 2, 1}, 6);
    }

    public static void bubbleSort1(int[] a, int n) {

        if (n <= 1) {
            return;
        }

        //循环n-1次
        for (int i = 0; i < n - 1; i++) {

            boolean switchFlag = false;
            //冒泡次数
            for (int j = 0; j < (n - 1) - j; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    switchFlag = true;
                }
            }

            if (!switchFlag) {
                break;
            }
        }

    }

    /**
     * 插入排序
     * 分区，已排序区间，未排序区间
     * 取出未排序区间元素，遍历已排序区间，找到插入位置
     * @param a
     * @param n
     */
    public void insertSort(int[] a, int n) {

        //第一个元素a[0]，定为已排序区间
        for (int i = 1; i < n; i++) {

            //j为已排序区间的最后一个元素下标，即未排序的前一个元素坐标
            int j = i - 1;
            //遍历已排序区间，找到a[i]需要插入的位置
            //遍历过程中，遇到比当前元素大的，数组每个元素都需要往后移动一格
            //那么a[i]的位置就被挤掉了
            //所以需要缓存
            int value = a[i];
            for (;j >= 0; j --) {

                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    //a[j] <= value 找到位置，插入的位置应该是j+1
                    // a[j] == value 时候，没有交换位置，所以是稳定的排序
                    break;
                }
            }

            //j这里可能取值到 j == -1 a[0]
            a[j+1] = value;
        }

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
            System.out.println("第" + (i + 1) + "次外层循环开始:" + Arrays.toString(a));

            boolean switchFlag = false;
            for (int j = 0; j < n - 1 - j; j++) {
                System.out.println("进入处理");
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    switchFlag = true;
                }
            }
            System.out.println("第" + (i + 1) + "次外层循环结束:" + Arrays.toString(a));

            if (!switchFlag) {
                //当一次比较没有交换。证明已经排序完毕
                break;
            }
        }
    }
}
