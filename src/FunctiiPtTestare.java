import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import static java.lang.String.*;


public class FunctiiPtTestare {
    public ArrayList<User> user;
    public ArrayList<User> managerlist;
    public ArrayList<User> recruiterlist;
    public ArrayList<Employee> employeelist;
    public ArrayList<Company> joburii;
    public ArrayList<String> joburi;
    public ArrayList<String> departamente;
    public ArrayList<Double> salariu;
    public ArrayList<String> prieteni;

    public FunctiiPtTestare() {
        user = new ArrayList<>();
        managerlist = new ArrayList<>();
        recruiterlist = new ArrayList<>();
        employeelist = new ArrayList<>();
        joburii = new ArrayList<>();
        joburi = new ArrayList<>();
        departamente = new ArrayList<>();
        salariu = new ArrayList<>();
        prieteni = new ArrayList<>();
    }

    public Job availableJobs(JSONObject obj) {
        Job jobs = new Job();
        //extragem numele
        jobs.nume_job = (String) obj.get("name");
        //extragem pozitia
        jobs.noPositions = Integer.parseInt((String) obj.get("noPositions"));
        //extragem salariul
        jobs.salariu = Double.parseDouble((String) obj.get("salary"));
        //facem un string pentru a extrage graduationYearConstraint
        String[] graduationYearConstraint;
        graduationYearConstraint = ((String) obj.get("graduationYearConstraint")).split("-");
        Double min = null, max = null;
        if (graduationYearConstraint[0].compareTo("null") != 0)
            min = Double.parseDouble(graduationYearConstraint[0]);
        if (graduationYearConstraint[1].compareTo("null") != 0)
            max = Double.parseDouble(graduationYearConstraint[1]);
        jobs.educatie_absolvire = new Constraint(min, max);

        //un nou string pentru experience
        String[] experience;
        //reinitializam min,max cu null
        min = null;
        max = null;

        experience = ((String) obj.get("experience")).split("-");
        if (experience[0].compareTo("null") != 0)
            min = Double.parseDouble(experience[0]);
        if (experience[1].compareTo("null") != 0)
            max = Double.parseDouble(experience[1]);
        jobs.experienta_ani = new Constraint(min, max);

        //un nou string pentru average
        String[] average;
        min = null;
        max = null;
        average = ((String) obj.get("average")).split("-");
        if (average[0].compareTo("null") != 0)
            min = Double.parseDouble(average[0]);
        if (average[1].compareTo("null") != 0)
            max = Double.parseDouble(average[1]);
        jobs.medie = new Constraint(min, max);

        return jobs;
    }


    public void CitireJoburi() throws Exception {
        JSONParser parser = new JSONParser();
        Object read = parser.parse(new FileReader("lista_joburi_disponibile.json"));
        JSONObject obj = (JSONObject) read;
        JSONArray companies = (JSONArray) obj.get("companies");
        JSONArray departments;
        Iterator iterator = companies.iterator();
        DepartmentFactory factory = new DepartmentFactory();
        Company company;
        Department department;
        while (iterator.hasNext()) {
            obj = (JSONObject) iterator.next();
            company = new Company((String) obj.get("name"));
            departments = (JSONArray) obj.get("IT");
            department = factory.getDepartmentFactory("IT");
            if (departments != null) {
                department.tip = "IT ";
            }
            ptDepartamente(departments, company, department);

            departments = (JSONArray) obj.get("Management");
            department = factory.getDepartmentFactory("Management");
            if (departments != null) {
                department.tip = "Management ";
            }
            ptDepartamente(departments, company, department);

            departments = (JSONArray) obj.get("Marketing");
            department = factory.getDepartmentFactory("Marketing");
            if (departments != null) {
                department.tip = "Marketing ";
            }
            ptDepartamente(departments, company, department);
            departments = (JSONArray) obj.get("Finance");
            department = factory.getDepartmentFactory("Finance");
            if (departments != null) {
                department.tip = "Finance ";
            }
            ptDepartamente(departments, company, department);
            joburii.add(company);
        }
    }

    private void ptDepartamente(JSONArray departments, Company company, Department department) {
        Job job;
        JSONObject it;
        if (departments.size() > 0)
            for (Object newobj : departments) {
                it = (JSONObject) newobj;
                job = availableJobs(it);
                job.nume_companie = company.nume;
                department.add(job);
            }
        company.add(department);
    }

    public TreeSet<Education> educationData(JSONArray education) throws InvalidDatesException {
        TreeSet<Education> ed = new TreeSet<>();
        String name, level;
        LocalDate start;
        LocalDate end;
        Double grade;

        for (Object obj : education) {
            JSONObject object = (JSONObject) obj;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            name = (String) object.get("name");
            level = (String) object.get("level");
            grade = Double.valueOf(valueOf(object.get("grade")));
            String startw = (String) object.get("start_date");
            start = (LocalDate.parse(startw, formatter));
            String endw = (String) object.get("end_date");
            if (endw != null) {
                Education edd;
                end = (LocalDate.parse(endw, formatter));
                edd = new Education(name, level, start, end, grade);
                ed.add(edd);
            }
            if (endw == null) {
                Education edd;
                edd = new Education(name, level, start, null, grade);
                ed.add(edd);
            }
        }
        return ed;
    }

    public TreeSet<Experience> experienceData(JSONArray array) throws InvalidDatesException {
        TreeSet<Experience> experienta = new TreeSet<>();
        for (Object obj : array) {
            String nume, pozitie;
            LocalDate start, end;
            JSONObject object = (JSONObject) obj;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            nume = (String) object.get("company");
            pozitie = (String) object.get("position");
            String startw = (String) object.get("start_date");
            start = (LocalDate.parse(startw, formatter));
            String endw = (String) object.get("end_date");
            if (endw != null) {
                Experience exp;
                end = (LocalDate.parse(endw, formatter));
                exp = new Experience(start, end, pozitie, nume);
                experienta.add(exp);
            }
            if (endw == null) {
                Experience exp;
                exp = new Experience(start, null, pozitie, nume);
                experienta.add(exp);
            }
        }
        return experienta;
    }

    public TreeSet<Experience> experienceDataE(JSONArray array) throws InvalidDatesException {

        TreeSet<Experience> experienta = new TreeSet<>();
        for (Object obj : array) {
            String nume, pozitie;
            LocalDate start, end;
            JSONObject object = (JSONObject) obj;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            nume = (String) object.get("company");
            pozitie = (String) object.get("position");
            String startw = (String) object.get("start_date");
            start = (LocalDate.parse(startw, formatter));
            String cp = nume + " " + pozitie + '\n';
            joburi.add(cp);

            String endw = (String) ((JSONObject) obj).get("end_date");
            if (endw != null) {
                Experience exp;
                end = (LocalDate.parse(endw, formatter));
                exp = new Experience(start, end, pozitie, nume);
                experienta.add(exp);
            }
            if (endw == null) {
                Experience exp;
                exp = new Experience(start, null, pozitie, nume);
                experienta.add(exp);

                String dep = (String) ((JSONObject) obj).get("department");
                departamente.add(dep);
            }

        }

        return experienta;
    }

    public User extragereDate(JSONObject obj) throws InvalidDatesException, ResumeIncompleteException {
        //extrag limbile

        JSONArray limba = (JSONArray) obj.get("languages");
        //extrag nivelul limbilor
        JSONArray level = (JSONArray) obj.get("languages_level");
        //extrag educatia
        JSONArray educatie = (JSONArray) (obj).get("education");
        //extrag experienta
        JSONArray experienta = (JSONArray) obj.get("experience");
        ArrayList<Language> limbi = new ArrayList<>();
        for (int i = 0; i < limba.size(); i++)
            limbi.add(new Language((String) limba.get(i), (String) level.get(i)));
        String nume;
        String[] prenume;
        nume = (String) obj.get("name");
        prenume = nume.split(" ");
        User user = new User();
        user.resume = new Consumer.Resume.ResumeBuilder()
                .Education(educationData(educatie))
                .Experience(experienceData(experienta))
                .name(prenume[0])
                .firstName(prenume[1])
                .birthDate((String) obj.get("date_of_birth"))
                .email((String) obj.get("email"))
                .gender((String) obj.get("genre"))
                .phoneNumber((String) obj.get("phone"))
                .language(limbi)
                .build();
        return user;
    }

    public Employee extragereDatex(JSONObject obj) throws InvalidDatesException, ResumeIncompleteException {
        //extrag limbile
        JSONArray limba = (JSONArray) obj.get("languages");
        //extrag nivelul limbilor
        JSONArray level = (JSONArray) obj.get("languages_level");
        //extrag educatia
        JSONArray educatie = (JSONArray) (obj).get("education");
        //extrag experienta
        JSONArray experienta = (JSONArray) obj.get("experience");
        ArrayList<Language> limbi = new ArrayList<>();
        for (int i = 0; i < limba.size(); i++)
            limbi.add(new Language((String) limba.get(i), (String) level.get(i)));
        String nume;
        String[] prenume;
        nume = (String) obj.get("name");
        prenume = nume.split(" ");
        Employee user = new Employee();
        user.resume = new Consumer.Resume.ResumeBuilder()
                .Education(educationData(educatie))
                .Experience(experienceDataE(experienta))
                .name(prenume[0])
                .firstName(prenume[1])
                .birthDate((String) obj.get("date_of_birth"))
                .email((String) obj.get("email"))
                .gender((String) obj.get("genre"))
                .phoneNumber((String) obj.get("phone"))
                .language(limbi)
                .build();

        user.salariu = Double.valueOf(valueOf(obj.get(("salary"))));
        salariu.add(user.salariu);
        return user;
    }


    public void citireConsumers() throws Exception, ResumeIncompleteException {
        //citim din fisier
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("consumers.json"));
        JSONObject obj = (JSONObject) object;
        JSONArray employees = (JSONArray) obj.get("employees");
        JSONArray recruiters = (JSONArray) obj.get("recruiters");
        JSONArray managers = (JSONArray) obj.get("managers");
        JSONArray usera = (JSONArray) obj.get("users");
        JSONArray intresatiJob;
        User users;
        Employee employee;
        User manager;
        User recruiter;
        for (Object obj2 : employees) {
            JSONObject objj = (JSONObject) obj2;
            employee = extragereDatex(objj);
            employeelist.add(employee);
        }

        for (Object obj2 : recruiters) {
            JSONObject objj = (JSONObject) obj2;
            recruiter = extragereDate(objj);
            recruiterlist.add(recruiter);
        }
        for (Object obj2 : managers) {
            JSONObject objj = (JSONObject) obj2;
            manager = extragereDate(objj);
            managerlist.add(manager);
        }

        for (Object obj2 : usera) {
            JSONObject objj = (JSONObject) obj2;
            users = extragereDate(objj);
            intresatiJob = (JSONArray) (objj).get("interested_companies");
            for (Object o : intresatiJob)
                users.job.add((String) o);
            user.add(users);
        }
    }

    public void citirePrieteni() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("friendship.json"));
        JSONObject obj = (JSONObject) object;
        JSONArray fr = (JSONArray) obj.get("friendship");
        for (Object obj2 : fr) {
            JSONObject objj = (JSONObject) obj2;
            String name = (String) ((JSONObject) obj2).get("name");
            JSONArray frs = (JSONArray) objj.get("friends");
            prieteni.add(name);
            prieteni.add(frs.toString());
        }
    }

}


