package google;

import java.util.Random;

public class MaximuEquality {

    public static void main(String... args) {
//        int[] x = {1,4,1};
        Random random = new Random();
        int j;
        while((j = random.nextInt()) > 100 || j < 2);
        int[] x = new int[j];
        for (int i = 0; i < j; i++) {
            int i1;
            while((i1 = random.nextInt()) > 1000000 || i1 < 0 );
            x[i] = i1;
        }
        System.out.println("number of cars: " + j);
        System.out.println(answer(x));
    }

    private static int answer(int[] x) {
        int t = 0;
        int n = x.length;
        for (int aX : x) {
            t += aX;
        }
        if (n >= t || t % n == 0) {
            return n;
        }
        return n - 1;
    }
}
