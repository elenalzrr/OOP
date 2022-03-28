public class Constraint {
    public Double inferior, superior;

    public Constraint(Double inferior, Double superior) {
        this.inferior = inferior;
        this.superior = superior;
    }

    public double getInferior() {
        return inferior;
    }

    public void setInferior(Double inferior) {
        this.inferior = inferior;
    }

    public double getSuperior() {
        return superior;
    }

    public void setSuperior(Double superior) {
        this.superior = superior;
    }

    @Override
    public String toString() {
        return "Constraint:" + '\n' +
                "inferior:" + inferior + '\n' +
                "superior:" + superior + '\n';
    }
}
