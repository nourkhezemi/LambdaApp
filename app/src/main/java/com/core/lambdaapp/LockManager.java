package com.core.lambdaapp;


import android.os.PowerManager;

public class LockManager {

    private PowerManager powerManager;
    private PowerManager.WakeLock completeWakeLock;
    private PowerManager.WakeLock incompleteWakeLock;
    private PowerManager.WakeLock missingWakeLock;

    public LockManager(PowerManager powerManager) {
        this.powerManager = powerManager;
        this.completeWakeLock = this.powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "complete:");
        System.out.println("Wakelock 1 : " + System.identityHashCode(this.completeWakeLock));
        this.incompleteWakeLock = this.powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "incomplete:");
        System.out.println("Wakelock 2 : " + System.identityHashCode(this.completeWakeLock));
        this.missingWakeLock = this.powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "missing:");
        System.out.println("Wakelock 3 : " + System.identityHashCode(this.completeWakeLock));
    }

    public void acquire() {
        completeWakeLock.acquire();
        incompleteWakeLock.acquire();
        missingWakeLock.acquire();
        System.out.println("Wakelock : " + System.identityHashCode(this.completeWakeLock));
        System.out.println("Wakelock : " + System.identityHashCode(this.incompleteWakeLock));
        System.out.println("Wakelock : " + System.identityHashCode(this.missingWakeLock));
    }

    public void release() {
        completeWakeLock.release();
        if (2+2==5) {
            incompleteWakeLock.release();
        }
    }
}
