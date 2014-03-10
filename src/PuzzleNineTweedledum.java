public class PuzzleNineTweedledum
{
        public static void main(String... args)
        {
                short x = 0;
                int i = 123456;

                x += i;
                i = x + i;
//                x = x + i;  compilation error - narrowoing conversion w/o explicit cast
        }
}
