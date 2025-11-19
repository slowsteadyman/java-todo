package todo;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Application {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        Terminal terminal = Helper.terminalBuilder();
        LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();
        TerminalManager terminalManager = new TerminalManager(terminal, lineReader);
        TodoApp todoApp = new TodoApp(dbManager, terminalManager);
        todoApp.run();
    }
}
