package Function;

public class GradeCal {
    private static double total;
    public static String gradeCal(double midtermScore,double workScore,double projectScore,double finalScore){
        double total = midtermScore+workScore+projectScore+finalScore;
        if(total<50){
            return "F";
        }
        else if(total<55){
            return "D";
        }
        else if(total<60){
            return "D+";
        }
        else if(total<65){
            return "C";
        }
        else if(total<70){
            return "C+";
        }
        else if(total<75){
            return "B";
        }
        else if(total<80){
            return "B+";
        }
        else{
            return "A";
        }
    }
    public static double getTotal(double midtermScore,double workScore,double projectScore,double finalScore) {
        double total = midtermScore+workScore+projectScore+finalScore;
        return total;
    }
}

