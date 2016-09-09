package com.demo.zk.myread.net;

/**
 * ClassName:com.demo.zk.myread.net
 * Author: zk<p>.
 * time: 2016/9/8 22:45.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class ApiException extends RuntimeException {
    public ApiException() {
        this("服务器异常...");
    }

    public ApiException(String message) {
        super(message);
    }
}
