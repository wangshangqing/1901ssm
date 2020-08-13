package com.hy.ssm.utils;

/**
 * @Auther: wangsq
 * @Date: 2020/7/30 15:33
 * @Description:
 */
public class MsgUtils {

    private String code;//0代表成功  1代表404  2代表500
    private String msg;//提示
    private String data;//结果

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
