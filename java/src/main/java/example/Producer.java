package example;

import java.io.File;

public class Producer implements Parser {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Missing file");
        }
        File file = new File(args[0]);

        Producer producer = new Producer(file);
        producer.startProduction();
    }

	private File file;

    public Producer(File file) {
        this.file = file;
    }
    
    private void startProduction() {
        Reader reader = new Reader(file);
        reader.setParser(this);
        reader.start();       
	}
    
    @Override
    public void parseLine(String line) {
        Record record = new Record();
        String[] tokens = line.split(" ");
       
    }
    
}