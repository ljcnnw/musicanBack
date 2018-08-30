package com.musican.Utils;

public class ReturnMessage {
    public int code;//错误代码
    public Object data;//数据
    public String message;//错误信息
    public boolean success;//是否成功

    public static final int CODE_SUCCESS = 200;//请求成功
    public static final int CODE_FIAL = 500;//后台错误
    public static final int CODE_NOTFIND = 404;//路径错误
    public static final int CODE_TIMEOUT = 504;//超时


    /**
     * 构造函数
     */
    public ReturnMessage() {
        super();
        this.success = false;
    }

    /**
     * 获得到code
     *
     * @param i 错误代码
     */
    public ReturnMessage(int i) {
        super();
        this.success = false;
        switch (i) {
            case CODE_SUCCESS:
                message = "请求成功";
                success = true;
                this.code = CODE_SUCCESS;
                return;
            case CODE_FIAL:
                message = "请求失败";
                this.code = CODE_FIAL;
                return;
            case CODE_NOTFIND:
                message = "路径错误";
                this.code = CODE_NOTFIND;
                return;
            case CODE_TIMEOUT:
                message = "服务器超时";
                this.code = CODE_TIMEOUT;
                return;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}
