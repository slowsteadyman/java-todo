package todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Helper {
    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String toIsoLocalDate(String basicIsoDate) {
        LocalDate localDate = LocalDate.parse(basicIsoDate, DateTimeFormatter.BASIC_ISO_DATE);
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
