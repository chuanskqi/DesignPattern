package argorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 希尔排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,10,1,3,7,10,20,15};

        System.out.println(Arrays.toString(insertSort(arr)));

    }

    /**
     * 把数组分为两段，一段是排序好的，一段是未排序的
     * 将未排序的插入到排序段中
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            int value = array[i];
            for (; j >= 0 ; j--) {
                if (array[j]>value) {
                    array[j+1] = array[j];
                } else {
                    //array[j] <= value
                    break;
                }
            }
            array[j + 1] = value;
        }
        return array;
    }
}
