public class Language {
    public String level;
    public String nume;

    public Language(String nume, String level) {
        this.level = level;
        this.nume = nume;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "numele limbii:" + nume + " level=" + level + '\n';
    }
}