package com.demo.zk.myread.data;

/**
 * ClassName:com.demo.zk.myread.data
 * Author: zk<p>.
 * time: 2016/9/8 22:42.
 * Function:
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class HttpResult<T> {
    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
