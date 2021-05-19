package xyz.aiinirii.carboninfosys.common.api;

/**
 * 封装API的错误码
 *
 * @author AIINIRII
 */
public interface IErrorCode {
    /**
     * 获取API的错误码
     *
     * @return API的错误码
     */
    long getCode();

    /**
     * 获取API的错误信息
     *
     * @return API的错误信息
     */
    String getMessage();
}
