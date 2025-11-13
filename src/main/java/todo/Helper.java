package todo;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class Helper {
    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static <T> T repeatUntilValid(Supplier<String> readInput, Function<String, T> validator) {
        String input;
        T validatedInput;

        while (true) {
            try {
                input = readInput.get();
                validatedInput = validator.apply(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return validatedInput;
    }
}
