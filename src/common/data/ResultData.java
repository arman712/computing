package common.data;

public class ResultData {
   private static long result;
   private static long resultTime;
   private static volatile long streamsResult;
   private static volatile long streamsTime;
   private static volatile long completedThreadCount;

    public static long getResult() {
        return result;
    }

    public static void setResult(long result) {
        ResultData.result = result;
    }

    public static long getResultTime() {
        return resultTime;
    }

    public static void setResultTime(long resultTime) {
        ResultData.resultTime = resultTime;
    }

    public static synchronized long getStreamsResult() {
        return streamsResult;
    }

    public static synchronized void setStreamsResult(long streamsResult) {
        ResultData.streamsResult = streamsResult;
    }

    public static synchronized long  getStreamsTime() {
        return streamsTime;
    }

    public static synchronized void setStreamsTime(long streamsTime) {
        ResultData.streamsTime = streamsTime;
    }

    public static synchronized long getCompletedThreadCount() {
        return completedThreadCount;
    }

    public static synchronized void setCompletedThreadCount(long completedThreadCount) {
        ResultData.completedThreadCount = completedThreadCount;
    }
}
