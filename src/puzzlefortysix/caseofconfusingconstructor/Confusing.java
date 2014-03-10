package puzzlefortysix.caseofconfusingconstructor;

public class Confusing
{
        private Confusing(Object o, int[] o2)
        {
                System.out.println("Object");
        }

        private Confusing(Object o, double[] dArray)
        {
                System.out.println("double array");
        }

        static void confusing(Object o, double[] dArray)
        {
                System.out.println('d');
        }

        void confusing(Object o, Object o2)
        {
                System.out.println('i');

        }

        public static void main(String[] args)
        {
//                new Confusing(null, null);
                confusing(null, null);
        }
}
