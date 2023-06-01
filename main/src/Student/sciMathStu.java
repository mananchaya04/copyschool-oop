package Student;

public class sciMathStu extends Student {
    private double[] phySub;
    private double[] chemSub;
    private double[] bioSub;
    private double[] advMathSub;

    public sciMathStu(String name, String surname, String id, String birth, double[] engSub, double[] mathSub,
                      double[] thaiSub, double[] phySub, double[] chemSub, double[] bioSub, double[] advMathSub) {
        super(name, surname, id, birth, engSub, mathSub, thaiSub);
        this.phySub = phySub;
        this.chemSub = chemSub;
        this.bioSub = bioSub;
        this.advMathSub = advMathSub;
    }

    public double[] getPhySub() {
        return phySub;
    }

    public void setPhySub(double[] phySub) {
        this.phySub = phySub;
    }

    public double[] getChemSub() {
        return chemSub;
    }

    public void setChemSub(double[] chemSub) {
        this.chemSub = chemSub;
    }

    public double[] getBioSub() {
        return bioSub;
    }

    public void setBioSub(double[] bioSub) {
        this.bioSub = bioSub;
    }

    public double[] getAdvMathSub() {
        return advMathSub;
    }

    public void setAdvMathSub(double[] advMathSub) {
        this.advMathSub = advMathSub;
    }
}
