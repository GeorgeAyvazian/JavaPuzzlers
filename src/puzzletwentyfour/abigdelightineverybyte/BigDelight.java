package puzzletwentyfour.abigdelightineverybyte;

/*
        This program loops through the byte values, looking for a certain value. What does the program print?
        public class BigDelight
        {
                public static void main(String[] args)
                {
                        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++)
                        {
                                if (b == 0x90)
                                        System.out.print("Joy!");
                        }
                }
        }
*/

public class BigDelight
{
        public static void main(String[] args)
        {
                int i = 0;
                for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++)
                {
                        i++;
                        if (b == (byte) 0x90)
                                System.out.print("Joy!" + i);
                }
        }
}

// First guess: A few things happening here: incrementing a byte - so we have an implicit cast to int
// which shouldn't be a problem as it is a widening promotion
// 0x90 = 0b10010000 = -112 (nothing peculiar here) (if it were interpreted as a byte) ... but it probably isn't
// 0x90 = 0b10010000 = 144 if interpreted as an int *****
// we start at Byte.Min_Value- a byte is a byte long and signed so minvalue would be 0x10 = -128
// and Max value would be 0x7f = 127
// the comparison " b == 0x90 " compares byte to int, again an implicit cast from byte to int
// based on the ***** comment, b will never be equal to 0x90 and will never print