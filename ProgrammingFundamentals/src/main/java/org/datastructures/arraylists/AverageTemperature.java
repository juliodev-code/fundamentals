package org.datastructures.arraylists;

import java.util.Scanner;

public class AverageTemperature {
    static void main() {
        Scanner console = new Scanner(System.in);
        System.out.print("How many temperatures will you insert?:");
        int numTemps = console.nextInt();
        int [] temps = new int[numTemps];
        int sum = 0;
        for(int i = 0 ;i < numTemps; i++){
            System.out.print("Insert the temperature number " + (i + 1)+ " :");
            temps[i] = console.nextInt();
            sum += temps[i];
        }

        double average = (double) sum / numTemps;
        //count days above the average
        int above = 0;
        for(int i = 0; i < temps.length; i++){
            if(temps[i] > average) above++;
        }

        System.out.println();
        System.out.print("Average temp = " + average);
        System.out.print(above + "days above the average");


    }
}
