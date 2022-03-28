
public class Test {
    public static void main(String[] args) throws Exception, ResumeIncompleteException {
        FunctiiPtTestare test = new FunctiiPtTestare();
        test.CitireJoburi();
        test.citireConsumers();
        test.citirePrieteni();
        PrimaPagina primaPagina = new PrimaPagina();
        primaPagina.setVisible(true);


        // System.out.println(test.prieteni);
        //    System.out.println(test.joburii.get(0).getNume());
        //   System.out.println(test.managerlist);
        //   Company company = new Company("Google");
        //   System.out.println(Application.getInstance().getCompanies());
        //System.out.println(test.CautaJob());
        //test.CautaJob();
        //test.citireConsumers();
        //    System.out.println(test.employeelist.get(0));
        //System.out.println(test.user.get(0));
        //functii verificate si functionale
        // System.out.println(Application.getInstance().company.get(0).departments.get(1).tip);
        //System.out.println(test.user.get(2));
        //System.out.println(test.user.get(2).nrAniExp());
        //System.out.println(Application.getInstance().getCompany("Google"));
        //System.out.println("Scorul unui utilizator : " + test.user.get(0).getTotalScore());
        //Education ed = new Education("nume","x","01.01.2000","01.01.2010",2.3);
        //  for (Company company : test.joburii) {
        //     for (Department department : company.departments) {
        //        for (Job job : department.getJobs()) {
        //            company.managers.process(job);
        //       }
        //    }
        // }
        //Education ed2 = new Education("nume2","x2","02.02.2000","02.01.2010",2.4);
        //System.out.println(ed.compareTo(ed2));
        //Experience ex = new Experience("01.01.2000","01.01.2001","x","y");
        //Experience ex2 = new Experience("03.02.2020","01.04.2031","zx","sy");
        //System.out.println(ex.compareTo(ex2));
        //List<String> companies = new ArrayList<>();
        //companies.add("Google");
        //companies.add("Amazon");
        //System.out.println(Application.getInstance().getJobs(companies));
        //Constraint x = new Constraint(100.0,200.0);
        //ArrayList<Job> jobs = new ArrayList<Job>();
        //Job job = new Job("x","x","x",false,5,5656,x,x,x,0);
        //jobs.add(job);
        //System.out.println(jobs);

    }

}


