package google;

public class Palindrome {

    public static void main(String... args) {
        int input = 44;
        System.out.println(findRepresentation(input));
    }

    private static int findRepresentation(int n) {
        for (int base = 2; ; base++) {
            int largestDigit;
            {
                int i = 0;
                int max = base;
                while (max < n) {
                    i++;
                    max *= base;
                }
                largestDigit = i + 1;
            }
            int[] digitArr = new int[largestDigit];
            digitArr[0] = 1;
            for (int i = 1; i < largestDigit; i++) {
                int multiple = 1;
                for (int j = 0; j < i; j++) {
                    multiple *= base;
                }
                digitArr[i] = multiple;
            }
            int[] numberArr = new int[largestDigit];
            int total = n;
            outer: for (int i = numberArr.length - 1; i >= 0 ; i--) {
                int multiple = digitArr[i];
                int j = 0;
                for (; j < base && j * multiple <= total; j++) {
                    if (j * multiple == total) {
                        numberArr[i] = j;
                        break outer;
                    }
                }
                numberArr[i] = j - 1;
                total -= numberArr[i] * digitArr[i];
            }
            int start = numberArr.length - 1, end = 0;
            while (start > end && numberArr[start] == numberArr[end]) {
                start--;
                end++;
            }
            if (start <= end) {
                return base;
            }
        }
    }

}
