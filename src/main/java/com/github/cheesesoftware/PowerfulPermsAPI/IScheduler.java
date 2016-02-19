package com.github.cheesesoftware.PowerfulPermsAPI;

public interface IScheduler {
    public void runAsync(Runnable runnable, boolean sameThread);
    
    public void runSync(Runnable runnable, boolean sameThread);
    
    public void runSync(Runnable runnable);
}
