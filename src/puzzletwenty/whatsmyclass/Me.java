package puzzletwenty.whatsmyclass;

/*
        This program was designed to print the name of its class file. In case you aren't familiar with class literals,
        Me.class.getName() returns the fully qualified name of the class Me, or "com.javapuzzlers.Me". What does the
        program print?

        package com.javapuzzlers;

        public class Me
        {

                public static void main(String[] args)
                {
                        System.out.println(
                                Me.class.getName().replaceAll(".", "/") + ".class");
                }
        }
*/

public class Me
{
        public static void main(String[] args)
        {
                System.out.println(
                        Me.class.getName().replaceAll("\\.", "/") + ".class");
        }

}

// First guess: I'm going to say, since this is a simple puzzle, that the only place in the code where something
// can go wrong is the call to replaceAll.
// the first actual arg -- "." , is probably supposed to be a regex, and so rightfully matches everything,
// and replaces every character returned by getName with a '/'
// First guess was right, to make it work as expected either use escape sequence or unicode (no, don't use unicode, that will only replace
// the unicode with the actual character '.', and you have the same problem again.
