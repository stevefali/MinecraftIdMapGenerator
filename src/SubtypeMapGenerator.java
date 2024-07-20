import java.util.HashMap;
import java.util.Map;

public class SubtypeMapGenerator {

    private static Map<Integer, Integer> multiples = new HashMap<>();


    public static void countMultiples(int[] itemIds) {

        for (int id : itemIds) {
            if (!multiples.containsKey(id)) {
                int counter = 0;
                for (int queryId : itemIds) {
                    if (queryId == id) {
                        counter++;
                    }
                }
                if (counter > 1) {
                    multiples.put(id, counter);
                }

            }
        }
       for (Map.Entry<Integer, Integer> entry : multiples.entrySet()) {
           System.out.println("subtypeQuantities.put(" + entry.getKey() + ", " + entry.getValue() + ");");
       }
       System.out.println(" ");
       System.out.println("Number of items: " + multiples.size());
       System.out.println("Total quantities: " + addUpQuantities(multiples));
    }

    private static int addUpQuantities(Map<Integer, Integer> multiples) {
        int quant = 0;
        for(Map.Entry<Integer, Integer> entry : multiples.entrySet()) {
            quant += entry.getValue();
        }
        return quant;
    }
}
