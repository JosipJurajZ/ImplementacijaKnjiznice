public enum PersonCategory {

    KORISNIK(new UserManagement()), ZAPOSLENIK(new EmployeeManagement());

    private final PersonInterface strategy;

    PersonCategory(PersonInterface strategy){
        this.strategy = strategy;
    }

    public PersonInterface getStrategy() {
        return strategy;
    }
}