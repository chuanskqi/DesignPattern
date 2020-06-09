package argorithm.sort;

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
     * 时间复杂度O(n2)
     * 空间复杂度O(1)
     * @param array
     * @return
     */
    public static int[] insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                //从排序好的里面找到位置
                //并移动数据
                if (array[j] > value) {
                    //大于value的前进一个
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            //插入value  j+1上一步j--了
            array[j+1] = value;
        }
        return array;

    }
}
