package cn.star.clean.dto;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @param <T>
 */
@ApiModel(description = "响应结果")
public class ResponseMessage<T> implements Serializable {

    private static final long serialVersionUID = 8992436576262574064L;

    protected Boolean success;

    protected String errorMsg = "";

    protected T result;

    protected int errorCode;

    protected ResponsePage pagination;

    private Long timestamp;


    @ApiModelProperty("调用结果消息")
    public String getErrorMsg() {
        return errorMsg;
    }


    @ApiModelProperty(value = "状态码")
    public int getErrorCode() {
        return errorCode;
    }

    @ApiModelProperty("成功时响应数据")
    public T getResult() {
        return result;
    }

    /**
     * 封装分页对象
     * @return
     */
    @ApiModelProperty("分页数据")
    public ResponsePage getPagination() {
        return pagination;
    }


    @ApiModelProperty(value = "时间戳", required = true)
    public Long getTimestamp() {
        return timestamp;
    }


    public static <T> ResponseMessage<T> error(String message) {
        return error(500, message);
    }

    public static <T> ResponseMessage<T> error(int status, String message) {
        ResponseMessage<T> msg = new ResponseMessage<>();
        msg.errorMsg = message;
        msg.status(status).setSuccess(false);
        return msg.putTimeStamp();
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null);
    }

    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public static <T> ResponseMessage<T> ok(T result) {

        ResponseMessage<T> responseMessage = new ResponseMessage<T>()
            .putTimeStamp()
            .status(200)
            .setSuccess(true);
        if (result != null && result instanceof Page) {
            Page page = (Page) result;
            responseMessage.page(page)
                .result((T) page.getRecords());
        } else {
            responseMessage.result(result);
        }
        return responseMessage;
    }

    public ResponseMessage<T> result(T result) {
        this.result = result;
        return this;
    }

    public ResponseMessage<T> page(Page pagination) {
        if (pagination != null) {
            this.pagination = new ResponsePage();
            this.pagination.setCurrent(pagination.getCurrent());
            this.pagination.setPageSize(pagination.getSize());
            this.pagination.setTotal(pagination.getTotal());
        }
        return this;
    }

    public ResponseMessage() {
        // default implementation ignored
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this, "yyyy-MM-dd HH:mm:ss");
    }


    public ResponseMessage<T> status(int status) {
        this.errorCode = status;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public ResponseMessage<T> setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public ResponseMessage<T> setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }


    /**
     * ResponsePage
     */
    @Getter
    @Setter
    public static class ResponsePage implements Serializable {
        private Integer pageSize;
        private Integer current;
        private Long total;
    }
}