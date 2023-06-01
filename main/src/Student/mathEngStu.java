package Student;

public class mathEngStu extends Student{
    private double[] advMathSub;
    private double[] sciSub;
    public mathEngStu(String name, String surname, String id, String birth, double[] engSub, double[] mathSub,
                      double[] thaiSub, double[] advMathSub ,double[] sciSub) {
        super(name, surname, id, birth, engSub, mathSub, thaiSub);
        this.advMathSub = advMathSub;
        this.sciSub = sciSub;
    }
    public double[] getAdvMathSub() {
        return advMathSub;
    }

    public void setAdvMathSub(double[] advMathSub) {
        this.advMathSub = advMathSub;
    }

    public double[] getSciSub() {
        return sciSub;
    }

    public void setSciSub(double[] sciSub) {
        this.sciSub = sciSub;
    }
}
