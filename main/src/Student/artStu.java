package Student;

public class artStu extends Student {
    private double[] sciSub;

    public artStu(String name, String surname, String id, String birth, double[] engSub, double[] mathSub, double[] thaiSub, double[] sciSub) {
        super(name, surname, id, birth, engSub, mathSub, thaiSub);
        this.sciSub = sciSub;
    }

    public double[] getSciSub() {
        return sciSub;
    }

    public void setSciSub(double[] sciSub) {
        this.sciSub = sciSub;
    }


}

