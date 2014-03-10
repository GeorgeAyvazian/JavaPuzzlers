package puzzlesixtyseven.allstrungout;

/*
        One name can be used to refer to multiple classes in different packages. This program explores what happens when you
        reuse a platform class name. What do you think it does? Although this is the kind of program you'd normally be embarrassed
        to be seen with, go ahead and lock the doors, close the shades, and give it a try:

        public class StrungOut
        {
                public static void main(String[] args)
                {
                        String s = new String("Hello world");
                        System.out.println(s);
                }
        }

        class String
        {
                private final java.lang.String s;

                public String(java.lang.String s)
                {
                        this.s = s;
                }

                public java.lang.String toString()
                {
                        return s;
                }
        }
*/

public class StrungOut
{
        public static void main(String[] args)
        {
                String s = new String("Hello world");
                System.out.println(s);
        }
}

// First Guess:
// I don't see any issues with type hiding. StrungOut does not use the fully qualified name of the platform type-
// the String class does, however.
// I don't think there'd be compilation issues either

// StrungOut won't run! the main method's String[] argument is of the user-defined type String, not the platform String
// Therefore, main isn't the main that the JVM recognizes. The reason why usage of the type defaults to the user-defined
// type (I'm guessing), is that it's "closer" to this class (being in the same package) - the platform type is in
// java.lang

// java puzzlers says:
// "...If you reuse one of these [platform] names, the unqualified name will refer to the new definition any
// time it is used inside its own package."

// so of course, we can move the user-defined String class outside this package, but you'll inevitably run into
// problems. Simply don't reuse the name

// Lesson: Avoid name reuse, especially of core/library/platform names (except when overriding of course)
