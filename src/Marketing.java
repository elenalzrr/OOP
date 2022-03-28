import java.util.stream.Collectors;

public class Marketing extends Department {

    public Marketing() {
        super();
    }

    @Override
    public double getTotalSalaryBudget() {
        double salariu = this.getEmployees().stream().mapToDouble(Employee::getSalariu).sum();
        if (salariu > 5000)
            return salariu - salariu * 0.10;
        if (salariu < 3000)
            return salariu - salariu * 0.16;
        else
            return salariu;
    }

}
