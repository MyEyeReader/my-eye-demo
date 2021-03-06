import java.util.Scanner;

public class Main {
    // https://en.wikipedia.org/wiki/Braille_ASCII
    public static String BRAILLE_ENCODING = " A1B'K2L@CIF/MSP\"E3H9O6R^DJG>NTQ,*5<-U8V.%[$+X!&;:4\\0Z7(_?W]#Y)="; // maps from U+2800 (space) to U+283F (=) 
    public static String EXIT_STRING = "exit";

    public static String parseText(String text) {
        text = text.toUpperCase();
        text = text.replaceAll("([0-9])([A-Z])", "$1:$2"); // distinguish between numbers and letters
        text = text.replaceAll("([0-9]+)", "#$1"); // prefix numbers with # sign
        text = text.chars()
            .map(c -> BRAILLE_ENCODING.indexOf(c) == -1 ? ' ' : c)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append) 
            .toString(); // filters out illegal characters. very gross looking.
        return text;
    }

    public static char toUnicode(char c) {
        return (char) (0x2800 + toByte(c));
    }

    public static byte toByte(char c) {
        // https://en.wikipedia.org/wiki/Braille_Patterns
        return (byte) BRAILLE_ENCODING.indexOf(c);
    }

    public static String getInput(Scanner input) {
        try {
            System.out.print("text>");
            return input.nextLine();
        }
        catch (Exception e) {
            return EXIT_STRING;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            String text = getInput(input);
            if (text.equals(EXIT_STRING))
                break;
            text = parseText(text);
            for (char c: text.toCharArray())
                System.out.println(c + " " + toUnicode(c) + " " + toByte(c));
        }
        input.close();
    }
}