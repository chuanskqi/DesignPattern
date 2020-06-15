package argorithm.sort;

import java.util.Arrays;

public class BubboSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,10,1,3,7,10,20,15};

        System.out.println(Arrays.toString(bubble(arr)));
    }

    /**
     * 时间复杂度:O(n²)
     * 空间复杂度 O(1)
     * @param array
     * @return
     */
    public static int[] bubble(int[] array) {

        for (int i=0; i < array.length; i++) {
            boolean flag = false;
            for (int j=0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {return array;}
        }
        return array;
    }
}
