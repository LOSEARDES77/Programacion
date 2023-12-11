package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int[] times = new int[]{44, 82, 69, 81};
    private static final int[] distances = new int[]{202,1076,1138,1458};

    public static void main(String[] args) {
        List<Integer> waysToBeat = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            int time = times[i];
            int distance = distances[i];
            int beaten = 0;
            for (int j = 0; j < time; j++){
                int timeLeft = time-j;
                int distanceTaken = timeLeft * j;

                if (distanceTaken > distance )
                    beaten++;
            }
            waysToBeat.add(beaten);
        }
        long mult = 1;
        for (int i : waysToBeat)
            mult *= i;
        System.out.println(mult);
        long[] arr = transformToOneRace();
        long time = arr[0];
        long distance = arr[1];
        long beaten = 0;
        for (long j = 0; j < time; j++){
            long timeLeft = time-j;
            long distanceTaken = timeLeft * j;

            if (distanceTaken > distance )
                beaten++;
        }
        System.out.println(beaten);

    }

    private static long[] transformToOneRace(){
        StringBuilder times1 = new StringBuilder();
        StringBuilder distances1 = new StringBuilder();
        for (int i : times)
            times1.append(i);

        for (int i : distances)
            distances1.append(i);

        return new long[]{Long.parseLong(times1.toString()), Long.parseLong(distances1.toString()) };
    }
}