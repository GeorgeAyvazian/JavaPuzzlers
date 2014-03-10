import java.util.Random;

/**
 * The behavior of this program changed between release 1.4 of the Java platform and release 5.0. What does the program do
 * under each of these releases? (If you have access only to release 5.0, you can emulate the 1.4 behavior by compiling with the
 * -source 1.4 flag.)
 */
public class PuzzleSeventyFiveHeadsOrTails
{
        private static Random rnd = new Random();

        public static PuzzleSeventyFiveHeadsOrTails flip()
        {
                // In 1.4, if the second and third operands of the conditional operator were
                // of reference types, then one operand had to be a subtype of another
                // Hence, in 1.4 this would not compile
//                return rnd.nextBoolean() ? Heads.INSTANCE : Tails.INSTANCE;
                // The following does compile in 1.4:
//                return rnd.nextBoolean() ? Heads.INSTANCE : (PuzzleSeventyFiveHeadsOrTails)Tails.INSTANCE;
                // this is an alternative to the above:
                return rnd.nextBoolean() ? (PuzzleSeventyFiveHeadsOrTails) Heads.INSTANCE : Tails.INSTANCE;
                // So in 1.4, the awkward cast was necessary for the sole purpose of getting the source to compile
                // In 1.5 however, the conditional operator always returns the least common supertype of the second
                // and third operators. A least common super type is always guaranteed, because Object is the reference
                // type common to all other reference types

        }

        public static void main(String[] args)
        {
                System.out.println(flip());
        }

}

class Heads extends PuzzleSeventyFiveHeadsOrTails
{
        public static final Heads INSTANCE = new Heads();

        private Heads() {}

        @Override
        public String toString()
        {
                return "heads";
        }
}

class Tails extends PuzzleSeventyFiveHeadsOrTails
{

        public static final Tails INSTANCE = new Tails();

        private Tails() {}

        @Override
        public String toString()
        {
                return "tails";
        }
}

// In 1.4, it would be easier not to bother with such issues with type hierarchies and the conditional operator,
// and instead use the TypeSafe Enum pattern, which behaves like an enum (1.4 did not have enum support):
//public class CoinSide {
//        public static final CoinSide HEADS = new CoinSide("heads");
//        public static final CoinSide TAILS = new CoinSide("tails");
//        private final String name;
//        private CoinSide(String name) {
//                this.name = name;
//        }
//        public String toString() {
//                return name;
//        };
//        private static Random rnd = new Random();
//        public static CoinSide flip() {
//                return rnd.nextBoolean() ? HEADS : TAILS;
//        }
//        public static void main(String[] args) {
//                System.out.println(flip());
//        }
//}

// In 1.5, an actual enum can be used to represent the HEADS and TAILS instances
