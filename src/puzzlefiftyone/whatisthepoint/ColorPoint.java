package puzzlefiftyone.whatisthepoint;

//      This program has two immutable value classes, which are classes whose instances represent values.
//      One class represents a point on the plane with integer coordinates, and the second class adds a bit of
//      color to the puzzle. The main program creates and prints an instance of the second class.
//      What does the program print?

public class ColorPoint extends Point
{
        private final String color;

        public ColorPoint(int x, int y, String color)
        {
                super(x, y);
                this.color = color;
        }

        protected String makeName()
        {
                return super.makeName() + ":" + color;
        }

        public static void main(String[] args)
        {
                System.out.println(new ColorPoint(4, 2, "purple"));
        }
}
