package com.escape.json;

/**
 * Created by Sheikz on 8/17/2016.
 */
public class JSONReturnObject<T>
{
    private boolean success;
    private String message;
    private T result;

    public JSONReturnObject(boolean success, String message, T result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    /**
     * Return a simple JSON Response
     * @param success indicates if the response is success or failure
     * @return
     */
    public static JSONReturnObject simpleResponse(boolean success)
    {
        return new JSONReturnObject(success, "", null);
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
