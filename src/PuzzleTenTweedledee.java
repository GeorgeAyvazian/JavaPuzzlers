public class PuzzleTenTweedledee
{
        public static void main(String... args)
        {
                Object x = null;
                String i = "";

//                x += i; Compilation error
                x = x + i;
                System.out.println(x);
        }
}
