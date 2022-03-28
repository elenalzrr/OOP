import java.util.*;

public abstract class Department {
    public ArrayList<Employee> angajati;
    public ArrayList<Job> jobs;
    public String tip;

    public Department() {
        angajati = new ArrayList<>();
        jobs = new ArrayList<>();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public ArrayList<Job> getJobs() {
        return jobs;

    }

    public abstract double getTotalSalaryBudget();

    public void add(Employee employee) {
        angajati.add(employee);
    }

    public void remove(Employee employee) {
        angajati.remove(employee);
    }

    public void add(Job job) {
        jobs.add(job);
    }

    public ArrayList<Employee> getEmployees() {
        return angajati;
    }

    @Override
    public String toString() {
        return "Departament:" + tip + "job:" + jobs + '\n';
    }
}

