package argorithm.hash;

import com.google.common.base.Stopwatch;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.shiro.codec.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;

public class BloonFilterTest {
    public static void main(String[] args) throws Exception {
        long x  = optimalNumOfBits(10000 * 100, 0.01);
        System.out.println((double) x/8/1024 + "kb");
        System.out.println((double) x/8/1024/1024 + "mb");
    }

    /**
     * optimalM(1000, 0.0000000000000001) = 76680 which is less than 10kb.
     * @param n
     * @param p
     * @return
     */
    private static long optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }
    private static void test() throws Exception {

        int size = 10000 * 1000;
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), size);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (long x = 654301199200000000L; x < 654301199211000000L; x++) {
            messageDigest.update(String.valueOf(x).getBytes());
            byte[] digest = messageDigest.digest();
            bloomFilter.put(Hex.encodeToString(digest));
        }
        System.out.println("插入" +size+ "条花费：" + stopwatch.elapsed(TimeUnit.MILLISECONDS));


        bloomFilter.put("1992822");
        String test1 = String.valueOf(size + 1);
        String test2 = String.valueOf(size + 2);
        String test3 = String.valueOf(size + 3);
        String test4 = String.valueOf(size + 4);
        String test5 = String.valueOf(654301199211000000L);
        System.out.println("1:" + bloomFilter.mightContain("1"));
        System.out.println("1992822:" + bloomFilter.mightContain("1992822"));
        System.out.println(test1 + bloomFilter.mightContain(test1));
        System.out.println(test2 + bloomFilter.mightContain(test2));
        System.out.println(test3 + bloomFilter.mightContain(test3));
        System.out.println(test4 + bloomFilter.mightContain(test4));
        System.out.println(test5 + bloomFilter.mightContain(test5));
        bloomFilter.put(test5);
        System.out.println(test5 + bloomFilter.mightContain(test5));
    }
}
