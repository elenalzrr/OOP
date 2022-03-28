import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Manager extends Employee {

    List<Request> req;

    public Manager() {
        super();
        req = new ArrayList<>();
    }

    public void process(Job job) {
        ArrayList<Request<Job, User>> jobreq = new ArrayList<>();
        Employee employee;
        Company company = Application.getCompany(nume_companie);
        for (Request request : req) {
            if (request.getKey().equals(job)) {
                jobreq.add(request);
            }
        }
        Collections.sort(jobreq, new Comparator<Request<Job, User>>() {
            @Override
            public int compare(Request<Job, User> o1, Request<Job, User> o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });
        for (Request rq : jobreq) {
            if (job.noPositions > 0 && job.valabil == true) {
                if (Application.getInstance().user.contains(rq.getValue1())) {
                    employee = ((User) rq.getValue1()).convert();
                    employee.setSalariu(job.getSalariu());
                    employee.setNume_companie(this.getNume_companie());
                    company.add(employee, (Department) company.getDepartments("IT"));
                    job.noPositions = job.noPositions - 1;
                    job.userlist.remove(rq.getValue1());
                    company.getAngajatNou().add("A fost adaugat in departamentul IT utilizatorul:" + employee.resume.information.getNume()
                            + employee.resume.information.getPrenume() + "ocupand postul:" + job.getNume_job()
                            + " la compania: " + company);
                    ((User) rq.getValue1()).update(nume_companie);
                }
            }
        }
        job.setValabil(false);
        if (company != null) {
            company.notifyObserver("Jobul" + job.getNume_job() + " nu mai este disponibil");
        }
    }

    @Override
    public String toString() {
        return "Manager:" + '\n' +
                "req=" + req + '\n';
    }
}