
import java.time.*;
import java.lang.*;

public class Education implements Comparable<Education> {

    public String name;
    public String level;
    public LocalDate start;
    public LocalDate end;
    public Double grade;

    public Education(String name, String level, LocalDate starts, LocalDate ends, Double grade) throws InvalidDatesException {
        this.name = name;
        this.level = level;
        this.start = starts;
        this.end = ends;
        this.grade = grade;
        try {
            //am comentat mesajele din exceptie pentru a evita spamul
            if (ends != null) {
                if (ends.equals(starts)) {
                    throw new InvalidDatesException();
                    //throw new InvalidDatesException("Date incorecte");
                }
                if (ends.compareTo(starts) > 0) {
                    throw new InvalidDatesException();
                    // throw new InvalidDatesException("Data de inceput este inaintea datei de final");
                }
            }
            this.level = level;
            this.grade = grade;
            this.name = name;
        } catch (InvalidDatesException e) {
        }

    }


    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getNivel() {
        return level;
    }

    public void setNivel(String level) {
        this.level = level;
    }

    public double setGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public int compareTo(Education a) {
        if (this.end != null) {
            if (this.end.isEqual(a.end)) {
                return (int) (a.grade - grade);
            }
        }
        if (a.end == null) {
            return start.compareTo(a.start);
        }
        if (this.end == null) {
            return start.compareTo(a.start);
        }

        return a.end.compareTo(end);
    }


    @Override
    public String toString() {
        return "Education:" + '\n' +
                "name:" + name + '\n' +
                "start:" + start + '\n' +
                "end:" + end + '\n' +
                "grade:" + grade + '\n' +
                "nivel:" + level;
    }
}

class InvalidDatesException extends Exception {
    public InvalidDatesException() {
        super("Date invalide");
    }

    public InvalidDatesException(String date_incorecte) {
        System.out.println(date_incorecte);

    }
}

