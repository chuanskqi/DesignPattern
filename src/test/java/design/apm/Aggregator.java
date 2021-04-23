package design.apm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregator {

    private MetricsStorage metricsStorage;
    public Aggregator(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    /**
     * 统计计算接口请求信息
     * @param requestInfos
     * @param durationInMillis
     * @return
     */
    public Map<String, RequestStat> aggregat(Map<String, List<RequestInfo>> requestInfos,
                                             long durationInMillis) {
        Map<String, RequestStat> requestStatMap = new HashMap<>();

        for (String transCode : requestInfos.keySet()) {
            List<RequestInfo> requestInfoPer = requestInfos.get(transCode);

            //统计每一个交易
            RequestStat requestStat = doAggregat(requestInfoPer);

            requestStatMap.put(transCode, requestStat);
        }
        return requestStatMap;
    }

    public RequestStat doAggregat(List<RequestInfo> requestInfoPer) {
        RequestStat requestStat = new RequestStat();

        return requestStat;
    }
}
