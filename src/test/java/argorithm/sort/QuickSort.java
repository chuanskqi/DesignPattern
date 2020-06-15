package argorithm.sort;

import java.util.Arrays;

/**
 * 快排思想
 * 1、分治:通过递归实现，直到数组不可再分位置，即数组只有一个元素的时候，不可再分
 * 2、排序算法，随机获取一个partition，将数组一分为二，小于partition的在一侧，大于的在另一侧
 * 3、不稳定的排序：会改变原数组相同元素的顺序 例如 [6,6,4,5] 第一次分区 6和4要对调，[4,6] 5 [6]
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{15,22,33,11,8,3,9,7,1,2,5};

        System.out.println(Arrays.toString(arr));
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] source) {
        sort(source, 0, source.length-1);
    }

    public static void sort(int[] source,int left, int right) {
        //和归并排序一样的终结条件，可以发现，当left == right的时候，数组不可分了，即只有一个元素的数组
        //[x] 如何在区分partition呢？
        if (left >= right) return;

        int partition = calPartition(source,left,right);

        //分区后，再对两个分区数组进行排序
        sort(source,left, partition - 1);
        sort(source,partition + 1, right);

    }

    /**
     * 计算patition所在的下标
     * @param source
     * @param left
     * @param right
     * @return
     */
    public static int calPartition(int[] source,int left, int right) {
        //默认在数组中取一个元素，作为分区元素
        //默认数组末尾元素
        int patition = source[right];

        //快排是原地排序
        //不使用额外内存数组
        int i = left;
        //将left ~ partition-1 下标的元素与partition进行比对
        //将数组区分为left~i 为小于it的区间，当j遍历完数组后，i之后的区间都是大于partition的
        //最终将i+1与partition替换
        //[left...i] [partition] [i+1...right]

        //这里比较[left .. right-1]的元素
        for (int j = left; j <= right-1; j++) {
            if (source[j] < patition) {
                //将元素放到左区间
                int temp = source[j];
                source[j] = source[i];
                source[i] = temp;
                i++;
            }
        }
        //这时A[i] 一定比partition大
        int temp = source[i];
        source[i] = patition;
        source[right] = temp;
        //返回partition的下标
        return i;
    }
}
