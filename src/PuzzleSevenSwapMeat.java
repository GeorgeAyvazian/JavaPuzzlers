public class PuzzleSevenSwapMeat
{
        public static void main(String... args)
        {
                int x = 1984; // (0x7c0)   0111 1100 0000
                int y = 2001; // (0x7d1)   0111 1101 0001
                x ^= y ^= x ^= y;
                System.out.println("x = " + x + "; y = " + y);
        }
}
