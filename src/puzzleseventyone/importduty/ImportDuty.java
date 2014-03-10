package puzzleseventyone.importduty;

public class ImportDuty
{
        private int ImportDuty;
        public static void main(String[] args)
        {
                ImportDuty ImportDuty = new ImportDuty();
                ImportDuty.printArgs(null);
                printArgs(1, 2, 3, 4, 5);
                System.out.println(ImportDuty.ImportDuty);
        }

        private static void printArgs(Object ... args)
        {
                System.out.println(/*toString(args)*/);
        }

}
