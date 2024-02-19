package org.zaragoza2023;

import java.util.*;

public class Netflix {
    public static void main(String[] args) {
        HashMap<String, Integer> netflix = new HashMap<>();

        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();

        while (!entrada.isEmpty() ) {
            String identifier = getName(entrada);
            int value = getValue(entrada, 1);
            if (value >= 30) {
                if (netflix.containsKey(identifier)) {
                    value += netflix.get(identifier);
                }
                netflix.put(identifier, value);
            }
            entrada = s.nextLine();
        }

        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        };


        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(netflix.entrySet());
        Collections.sort(sortedEntries, valueComparator);


        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            if (count++ >= 3) {
                break;
            }
            System.out.println(entry.getKey().trim() + ": " + entry.getValue());
        }
    }

    private static String getName(String entrada) {
        StringBuilder res = new StringBuilder();
        for (Character c : entrada.toCharArray())
            if (!Character.isDigit(c))
                res.append(c);
        return res.toString();
    }

    private static int getValue(String entrada, int index) {
        try {
            return Integer.parseInt(entrada.split(" ")[index]);
        }catch (NumberFormatException e){
            return getValue(entrada, ++index);
        }
    }

}
