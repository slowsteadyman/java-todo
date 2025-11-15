package todo;

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

    public static String repeatUntilWithInput(HashMap<String, String> input, Function<HashMap<String, String>, String> repeat, BiConsumer<String, HashMap<String, String>> until) {
        String output;

        while (true) {
            try {
                output = repeat.apply(input);
                until.accept(output, input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return output;
    }
}
