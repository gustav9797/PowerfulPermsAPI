package com.github.cheesesoftware.PowerfulPermsAPI;

public abstract class ResponseRunnable implements Runnable {

    protected boolean success = false;
    protected String response = "";
    protected boolean sameThread = false;

    public ResponseRunnable() {

    }

    public ResponseRunnable(boolean sameThread) {
        this.sameThread = sameThread;
    }

    public void setResponse(boolean success, String response) {
        this.success = success;
        this.response = response;
    }
    
    public String getResponse() {
        return this.response;
    }

    public boolean isSameThread() {
        return this.sameThread;
    }
}
