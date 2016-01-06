package com.github.cheesesoftware.PowerfulPermsAPI;

public abstract class ResultRunnable<T> implements Runnable {
    
    protected T result = null;
    protected boolean sameThread = false;
    
    public ResultRunnable() {

    }
    
    public ResultRunnable(boolean sameThread) {
        this.sameThread = sameThread;
    }

    public void setResult(T result) {
        this.result = result;
    }
    
    public boolean sameThread() {
        return this.sameThread;
    }
    
}
