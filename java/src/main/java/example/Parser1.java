package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Parser1 {

    public static void main(String[] args) throws IOException {
        final File file = new File("/path/to/file/producer.log");
        while (!file.exists()) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("Waiting for file...");
        }
        Reader reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader in = new BufferedReader(reader, 2048);
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = in.readLine();
            if (s != null) {
                System.out.println(s);
            } else {
                System.out.println("FINE");
                break;
            }
        }
        in.close();
    }
}