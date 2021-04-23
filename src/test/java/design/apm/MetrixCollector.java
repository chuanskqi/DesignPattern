package design.apm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetrixCollector {

    private MetricsStorage metricsStorage;

    public MetrixCollector(MetricsStorage metricsStorage){
        this.metricsStorage = metricsStorage;
    }

    public void record(RequestInfo requestInfo) {
        metricsStorage.save(requestInfo);
    }

    public static void main(String[] args) {
        List<RequestInfo> list = new ArrayList<>();

        RequestInfo requestInfo1  = new RequestInfo();
        requestInfo1.setTransCode("t001");
        requestInfo1.setTimeStamp(System.currentTimeMillis());

        RequestInfo requestInfo2 = new RequestInfo();
        requestInfo2.setTransCode("t001");
        requestInfo2.setTimeStamp(System.currentTimeMillis());

        RequestInfo requestInfo3 = new RequestInfo();
        requestInfo3.setTransCode("t002");
        requestInfo3.setTimeStamp(System.currentTimeMillis());

        list.add(requestInfo1);
        list.add(requestInfo2);
        list.add(requestInfo3);

        Map<String, List<RequestInfo>> map = new HashMap<String, List<RequestInfo>>();
        for (RequestInfo info : list) {
            if (map.get(info.getTransCode()) == null) {
                map.put(info.getTransCode(), new ArrayList<RequestInfo>());
            }
            map.get(info.getTransCode()).add(info);
        }
    }
}
