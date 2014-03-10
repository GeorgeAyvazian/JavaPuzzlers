package puzzlefiftyone.whatisthepoint;

//      This program has two immutable value classes, which are classes whose instances represent values.
//      One class represents a point on the plane with integer coordinates, and the second class adds a bit of
//      color to the puzzle. The main program creates and prints an instance of the second class.
//      What does the program print?

//      My prediction: when a new ColorPoint is instantiated, the call to the super will invoke superclass'
//      makeName and print:
//              '[<x>,<y>]'
//      It will not print the color passed to the ColorPoint constructor
//      But wait, we're passing an instance of ColorPoint to the print method, this will invoke ColorPoint's
//      toString, which is inherited from its direct superclass Point. And the toString method in Point returns
//      'name', a private field not inherited by ColorPoint.
//      On second thought, as is this case with a field in a class that hides its namesake declared in a superclass,
//      its possible that 'name' here is still implemented by ColorPoint instances, even thought ColorPoint does not
//      inherit the field 'name' due to visibility.
//      If this is the case, then the output should be:
//              [4,2]:purple,
//      instead of just:
//              [4,2]

//      The results:
//      So I was close. The output is:
//              [4,2]:null
//      Yes, ColorPoint does in fact implement 'name' although it doesn't inherit it
//      Yes, the toString invoked by ColorPoint is the method implemented by its superclass Point
//      The reason why 'null' is printed instead of 'purple', is the following:
//              when a ColorPoint is instantiated it calls its superclass' constructor, as is required for compilation
//              the superclass invokes ColorPoint's makeName method, which uses ColorPoint's 'color' field.
//              At this moment in the initialization process, 'color' is not yet assigned; hence the output 'null'
//              Only after the call to super(...)
//              (which makes the subsequent call to makeName, which initializes 'name', which is the field returned by
//               the toString)
//              is 'color' initialized.

//      Solutions to the problem of not being able to print the color field:
//      For the entire lifetime of any ColorPoint objects, name will always get assigned whatever makeName in
//      ColorPoint returns (assuming no code is changed with makeName). The problem is that name is implemented but
//      not inherited by ColorPoint, so the ColorPoint class can never set the value of name itself.
//      So 'name' can never be reassigned from any subclass of Point, but subclasses can override the toString method
//      inorder to print whatever is desired.

//      *************
//      A true solution is lazy initialization (shown below)
//      *************

//      *************
//      Also not that 'color' is final, and yet it's still possible to observe a value for it BEFORE it is initialized
//      *************

//      Moral of the story: NEVER DIRECTLY OR INDIRECTLY CALL OVERRIDABLE METHODS FROM CONSTRUCTORS

public class Point
{
        private final int x, y;

        private String name; // Cached at construction time

        public Point(int x, int y)
        {
                this.x = x;
                this.y = y;
                name = makeName();
        }

        protected String makeName()
        {
                return "[" + x + "," + y + "]";
        }

        @Override
        public String toString()
        {
                return name;
        }

//        Using lazy initialization to solve the problem:

//        private String name;
//        @Override
//        public final synchronized String toString()
//        {
//                if (name == null)
//                {
//                        name = makeName();
//                }
//                return name;
//        }
}