import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.lang.Double;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Application {
    public ArrayList<Company> company;
    private static Application obj = null;
    public ArrayList<User> user;

    private Application() {
        company = new ArrayList<>();
        user = new ArrayList<>();

    }

    public static Application getInstance() {
        if (obj == null)
            obj = new Application();
        return obj;
    }

    public ArrayList<Company> getCompanies() {
        return Application.getInstance().company;
    }

    public static Company getCompany(String name) {
        for (Company company : Application.getInstance().company) {
            if (company.nume.equals(name))
                return company;
        }
        return null;
    }

    public void add(Company company) {
        if (!Application.getInstance().company.contains(company))
            Application.getInstance().company.add(company);
    }

    public void add(User user) {
        if (!Application.getInstance().user.contains(user))
            Application.getInstance().user.add(user);
    }

    public boolean remove(Company company) {

        if (!Application.getInstance().company.contains(company)) {
            Application.getInstance().company.remove(company);
            return true;
        } else {
            return false;
        }

    }

    public boolean remove(User user) {
        if (!Application.getInstance().user.contains(user)) {
            Application.getInstance().user.remove(user);
            return true;
        } else {
            return false;
        }
    }


    public ArrayList<Job> getJobs(List<String> companies) {
        ArrayList<Job> jobs = new ArrayList<>();
        if (companies != null) {
            for (String company : companies) {
                if (getCompany(company) != null) {
                    jobs.addAll(getCompany(company).getJobs());
                }
            }
        }
        return jobs;
    }

    public String toString() {
        return user + " " + company;
    }


}