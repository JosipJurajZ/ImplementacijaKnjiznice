import java.util.LinkedList;

public interface PersonInterface {

    void addPerson(LinkedList<Osoba> list, Osoba person);

    void removePerson(LinkedList<Osoba> list, long id);
}

class UserManagment implements PersonInterface{

    @Override
    public void addPerson(LinkedList<Osoba> list, Osoba person) {

        if(person.getClass() != Korisnik.class){
            throw new IllegalArgumentException("Not a user!");

        }

        if(list.contains(person)){
            throw new RuntimeException("User already exists!");
        }

        list.add(person);
    }

    @Override
    public void removePerson(LinkedList<Osoba> list, long id) {

        for(Osoba user : list){
            if(user.GetId() == id) {
                if (user.getClass() == Korisnik.class) {
                    list.remove(user);
                    System.out.println("User with id of \"" + id + "\" removed.");
                    return;
                }

            }
        }
        System.out.println("User with id of \"" + id + "\" does not exist.");
    }
}

class EmployeeManagment implements PersonInterface{

    @Override
    public void addPerson(LinkedList<Osoba> list, Osoba person) {

        if(person.getClass() != ZaposlenikBiblioteke.class){

            throw new IllegalArgumentException("Not an employee!");
        }

        if(list.contains(person)){
            throw new RuntimeException("Employee already exists!");
        }

        list.add(person);
    }

    @Override
    public void removePerson(LinkedList<Osoba> list, long id) {

        for(Osoba user : list){
            if(user.GetId() == id) {
                if (user.getClass() == ZaposlenikBiblioteke.class) {
                    list.remove(user);
                    System.out.println("Employee with id of \"" + id + "\" removed");
                    return;
                }
            }
        }

        System.out.println("Employee with id of \"" + id + "\"does not exist");
    }
}
