package puzzleseventyfour.identitycrisis;

/*
        This program is incomplete. It lacks a declaration for Enigma1, a class that extends java.lang.Object. Provide a
        declaration for Enigma1 that makes the program print false:

        public class Conundrum
        {
                public static void main(String[] args)
                {
                        Enigma1 e = new Enigma1();
                        System.out.println(e.equals(e));
                }
        }

        Oh, and one more thing: You must not override equals.
*/

public class Conundrum
{
        public static void main(String[] args)
        {
                Enigma e = new Enigma();
                System.out.println(e.equals(e));
        }
}

class Enigma
{
        public boolean equals(Enigma enigma)
        {
                return false;
        }
}

// First guess: if Enigma is declared as a simple public class without a body, e.equals(e) would be true.
// We can't override equals, otherwise we could just have the overriding equals always return false.
// But I guess that's too easy. Working backwards, we know that Enigma1 must have a no-args constructor that has a
// minimum visibility of package local.
// Well, how about implementing a method called equals? We wouldn't be overriding Object's equals if it's parameter
// was of type Enigma and not Object

