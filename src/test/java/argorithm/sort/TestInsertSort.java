package argorithm.sort;

import java.util.Arrays;

public class TestInsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 4, 3, 2, 1};

        insertSort(array, 6);

        System.out.println(Arrays.toString(array));
    }

    /**
     * 插入排序
     * 分区，已排序区间，未排序区间
     * 取出未排序区间元素，遍历已排序区间，找到插入位置
     * @param a
     * @param n
     */
    public static void insertSort(int[] a, int n) {
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
            //为什么不在循环内设置？ 因为循环内不一定找到value的位置
            a[j+1] = value;
        }

    }

}
