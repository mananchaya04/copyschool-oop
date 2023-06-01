package Admin;

import java.util.Vector;

public class StoreTimetable {
    private static Vector<Timetable> timetableMath;
    private static Vector<Timetable> timetableSCI;
    private static Vector<Timetable> timetableENG;

    public StoreTimetable(){
        timetableMath = new Vector<>();
        getMateTable();
        timetableENG = new Vector<>();
        getEngTable();
        timetableSCI = new Vector<>();
        getSciTable();
    }

    // Get Vector Anny Iimetable
    public static Vector<Timetable> getTimeMath(){
        return timetableMath;
    }
    public static Vector<Timetable> getTimeSci(){
        return timetableSCI;
    }
    public static Vector<Timetable> getTimeEng(){
        return timetableENG;
    }

    public void getMateTable(){
        timetableMath.add(new Timetable("Monday", "Math", "Math", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableMath.add(new Timetable("Tuesday", "Math", "Math", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableMath.add(new Timetable("Wednesday", "Math", "Math", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableMath.add(new Timetable("Thursday", "Math", "Math", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableMath.add(new Timetable("Friday", "Math", "Math", "Math", "Lunch", "English", "History", "English", "Math"));
    }

    public void getEngTable(){
        timetableENG.add(new Timetable("Monday", "English", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableENG.add(new Timetable("Tuesday", "English", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableENG.add(new Timetable("Wednesday", "English", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableENG.add(new Timetable("Thursday", "English", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableENG.add(new Timetable("Friday", "English", "English", "Math", "Lunch", "English", "History", "English", "Math"));
    }

    public void getSciTable(){
        timetableSCI.add(new Timetable("Monday", "Science", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableSCI.add(new Timetable("Tuesday", "Science", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableSCI.add(new Timetable("Wednesday", "Science", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableSCI.add(new Timetable("Thursday", "Science", "English", "Math", "Lunch", "English", "History", "English", "Math"));
        timetableSCI.add(new Timetable("Friday", "Science", "English", "Math", "Lunch", "English", "History", "English", "Math"));
    }


}
