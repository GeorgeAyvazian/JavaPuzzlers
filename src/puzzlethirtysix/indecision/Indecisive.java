package puzzlethirtysix.indecision;

/*
        This poor little program can't quite make up its mind. The decision method returns true. But it also returns false. What
        does it print? Is it even legal?

        public class Indecisive {
                public static void main(String[] args) {
                        System.out.println(decision());
                }

                static boolean decision() {
                        try {
                                return true;
                        } finally {
                                return false;
                        }
                }
        }
*/


public class Indecisive
{
        public static void main(String[] args)
        {
                System.out.println(decision());
        }

        static boolean decision()
        {
                try
                {
                        System.out.println("don't return anything");
                        return true;
                }
                finally
                {
                        System.out.println("don't return anything");
                }
        }
}


// First guess: the finally block will definitely execute after the return statement in the try block. However, the one
// and only statement in the finally block is a return statement - that probably doesn't return to anything as the
// try block will have already returned the value
// therefore, i predict it will only print true

// first guess was wrong- it printed only false