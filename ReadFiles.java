import java.io.*;

public class ReadFiles {
    public void read(String write, String filename) throws IOException{
        String str = write;
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(str);
        writer.newLine();
        writer.close();
    }

    public void cleanFile(String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false));
        writer.close();
    }
}
