import com.hemebiotech.analytics.AnalyticsCounter;

import java.util.*;

/**
 * A class only used a main program to run tests
 * @author Elien
 * @version 0.1.0
 */
public class TestClass {
    /**
     * the main entry of the test class
     * @param args nothing to say
     */
    public static void main(String[] args) {
/*
        //--------------------------------------------------------------------------------------
        //Test of ISymptomsWriter & its child class Write Map to Class
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("fever", 10);
        stringIntegerMap.put("insomnia", 3);
        stringIntegerMap.put("nausea", 7);
        stringIntegerMap.put("nose bleed", 1);
        stringIntegerMap.put("anxiety", 5);

        Map<String,Integer> stringIntegerTreeMap = new TreeMap<>();
        stringIntegerTreeMap.putAll(stringIntegerMap);

        //System.out.println(stringIntegerTreeMap.entrySet());

//        System.out.println("\ndebugging...");
//        System.out.println();

        ISymptomWriter fichier = new WriteMapStringIntegerToFile(stringIntegerMap);
        ISymptomWriter sortedFichier = new WriteMapStringIntegerToFile(stringIntegerTreeMap);

        sortedFichier.show();

//        System.out.println("\ndebugging...");
//        System.out.println();

        fichier.writeToFile("rscTest/write_test.out");
        sortedFichier.writeToFile("rscTest/write_sortedTest.out");

//        System.out.println("\ndebugging...");
//        System.out.println();
        //--------------------------------------------------------------------------------------

        //--------------------------------------------------------------------------------------
        //Test CountDataFromFile
        List<String> stringList = new ArrayList<>();

        stringList.add("fever");
        stringList.add("insomnia");
        stringList.add("nausea");
        stringList.add("constricted pupils");
        stringList.add("anxiety");
        stringList.add("cough");

        Collections.sort(stringList);

//        System.out.println("\ndebugging...");
//        System.out.println();

        ISymptomCounter symptomCounter = new CountDataFromFile("rscTest/symptoms_test.txt",stringList);
        symptomCounter.count();
        symptomCounter.show();

//        System.out.println("\ndebugging...");
//        System.out.println();

        ExtractLinesFromFile symptomReader = new ExtractLinesFromFile("rscTest/symptoms_test.txt");
        symptomReader.extract(true, false, true);

//        System.out.println("\ndebugging...");
//        System.out.println();

*/

        AnalyticsCounter analyticsCounter1 = new AnalyticsCounter("rscTest/symptoms_test.txt", "rscTest/analitycsCounter1_test.out");
        analyticsCounter1.execute();
//        System.out.println("\ndebugging...");
//        System.out.println();
    }
}
