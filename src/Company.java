import java.util.*;


public class Company implements Subject {
    public String nume;
    public Manager managers;
    public List<Recruiter> recruiters;
    public List<Department> departments;
    public ArrayList<Observer> observer;
    public ArrayList<String> angajatNou;

    public Company(String nume) {
        this.nume = nume;
        managers = new Manager();
        recruiters = new ArrayList<>();
        departments = new ArrayList<>();
        observer = new ArrayList<>();
        angajatNou = new ArrayList<>();
    }

    public ArrayList<String> getAngajatNou() {
        return angajatNou;
    }

    public void setAngajatNou(ArrayList<String> angajatNou) {
        this.angajatNou = angajatNou;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Manager getManagers() {
        return managers;
    }

    public void setManagers(Manager managers) {
        this.managers = managers;
    }

    public List<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(List<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }

    public List<Department> getDepartments(String nume_departament) {

        for (Department department : departments)
            if (department.getClass().getName().equals(nume_departament)) {
                return (List<Department>) department;
            }
        return null;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Observer> getObserver() {
        return observer;
    }

    public void setObserver(ArrayList<Observer> observer) {
        this.observer = observer;
    }

    public void add(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
        }
    }

    public void add(Recruiter recruiter) {
        if (!recruiters.contains(recruiter)) {
            recruiters.add(recruiter);
        }
    }

    public void add(Employee employee, Department department) {
        department.add(employee);
    }

    public void remove(Employee employee) {

        if (!recruiters.contains(employee)) {
            recruiters.remove(employee);
        }
    }

    public void remove(Department department) {
        if (!departments.contains(department)) {
            departments.remove(department);
        }

    }

    public void remove(Recruiter recruiter) {
        if (!recruiters.contains(recruiter)) {
            recruiters.remove(recruiter);
        }
    }

    public void move(Department source, Department destination) {
        destination.getEmployees().addAll(source.getEmployees());
        departments.remove(source);
    }

    public void move(Employee employee, Department newDepartment) {
        newDepartment.angajati.add(employee);
    }

    public boolean contains(Department department) {
        return departments.contains(department);

    }

    public boolean contains(Employee employee) {
        if (recruiters.contains(employee))
            return true;
        else
            return false;

    }

    public boolean contains(Recruiter recruiter) {
        if (recruiters.contains(recruiter))
            return true;
        else
            return false;

    }

    public Recruiter getRecruiter(User user) {
        Recruiter recruiter = new Recruiter();
        if (!user.lista_prieteni.contains(recruiter))
            return recruiter;
        return null;

    }

    public ArrayList<Job> getJobs() {
        ArrayList<Job> jobs = new ArrayList<>();
        for (Department department : departments)
            jobs.addAll(department.getJobs());
        return jobs;
    }

    @Override
    public void addObserver(User user) {
        if (!observer.contains(user))
            observer.add(user);
    }

    @Override
    public void removeObserver(User c) {
        observer.remove(c);
    }

    @Override
    public void notifyObserver(String mesaj) {
        for (Observer observer : observer)
            observer.update(mesaj);
    }

    @Override
    public String toString() {
        return "Company:\n" +
                "numele companiei:" + nume + '\n' +
                "departmentele:" + departments + '\n' +
                "observer:" + observer + '\n';
    }
}
