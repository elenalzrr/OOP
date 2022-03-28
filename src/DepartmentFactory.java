public class DepartmentFactory {
    public Department getDepartmentFactory(String tipdepartament) {
        if (tipdepartament == null)
            return null;
        if (tipdepartament.equalsIgnoreCase("IT"))
            return new IT();
        if (tipdepartament.equalsIgnoreCase("Finance"))
            return new Finance();
        if (tipdepartament.equalsIgnoreCase("Management"))
            return new Management();
        if (tipdepartament.equalsIgnoreCase("Marketing"))
            return new Marketing();
        return null;
    }
}
