

import java.util.stream.Collectors;

public class Finance extends Department {

    public Finance() {
        super();
    }

    @Override
    public double getTotalSalaryBudget() {
        double salariu = this.getEmployees().stream().mapToDouble(Employee::getSalariu).sum();
        Double ani = this.getEmployees().stream().mapToDouble(Consumer::aniMunciti).sum();
        if (ani < 1)
            return salariu - salariu * 0.10;
        else if (ani > 1)
            return salariu - salariu * 0.16;
        return 0.0;
    }

}
