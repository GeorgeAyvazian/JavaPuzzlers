package puzzlesixtyeight.shadesofgray;

/*
        This program has two declarations of the same name in the same scope and no obvious way to choose between them. Does
        the program print Black? Does it print White? Is it even legal?

        public class ShadesOfGray
        {
                public static void main(String[] args)
                {
                        System.out.println(X.Y.Z);
                }
        }

        class X
        {
                static class Y
                {
                        static String Z = "Black";
                }
                static C Y = new C();
        }

        class C
        {
                String Z = "White";
        }
*/

public class ShadesOfGray
{
        public static void main(String[] args)
        {
                System.out.println(new X.Y().Z);
        }
}
class X
{
        static class Y
        {
                static String Z = "Black";
        }

        static C Y = new C();
}
class C
{
        String Z = "White";
}



// First guess: Y is static, so no need for instance of enclosing class, therefore X.Y is valid
// Z is package local, so as long as all three top-level classes are in the same package, X.Y.Z is valid
// Y is of type C. In C, there is an instance variable named Z.
// X.Y.Z should print "white".
// However, on further consideration, the static variable in X shares its name with the static nested class in X.
// Not sure what the rules are for static name collisions.
// Actually, after checking the 7 spec, the static variable Y in X doesn't hide the class declaration (???)
// nor obscure it, nor shadow it (????). Well, does it? Does it hide, obscure, or shadow the class declaration of Y
// Hiding is only valid (by class methods) (Sec. 8.4.8.2 of jls7) for inherited elements, so no hiding here
// Obscuring: choose variable over type over package
// I don't see any reason for misinterpretation. (Sec. 6.4.2 of jls7)
// Should print "White" - choosing variable Y over type Y