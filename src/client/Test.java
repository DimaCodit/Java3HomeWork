package client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileWriter historyWriter = new FileWriter("history.txt", true);

        BufferedWriter bufferWriter = new BufferedWriter(historyWriter);
        bufferWriter.write("ghjgjhgjj");
        bufferWriter.close();

    }
}
