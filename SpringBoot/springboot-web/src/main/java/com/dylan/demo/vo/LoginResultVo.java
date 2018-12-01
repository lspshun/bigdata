package com.dylan.demo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
// @JsonInclude(JsonInclude.Include.NON_NULL) 是为了过滤不正常的输出（当输出为空的时候不输出）
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResultVo {
    private int code;
    private String info;
    public int getCode(){
        return code;
    }
    public String getInfo(){return info;}
    public void setInfo(int code){
        this.code = code;
    }
    public void setInfo(String info){
        this.info = info;
    }
}
