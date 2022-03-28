import java.util.*;

public class Information {
    public String nume, prenume, email, sex, numar;
    public String zinastere;
    public ArrayList<Language> limbicun;

    public Information() {
        this(null, null, null, null, null, null);
    }

    public Information(String nume, String prenume, String email, String sex, String numar, ArrayList<Language> limbicun) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.sex = sex;
        this.limbicun = limbicun;
        this.numar = numar;

    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public String getZinastere() {
        return zinastere;
    }


    public void setZinastere(String zinastere) {
        this.zinastere = zinastere;
    }

    public ArrayList<Language> getLimbicun() {
        return limbicun;
    }

    public void setLimbicun(ArrayList<Language> limbicun) {
        this.limbicun = limbicun;
    }

    @Override
    public String toString() {
        return "Information:" + '\n' +
                "nume:" + nume + '\n' +
                "prenume:" + prenume + '\n' +
                "email:" + email + '\n' +
                "sex:" + sex + '\n' +
                "numar:" + numar + '\n' +
                "zi nastere:" + zinastere + '\n' +
                "limbicun:" + limbicun + '\n';
    }

}
