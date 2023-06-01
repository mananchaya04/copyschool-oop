package Admin;

public class Timetable {
    private String day;
    private String time1;//8-9
    private String time2;//9-10
    private String time3;//10-11
    private String time4;//11-12
    private String time5;//12-13
    private String time6;//13-14
    private String time7;//14-15
    private String time8;//15-16

    public Timetable(String day,String time1,String time2,String time3,String time4,String time5,String time6,String time7,String time8){
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.time4 = time4;
        this.time5 = time5;
        this.time6 = time6;
        this.time7 = time7;
        this.time8 = time8;
        this.day = day;
    }


    public String getDay() {
        return day;
    }
    public String getTime1() {
        return time1;
    }
    public String getTime2() {
        return time2;
    }
    public String getTime3() {
        return time3;
    }
    public String getTime4() {
        return time4;
    }
    public String getTime5() {
        return time5;
    }
    public String getTime6() {
        return time6;
    }
    public String getTime7() {
        return time7;
    }
    public String getTime8() {
        return time8;
    }
}

