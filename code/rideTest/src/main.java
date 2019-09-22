import RideAttributes.*;

public class main {

    private static int testAttributes(){

        Ride r = new Ride("id");

        Title t = new Title("Ride with Russel");
        if(!t.isValidInput()){
            return 1;
        }else{
            r.setTitle(t);
        }

        Date d = new Date("2004-06-16");
        if(!d.isValidInput()){
            return 2;
        }else{
            r.setDate(d);
        }

        Time time = new Time("4:14");
        if(!time.isValidInput()){
            return 3;
        }else{
            r.setTime(time);
        }

        Distance dist = new Distance("500");
        if(!dist.isValidInput()){
            return 4;
        }else{
            r.setDistance(dist);
        }

        Comment c = new Comment("We had fun");
        if(!c.isValidInput()){
            return 5;
        }else{
            r.setComment(c);
        }

        AverageSpeed as = new AverageSpeed("10");
        if(!as.isValidInput()){
            return 6;
        }else{
            r.setAverageSpeed(as);
        }

        AverageCadence ac = new AverageCadence("5");
        if(!ac.isValidInput()){
            return 6;
        }else{
            r.setAverageCadence(ac);
        }


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
