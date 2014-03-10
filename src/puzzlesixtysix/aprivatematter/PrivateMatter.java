package puzzlesixtysix.aprivatematter;

/*
        In this program, a subclass field has the same name as a superclass field. What does the program print?

        class Base 
        {
                public String className = "Base";
        }

        class Derived extends Base 
        {
                private String className = "Derived";
        }

        public class PrivateMatter 
        {
                public static void main(String[] args) 
                {
                        System.out.println(new Derived().className);
                }
        }
*/

public class PrivateMatter
{
        public static void main(String[] args)
        {
                System.out.println(((Base) new Derived()).className);
        }
}
