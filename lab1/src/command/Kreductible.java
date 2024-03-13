package command;

public class Kreductible {
    public static boolean isKReductible(int number, int k) {
        int sum = number;
        while (sum != k && sum >= 10) {
            int nextSum = 0;
            while (sum > 0) {
                int digit = sum % 10;
                nextSum += digit * digit;
                sum /= 10;
            }
            sum = nextSum;
        }
        return sum == k;
    }

    public static String findNumbers(int a, int b, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (isKReductible(i, k)) {
                result.append(i).append(" ");
            }
        }
        return result.toString();
    }
}
