public class Test {
    public static void main(String[] args) {
        Date defaultDate = new Date();
        Date parameterizedDate = new Date(15, 9, 2023);
        Date copiedDate = new Date(parameterizedDate);

        System.out.print("Default Date: ");
        defaultDate.printDate();
        System.out.print("\nParameterized Date: ");
        parameterizedDate.printDate();
        System.out.print("\nCopied Date: ");
        copiedDate.printDate();
    }
}