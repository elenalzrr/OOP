import java.util.*;
import java.lang.*;

public class Consumer {


    public List<Consumer> lista_prieteni;
    public Resume resume;

    public Consumer() {
        this.resume = resume;
        lista_prieteni = new ArrayList<>();
    }


    public int aniMunciti() {
        return this.resume.experience.first().end.getYear() - this.resume.experience.first().start.getYear();
    }

    public void add(Education education) {
        resume.addEducation(education);

    }

    public void add(Experience experience) {
        resume.addExperience(experience);
    }

    public void add(Consumer consumer) {
        if (!(lista_prieteni.contains(consumer)))
            lista_prieteni.add(consumer);
    }

    //BFS ALGORITM
    public int getDegreeInFriendship(Consumer consumer) {
        int grad = 0;
        Queue<Consumer> check = new LinkedList<>();
        ArrayList<Consumer> checked = new ArrayList<>();
        check.add(this);
        while (!check.isEmpty()) {
            if (consumer == null) {
                grad++;
                continue;
            }
            check.remove();
            checked.add(consumer);
            for (Consumer newconsumer : consumer.lista_prieteni) {
                if (!checked.contains(newconsumer))
                    check.add(newconsumer);
            }
        }
        return grad;
    }


    public void remove(Consumer consumer) {

        lista_prieteni.remove(consumer);
    }


    public Integer getGraduationYear() {
        for (Education education : this.resume.getEducation())
            if (education.getNivel().equals(education.level.contains("college")))
                if (education.end != null)
                    return education.end.getYear();
        return 0;
    }

    public Double meanGPA() {
        Double aux = 0.0;
        int i = 0;
        for (Education education : this.resume.getEducation()) {
            aux = education.grade + aux;
            i++;
        }
        if (i > 0)
            return aux / i;
        return 0.0;

    }

    static class Resume {
        public Information information;
        public TreeSet<Education> education = new TreeSet<Education>();
        public TreeSet<Experience> experience = new TreeSet<Experience>();
        public Employee employee;

        public Resume(ResumeBuilder builder) throws ResumeIncompleteException {
            this.information = builder.information;
            this.education = builder.education;
            this.experience = builder.experience;
            this.employee = builder.employee;
            try {
                if (information == null) {
                    throw new ResumeIncompleteException();
                }
            } catch (ResumeIncompleteException r) {

            }

        }

        public Information getObj() {
            return information;
        }

        public void setObj() {
            this.information = information;
        }

        public Employee getEmployee() {
            return employee;
        }

        public void setEmployee(Employee employee) {
            this.employee = employee;
        }

        public void setEducation(TreeSet<Education> education) {
            education = education;
        }

        public void setExperience(TreeSet<Experience> experience) {
            experience = experience;
        }

        public TreeSet<Experience> getExperience() {
            return experience;
        }

        public TreeSet<Education> getEducation() {
            return education;
        }

        public void addEducation(Education education) {
            this.education.add(education);
        }

        public void addExperience(Experience experience) {
            this.experience.add(experience);
        }


        @Override
        public String toString() {
            return "Resume:" + '\n' +
                    "information:" + information + '\n' +
                    "education:" + education + '\n' +
                    "experience:" + experience + '\n';
        }


        static class ResumeBuilder {
            public Information information;
            public TreeSet<Education> education = new TreeSet<Education>();
            public TreeSet<Experience> experience = new TreeSet<Experience>();
            public Employee employee;
            public Experience ultExp;

            public ResumeBuilder() {
                information = new Information();
            }

            public ResumeBuilder name(String name) {
                this.information.setNume(name);
                return this;
            }

            public ResumeBuilder firstName(String firstName) {
                this.information.setPrenume(firstName);
                return this;
            }

            public ResumeBuilder email(String email) {
                this.information.setEmail(email);
                return this;
            }

            public ResumeBuilder phoneNumber(String phoneNumber) {
                this.information.setNumar(phoneNumber);
                return this;
            }


            public ResumeBuilder birthDate(String birthDate) {
                this.information.setZinastere(birthDate);
                return this;
            }

            public ResumeBuilder gender(String gender) {
                this.information.setSex(gender);
                return this;
            }

            public ResumeBuilder language(ArrayList<Language> languages) {
                this.information.setLimbicun(languages);
                return this;
            }

            public ResumeBuilder Information(Information information) {
                this.information = information;
                return this;
            }

            public ResumeBuilder Experience(TreeSet<Experience> experience) {
                this.experience = experience;
                return this;
            }

            public ResumeBuilder Education(TreeSet<Education> education) {
                this.education = education;
                return this;
            }

            public Resume build() throws ResumeIncompleteException {
                return new Resume(this);
            }

        }
    }
}


