
public class Management extends Department {

    public Management() {
        super();
    }

    @Override
    public double getTotalSalaryBudget() {
        double salariu = this.getEmployees().stream().mapToDouble(Employee::getSalariu).sum();
        return salariu - salariu * 0.16;
    }

}
