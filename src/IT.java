
import java.util.stream.Collectors;

public class IT extends Department {

    public IT() {
        super();
    }

    public double getTotalSalaryBudget() {
        return this.getEmployees().stream().collect(Collectors.summingDouble(Employee::getSalariu));
    }
}