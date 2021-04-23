package design.openclose;

import com.google.common.annotations.VisibleForTesting;
import lombok.Data;

import java.util.*;
import java.util.concurrent.TimeUnit;
public class Aggregator {


    public static void main(String[] args) {

        Suns suns = new Suns();
        Docs docs = new Docs();
        suns.add("123","abc");
        docs.add("456","efg");

        System.out.println(suns.getMap().get("456"));
        System.out.println(docs.getMap().get("456"));


        System.out.println(TimeUnit.SECONDS.toMillis(2));
        List<RequestInfo> requestInfos = null;
        for (RequestInfo info : requestInfos) {
        }

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, new Date(), TimeUnit.DAYS.toMillis(1));
    }


    @VisibleForTesting
    public void test() {

    }
    public static ApiSate aggrega(List<RequestInfo> requestInfos) {
        double maxResponseTime = -1;
        double minResponseTime = -1;
        double avgResponseTime = -1;
        double p999ResponseTime = -1;
        double p99ResponseTime = -1;

        long tps = 0;
        double count = 0;

        for (RequestInfo info : requestInfos) {

            if ((info.getResponseTime() - info.getRequestTime()) > maxResponseTime) {
                maxResponseTime = info.getResponseTime() - info.getRequestTime();
            }
        }


        return new ApiSate();

    }
}
class Parentt {
    private Map map = new HashMap();

    public Map getMap() {
        return map;
    }

    public void add(String key, String value) {
        map.put(key, value);
    }
}
class Suns extends Parentt {

}

class Docs extends  Parentt {

}

@Data
class ApiSate {

    /**
     * 最大响应时间
     */
    private double maxResponseTime;
    /**
     * 最小响应时间
     */
    private double minResponseTime;
    /**
     * 平均响应时间
     */
    private double avgResponseTime;

    private double p999ResponseTime;

    private double p99ResponseTime;

    private long count;

    private long tps;
}

@Data
class RequestInfo {
    private String transCode;

    private double requestTime;

    private double responseTime;

}


