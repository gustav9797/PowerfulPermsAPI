package com.github.cheesesoftware.PowerfulPermsAPI;

public interface IScheduler {
    public void runAsync(Runnable runnable, boolean sameThread);

    /*
     * Note: Bungee can't run sync tasks, all of them are asynchronous.
     */
    public void runSync(Runnable runnable, boolean sameThread);

    /*
     * Note: Bungee can't run sync tasks, all of them are asynchronous.
     */
    public void runSync(Runnable runnable);

    public int runRepeating(Runnable runnable, int seconds);
    
    public void stopRepeating(int taskId);
}
