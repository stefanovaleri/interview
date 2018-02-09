package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser2 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing file");
        }
        File file = new File(args[0]);
        new Parser2(file);
    }

    public Parser2(File file) {
        System.out.println("Parsing file " + file);

        while (!file.exists()) {
            System.err.println("Waiting for file...");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        BufferedReader reader = null;
        try {
            //reader = new BufferedReader(new FileReader(file), 2048);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"), 2048);
            while (true) {
                String line = reader.readLine();
                if (line != null) {
                    System.out.println("Waiting for lines");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    parseLine(line);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
    }

	public Record parseLine(String line) {
        Record record = new Record();
        String[] tokens = line.split(" ");
        
        return record;
	}
}