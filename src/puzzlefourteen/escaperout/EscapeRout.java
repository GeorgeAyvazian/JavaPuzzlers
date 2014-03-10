package puzzlefourteen.escaperout;

/*
        The following program uses two Unicode escapes, which represent Unicode characters by their hexadecimal numeric codes.
        What does the program print?

        public class EscapeRout {
                public static void main(String[] args) {
                        // \u0022 is the Unicode escape for double quote (")
                        System.out.println("a\u0022.length() + \u0022b".length());
                }
        }
*/


public class EscapeRout
{
        public static void main(String[] args)
        {
                String x =\u0022I 'm wrapped by unicode\u0022;
                System.out.println(x + "<---initialized with unicode");
                // \u0022 is the Unicode escape for double quote (")
                System.out.println("a\u0022.length() + \u0022b".length());
        }
}

// First guess: unicode is replaced before compilation, so the expression passed to println would be transformed to:
// "a".length()+"b".length()
// which would print 2
// if the unicode was replaced after compilation, then the result would be 16.
// But it doesn't make sense to have unicode replaced after compilation, as this is when the source is tokenized and parsed -
// After compilation, you have binary
// The above is misleading. Program text is compiled in this order: 1) lexer, 2) parser, 3) compiler
// unicode translation takes place after 1
// escape sequence translation takes place after 2). It need not happen after 1) as it is the case with unicode
