import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("یک عدد وارد کنید (برای خروج q را وارد کنید):");
                String num1Str = input.next();

                if (num1Str.equalsIgnoreCase("q")) {
                    break; // خروج از حلقه
                }

                double num1;
                try {
                    num1 = Double.parseDouble(num1Str);
                } catch (NumberFormatException e) {
                    System.out.println("ورودی نامعتبر. لطفاً یک عدد معتبر وارد کنید.");
                    continue; // رفتن به دور بعدی حلقه
                }

                System.out.println("یک عملگر (+، -، *، /) وارد کنید:");
                String operator = input.next();

                System.out.println("عدد دوم را وارد کنید:");
                String num2Str = input.next();

                double num2;
                try {
                    num2 = Double.parseDouble(num2Str);
                } catch (NumberFormatException e) {
                    System.out.println("ورودی نامعتبر. لطفاً یک عدد معتبر وارد کنید.");
                    continue;
                }

                double result;

                try {
                    switch (operator) {
                        case "+" -> result = num1 + num2;
                        case "-" -> result = num1 - num2;
                        case "*" -> result = num1 * num2;
                        case "/" -> {
                            if (num2 == 0) {
                                throw new ArithmeticException("تقسیم بر صفر ممکن نیست.");
                            }
                            result = num1 / num2;
                        }
                        default -> throw new IllegalArgumentException("عملگر نامعتبر.");
                    }

                    System.out.println("نتیجه: " + result);

                } catch (ArithmeticException | IllegalArgumentException e) {
                    System.out.println("خطا: " + e.getMessage());
                }
            }
        }

        System.out.println("خارج شدید.");
    }
}
