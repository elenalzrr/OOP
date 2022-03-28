
public class Employee extends Consumer {
    public Job job = new Job();
    public Double salariu;
    public String nume_companie;

    public Employee() {
        super();
    }


    public Double getSalariu() {
        return salariu;
    }

    public void setSalariu(Double salariu) {
        this.salariu = salariu;
    }

    public String getNume_companie() {
        return nume_companie;
    }

    public void setNume_companie(String nume_companie) {
        this.nume_companie = nume_companie;
    }

    @Override
    public String toString() {
        return "Employee:" +
                "resume:" + resume + '\n' +
                "salariu:" + salariu + '\n';

    }


}
