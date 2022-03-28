import java.lang.*;

public class Recruiter extends Employee {

    public double rating = 5.0;

    public Recruiter() {
        super();
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Recruiter:" + '\n' +
                "rating=" + rating + '\n';
    }

    public int evaluate(Job job, User user) {
        Company company = Application.getInstance().getCompany(nume_companie);
        rating = rating + 0.1;
        double evaluare;
        double scor = user.getTotalScore();
        evaluare = rating * scor;
        Request request = new Request(job, user, this, evaluare);
        company.managers.req.add(request);
        return (int) evaluare;


    }
}
