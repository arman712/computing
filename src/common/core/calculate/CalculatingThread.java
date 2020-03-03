package common.core.calculate;

import common.data.ResultData;

public class CalculatingThread extends Thread {
    private long startNumber;
    private long endNumber;

    public CalculatingThread(long startNumber, long endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.start();
    }

    public void run() {
        long sum = 0L;
        long startTime = System.nanoTime();

        for (long i = startNumber; i <= endNumber; i++) {
            sum += i;
        }

        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;

        synchronized (ResultData.class) {
            ResultData.setStreamsResult(ResultData.getStreamsResult() + sum);
            ResultData.setStreamsTime(ResultData.getStreamsTime() + resultTime);
            ResultData.setCompletedThreadCount(ResultData.getCompletedThreadCount() + 1);
        }
    }
}
