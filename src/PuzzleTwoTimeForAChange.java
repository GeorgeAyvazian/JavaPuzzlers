public class PuzzleTwoTimeForAChange
{

        private static final int MULTIPLER = 10;

        public static void main(String[] args)
        {
                final double x = 2.0d - 1.1d;
                final int places = 2;

                System.out.println(Math.round(x * StrictMath.pow(MULTIPLER, places)) / StrictMath.pow(MULTIPLER, places));
                System.out.println(Long.MAX_VALUE);
                System.out.println(Long.MIN_VALUE);

                final StringBuffer stringBuffer = new StringBuffer("10");
                long value = 1L;
                for (int i = 0; i < 63; i++)
                {
                        value *= 2;
                }
                System.out.println(value);
                System.out.println(value + 1);
//                while (value < Long.MAX_VALUE)
//                {
//                        stringBuffer.append("0");
//                        value = value * 2;
//                }
//                System.out.println(stringBuffer.toString() + " = " + value);
        }
}
