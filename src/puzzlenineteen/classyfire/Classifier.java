package puzzlenineteen.classyfire;

//        The following program uses a method to classify characters. What does the program print? In case you are not familiar with
//        the String.indexOf(char) method, it returns the index of the first occurrence of the specified character in the string, or –1
//        if the string doesn't contain the character:
//
//        public class Classifier
//        {
//                public static void main(String[] args)
//                {
//                        System.out.println(
//                                classify('n') + classify('+') + classify('2'));
//                }
//
//                static String classify(char ch)
//                {
//                        if ("0123456789".indexOf(ch) >= 0)
//                                return "NUMERAL ";
//                        if ("abcdefghijklmnopqrstuvwxyz".indexOf(ch) >= 0)
//                                return "LETTER ";
//                /* (Operators not supported yet)
//                if ("+-*/&|!=".indexOf(ch) >= 0)
//                                return "OPERATOR ";
//                */
//                                return "UNKNOWN ";
//                        }
//                }

public class Classifier {
        public static void main(String[] args) {
                System.out.println(
                        classify('n') + classify('+') + classify('2'));
        }
        static String classify(char ch) {
                if ("0123456789".indexOf(ch) >= 0)
                        return "NUMERAL ";
                if ("abcdefghijklmnopqrstuvwxyz".indexOf(ch) >= 0)
                        return "LETTER ";
/* (Operators not supported yet)
if ("+-*/&|!=".indexOf(ch) >= 0)
                return "OPERATOR ";
                */
                return "UNKNOWN ";
        }
}

// First guess: it wont compile. The string in the last if-guard has '*/' in it, which will pair with the '/*' one
// line above it, leaving a lone '*/' two lines below the if-guard => compilation error

// Lesson(s): String literals are not treated specially within comments
// block comments do not nest

// you can use if(false) to conditionally compile the following code block. JLS says this is ok, but using while(false)
// will lead to a compilation error, the code in the while block is unreachable.

// Use single-line comments whenever possible