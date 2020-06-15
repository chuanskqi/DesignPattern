package argorithm.sort;

import java.util.Arrays;

/**
 * 要点，多画二分图，分清数组下标，合并，递归
 * 1、分治，二分法
 * 2、合并有序数组
 * 总结：
 * 稳定排序
 * 但不是原地排序
 * 时间复杂度
 * nlog(n)
 * 空间复杂度
 * O(n) :虽然每次合并的时候开辟了数组空间去保存排序后的数组，但是合并完后，该数组空间就被释放了
 *
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{15,22,33,11,8,3,9,7,1,2,5};

        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] array) {
        mergeSort(array, 0, array.length-1);
        return array;
    }

    public static void mergeSort(int[] array,int left, int right) {
        //递归终结 条件
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, right, mid);
    }

    /**
     * 如何合并两个有序数组?
     * 设置游标i对应第一个数组头
     * 设置游标j对应第二个数组头
     * 循环判断array1[i]与array2[j]的大小，放入temp数组并递增i,j
     * 循环终结条件为i,j其中之一为数组的末尾时
     * 随后将另一数组剩余的部分合并到temp数组
     * 最终将temp数组拷贝到原数组，实现数组合并排序
     * @param source
     * @param left
     * @param right
     * @param mid
     */
    public static void merge(int[] source,int left,int right,int mid) {
        //[left..mid] [mid+1..rignt]
        int[] temp = new int[right - left + 1];
        int i = left;
        int j= mid + 1;
        int index = 0;
        //source [left..i..mid]  source[mid..j..right]
        while (i <= mid && j <= right) {
            if (source[i] <= source[j]) {
                temp[index ++] = source[i++];
            } else {
                temp[index ++] = source[j++];
            }
        }

        int start = i;
        int end = mid;
        if (i == mid + 1) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[index ++] = source[start ++];
        }

        for (int x = 0; x < temp.length; x++) {
            source[left + x] = temp[x];
        }

    }
}
