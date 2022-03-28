import java.time.*;

public class Experience implements Comparable<Experience> {

    public LocalDate start;
    public LocalDate end;
    public String position, company;

    public Experience(LocalDate starts, LocalDate ends, String position, String company) throws InvalidDatesException {
        this.position = position;
        this.company = company;
        this.end = ends;
        this.start = starts;
        //am comentat mesajele din exceptie pentru a evita spamul
        try {
            if (ends == null) {
                this.end = null;
                return;
            }
            if (ends.isEqual(starts)) {
                throw new InvalidDatesException();
                //throw new InvalidDatesException("Date incorecte");
            }
            if (ends.isBefore(starts)) {
                throw new InvalidDatesException();
                //throw new InvalidDatesException("Data de inceput este inaintea datei de final");
            }
            this.position = position;
            this.company = company;


        } catch (InvalidDatesException e) {
        }
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getEnd() {
        return end;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }


    public int compareTo(Experience a) {
        if (end == null || a.end == null)
            return 1;
        if (a.end.isEqual(this.end))
            return (company.compareTo(a.company));
        return a.end.compareTo(end);
    }


    @Override
    public String toString() {
        return "Experience:" + '\n' +
                "start:" + start + '\n' +
                "end:" + end + '\n' +
                "position:" + position + '\n' +
                "company:" + company + '\n';
    }
}


