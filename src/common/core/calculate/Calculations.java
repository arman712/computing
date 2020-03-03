package common.core.calculate;

import common.data.ResultData;


public class Calculations {

    public static void calculation(long number) {

        long sum = 0L;
        long startTime = System.nanoTime();
        for (long i = 0; i <= number; i++) {
            sum += i;
        }
        long endTime = System.nanoTime();
        long resultTime = endTime - startTime;
        ResultData.setResult(sum);
        ResultData.setResultTime(resultTime);
    }

    public static void threadCalculations(long number, long numberOfThreads) {
        long startNumber = 1L;
        long endNumber = number / numberOfThreads;
        long average = number / numberOfThreads;
        long remainder = number - (average * numberOfThreads);
        for (long i = 0; i < numberOfThreads; i++) {

            if (i == (numberOfThreads - 1)) {

                new CalculatingThread(startNumber, (endNumber + remainder));
                break;
            }

            new CalculatingThread(startNumber, endNumber);
            startNumber += average;
            endNumber += average;
        }



    }


}
