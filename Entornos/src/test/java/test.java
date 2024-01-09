import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String[] clearCommad = new String[1];
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            clearCommad[0] = "cls";
        } else {
            clearCommad[0] = "clear";
        }
        try {
            Process p = r.exec(clearCommad);
            p.waitFor();
            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;

            while ((line = b.readLine()) != null) {
                System.out.println(line);
            }

            b.close();
        } catch (IOException | InterruptedException ignored) {

        }

    }
}
