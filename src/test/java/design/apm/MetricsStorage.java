package design.apm;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {

    public void save(RequestInfo requestInfo);

    /**
     * 获取指定时间区间，某个的交易所有的请求列表
     * @param transCode
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return
     */
    List<RequestInfo> getRequestInfos(String transCode,
                                      long startTimeInMillis,
                                      long endTimeInMillis);

    /**
     * 获取指定时间区间，所有交易的请求列表
     * @param startTimeInMillis
     * @param endTimeInMillis
     * @return
     */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis,
                                                   long endTimeInMillis);

}



