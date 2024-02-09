package core.basesyntax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WorkWithFile {
    public void getStatistic(String fromFileName, String toFileName) {
        int supplySum = 0;
        int buySum = 0;
        String readString = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            while ((readString = reader.readLine()) != null) {
                String[] strArray = readString.split(",");
                for (int i = 0; i < strArray.length; i += 2) {
                    if (strArray[i].startsWith("s")) {
                        supplySum += Integer.parseInt(strArray[i + 1]);
                    } else {
                        buySum += Integer.parseInt(strArray[i + 1]);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open file", e);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName))) {
            writer.write("supply,"
                    + supplySum + "\n" + "buy,"
                    + buySum + "\n" + "result,"
                    + (supplySum - buySum));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
