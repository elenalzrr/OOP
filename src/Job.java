import java.util.*;

public class Job {

    public String nume_job, nume_companie, lista_candidati;
    public boolean valabil = true;
    public int nr_candidati;
    public Double salariu;
    public Constraint educatie_absolvire, experienta_ani, medie;
    public ArrayList<User> userlist;
    public int noPositions;

    public Job() {
        userlist = new ArrayList<>();
    }

    public Job(String nume_job, String nume_companie, String lista_candidati, boolean valabil, int nr_candidati,
               Double salariu, Constraint educatie_absolvire, Constraint experienta_ani, Constraint medie) {
        this.nume_job = nume_job;
        this.nume_companie = nume_companie;
        this.lista_candidati = lista_candidati;
        this.valabil = valabil;
        this.nr_candidati = nr_candidati;
        this.salariu = salariu;
        this.educatie_absolvire = educatie_absolvire;
        this.experienta_ani = experienta_ani;
        this.medie = medie;
        this.noPositions = noPositions;
    }

    public String getNume_job() {
        return nume_job;
    }

    public void setNume_job(String nume_job) {
        this.nume_job = nume_job;
    }

    public String getNume_companie() {
        return nume_companie;
    }

    public void setNume_companie(String nume_companie) {
        this.nume_companie = nume_companie;
    }

    public String getLista_candidati() {
        return lista_candidati;
    }

    public void setLista_candidati(String lista_candidati) {
        this.lista_candidati = lista_candidati;
    }

    public boolean isValabil() {
        return valabil;
    }

    public void setValabil(boolean valabil) {
        this.valabil = valabil;
    }

    public int getNr_candidati() {
        return nr_candidati;
    }

    public void setNr_candidati(int nr_candidati) {
        this.nr_candidati = nr_candidati;
    }

    public Constraint getEducatie_absolvire() {
        return educatie_absolvire;
    }

    public void setEducatie_absolvire(Constraint educatie_absolvire) {
        this.educatie_absolvire = educatie_absolvire;
    }

    public Constraint getExperienta_ani() {
        return experienta_ani;
    }

    public void setExperienta_ani(Constraint experienta_ani) {
        this.experienta_ani = experienta_ani;
    }

    public Constraint getMedie() {
        return medie;
    }

    public void setMedie(Constraint medie) {
        this.medie = medie;
    }

    public ArrayList<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(ArrayList<User> userlist) {
        this.userlist = userlist;
    }

    public int getNoPositions() {
        return noPositions;
    }

    public void setNoPositions(int noPositions) {
        this.noPositions = noPositions;
    }

    public Double getSalariu() {
        return salariu;
    }

    public void setSalariu(Double salariu) {
        this.salariu = salariu;
    }

    public void apply(User user) {
        Recruiter recruiter;
        Company company;
        if (valabil && meetsRequirments(user)) {
            recruiter = Application.getInstance().getCompany(nume_companie).getRecruiter(user);
            recruiter.evaluate(this, user);
        }
    }

    public boolean meetsRequirments(User user) {
        int educatie = 0;
        int experienta = 0;
        double medief = 0.0;
        educatie = user.getGraduationYear();
        experienta = user.nrAniExp();
        medief = user.meanGPA();
        if (educatie == 0)
            if (educatie_absolvire.inferior != null && educatie_absolvire.superior != null)
                return false;
        if (educatie_absolvire.inferior > educatie && educatie_absolvire.superior < educatie)
            return false;
        if (experienta_ani.inferior > experienta && experienta_ani.superior < experienta)
            return false;
        if (medie.inferior > medief && medie.superior < medief)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "nume=" + nume_job + '\n' +
                "nume_companie=" + nume_companie + '\n' +
                "lista_candidati=" + lista_candidati + '\n' +
                "valabil=" + valabil + '\n' +
                "nr_candidati=" + nr_candidati + '\n' +
                "salariu=" + salariu + '\n' +
                "educatie_absolvire=" + educatie_absolvire + '\n' +
                "experienta_ani=" + experienta_ani + '\n' +
                "medie=" + medie + '\n';
    }
}

