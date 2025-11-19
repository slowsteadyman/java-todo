package todo;

import java.io.IOException;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;

public class TerminalManager {
    private Terminal terminal;
    private LineReader lineReader;

    public TerminalManager(Terminal terminal, LineReader lineReader) {
        this.terminal = terminal;
        this.lineReader = lineReader;
    }

    public void close() {
        try {
            terminal.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readLine(String buffer) {
        return lineReader.readLine(null, null, (Character) null, buffer);
    }
}
