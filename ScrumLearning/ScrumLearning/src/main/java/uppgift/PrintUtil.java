package uppgift;

public class PrintUtil {
        public static final String RESET = "\033[0m";
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
        public static final String YELLOW = "\033[0;33m";
        public static final String BLUE = "\033[0;34m";

        public static void printColor(String text, String color) {
            System.out.println(color + text + RESET);
        }
    }