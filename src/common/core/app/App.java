package common.core.app;

import common.core.calculate.Calculations;
import common.data.ResultData;

import java.util.Scanner;

public class App {

    public static void run(Scanner scanner) {

        long number;
        long threadNumber;


        System.out.println("please type in the console a number greater than one and press enter");
        System.out.println("to exit the program, type EXIT and press enter");
        if (scanner.hasNextLong()) {
            number = scanner.nextLong();
            if (number > 1) {
                System.out.println("please enter the number of threads and press enter");
                if (scanner.hasNextLong()) {
                    threadNumber = scanner.nextLong();
                    if (threadNumber > 1) {
                        Calculations.calculation(number);
                        Calculations.threadCalculations(number, threadNumber);
                        while (true) {
                            if (ResultData.getCompletedThreadCount() == threadNumber) {
                                System.out.println("sequential calculation result = " + ResultData.getResult() + ", time = " + ResultData.getResultTime()+" nanoseconds");
                                System.out.println("parallel computation result = " + ResultData.getStreamsResult() + ", time = " + ResultData.getStreamsTime()+" nanoseconds");
                                if (ResultData.getResultTime() < ResultData.getStreamsTime()) {
                                    long difference = ResultData.getStreamsTime() - ResultData.getResultTime();
                                    System.out.println("sequential computation on " + difference + " nanoseconds faster than parallel computing");
                                } else {
                                    long difference = ResultData.getResultTime() - ResultData.getStreamsTime();
                                    System.out.println("parallel computation on " + difference + " nanoseconds faster than sequential computation");
                                }
                                System.out.println();
                                 zeroingResultData();
                                break;
                            }
                        }
                    } else {
                        System.out.println("the number of threads cannot be less than two");
                    }
                }
                else if (scanner.next().equals("EXIT")) {

                    System.exit(0);
                } else {
                    System.out.println("the specified parameter must be a numeric value greater than one");
                }
            } else {
                System.out.println("the number must be greater than one");
            }

        } else if (scanner.next().equals("EXIT")) {
            System.exit(0);
        } else {
            System.out.println("the specified parameter must be a numeric value greater than one");
        }
    }

    private static void  zeroingResultData(){
        ResultData.setResult(0L);
        ResultData.setResultTime(0L);
        ResultData.setCompletedThreadCount(0L);
        ResultData.setStreamsResult(0L);
        ResultData.setStreamsTime(0L);
    }
}


