public class main {
    public static void main(String[] args) {
        Date testDate = new Date("");
        testDate.verifyInput();
        System.out.println(testDate.isValidInput());
        testDate.modifyInput("2020-2-29");
        System.out.println(testDate.isValidInput());

    }
}
