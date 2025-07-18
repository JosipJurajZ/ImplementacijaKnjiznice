import java.util.LinkedList;
import java.util.ListIterator;

public interface PersonInterface {

    void addPerson(LinkedList<Osoba> list, Osoba person);

    void removePerson(LinkedList<Osoba> list, long id);
}

class UserManagement implements PersonInterface{

    @Override
    public void addPerson(LinkedList<Osoba> list, Osoba person) {

        if(!(person instanceof Korisnik)){
            throw new IllegalArgumentException("Not a user!");

        }

        if(list.contains(person)){
            throw new RuntimeException("User already exists!");
        }

        list.add(person);
    }

    @Override
    public void removePerson(LinkedList<Osoba> list, long id) {

        ListIterator<Osoba> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Osoba user = iterator.next();

            if (user.GetId() == id) {
                if (user instanceof Korisnik) {
                    iterator.remove();
                    System.out.println("User with id of \"" + id + "\" removed.");
                    return;
                }
            }
        }
        System.out.println("User with id of \"" + id + "\" does not exist.");

    }
}

class EmployeeManagement implements PersonInterface{

    @Override
    public void addPerson(LinkedList<Osoba> list, Osoba person) {

        if(!(person instanceof ZaposlenikBiblioteke)){

            throw new IllegalArgumentException("Not an employee!");
        }

        if(list.contains(person)){
            throw new RuntimeException("Employee already exists!");
        }

        list.add(person);
    }

    @Override
    public void removePerson(LinkedList<Osoba> list, long id) {

        ListIterator<Osoba> iterator = list.listIterator();

        while (iterator.hasNext()){
            Osoba emp = iterator.next();

            if(emp.GetId() == id) {
                if (emp instanceof ZaposlenikBiblioteke) {
                    iterator.remove();
                    System.out.println("Employee with id of \"" + id + "\" removed");
                    return;
                }
            }

        }

        System.out.println("Employee with id of \"" + id + "\"does not exist");
    }
}
