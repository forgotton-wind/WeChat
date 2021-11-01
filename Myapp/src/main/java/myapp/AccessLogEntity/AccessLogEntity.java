package myapp.AccessLogEntity;

import lombok.Data;

@Data
public class AccessLogEntity {
    //模块名称
    private String moduleName;
    //APP版本号
    private String appVersion;

    //会话Id
    private String sid;
    //消息跟踪Id
    private String traceId;

    //请求时间，格式：yyyMMddHHmmss
    private String requestTime;
    //被访问的方法名
    private String classMethod;
    //请求Uri
    private String requestUri;
    //请求Query
    private String requestQuery;
    //请求参数
    private String requestBody;
    //响应参数
    private String responseBody;
    //处理耗时（ms）
    private Long timeCost;
}
