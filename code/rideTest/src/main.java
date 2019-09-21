import RideAttributes.*;

public class main {

    private static int testAttributes(){
        return 0;
    }

    public static void main(String[] args) {
        int testA = testAttributes();

        if (testA == 0){
            System.out.println("Everything Works!");
        }else{
            System.out.println(String.format("Test: %d, Failed", testA));
        }
    }
}
