package design.apm;

import lombok.Data;

@Data
public class RequestInfo {

    private String transCode;

    private double responseTime;

    private long timeStamp;
}
