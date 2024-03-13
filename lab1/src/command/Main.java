package command;

public class Main {
    public static void main(String[] args) {
        //First part of the lab
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        n += Integer.parseInt("10101", 2); // Add binary number 10101 to the result
        n += Integer.parseInt("FF", 16);   // Add hexadecimal number FF to the result
        n *= 6;
        System.out.println(n);
        while (n > 9)
            n = sumOfDigits(n);
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);

        //Homework
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int k = Integer.parseInt(args[2]);

            // Check if a < b and k is a positive number
            if (a >= b || k < 0) {
                System.err.println("Invalid arguments");
                return;
            }

            long startTime = System.nanoTime();

            Kreductible instance = new Kreductible();
            String kReducibleNumbers = instance.findNumbers(a, b, k);
            System.out.println("check");
            long endTime = System.nanoTime();

            System.out.println("K-reductible numbers: " + kReducibleNumbers);
            System.out.println("Running time: " + (endTime - startTime) + " nanoseconds");

        } catch (NumberFormatException e) {
            System.err.println("Arguments must be integers.");
        }
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

