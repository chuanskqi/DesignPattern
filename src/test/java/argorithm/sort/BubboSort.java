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
        for (int x = 0; x < array.length; x++) {
            boolean flag = false;
            for (int y = 0; y < array.length - x - 1; y++) {
                if (array[y] > array[y+1]) {
                    int temp = array[y + 1];
                    array[y+1] = array[y];
                    array[y] = temp;
                    flag = true;
                }
            }
            if (flag) {return array;}
        }
        return array;
    }
}
