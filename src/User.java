
import java.lang.*;
import java.util.*;
import java.time.*;

public class User extends Consumer implements Observer {

    public ArrayList<String> job;

    public User() {
        super();
        job = new ArrayList<>();
    }

    public ArrayList<String> sendJob() {
        Application.getInstance().getJobs(job);
        return job;
    }

    public Employee convert() {
        return new Employee();
    }

    public int nrAniExp() {
        int exp = 0;
        int aniexp = 0;
        TreeSet<Experience> ex = resume.getExperience();
        for (Experience experience : ex) {
            LocalDate startE = experience.start;
            LocalDate endE = experience.end;
            if (endE == null) {
                int prezent = LocalDate.now().getYear();
                int anFinal = endE.getYear();
                exp = (prezent - anFinal);
            }
            if (startE != null && endE != null) {
                if (startE.getMonth().getValue() >= 3) {
                    int anInceput = startE.getYear();
                    int anFinal = endE.getYear();
                    exp = (anFinal - anInceput) + 1;

                } else if (startE.getMonth().getValue() < 3) {
                    int anInceput = startE.getYear();
                    int anFinal = endE.getYear();
                    exp = (anFinal - anInceput);
                }
            }
            int an = LocalDate.now().getYear();
            aniexp = aniexp + exp;

        }
        return aniexp;
    }

    public Double getTotalScore() {
        return nrAniExp() * 0.15 + meanGPA();
    }


    @Override
    public String toString() {
        return resume + "job:" + job;
    }

    @Override
    public void update(String notification) {
        System.out.println("Notificare noua :: " + notification);
    }
}
