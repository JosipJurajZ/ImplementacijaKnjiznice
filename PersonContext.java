import java.util.LinkedList;

public class PersonContext{

    private PersonInterface strategy;

    public PersonContext(PersonInterface strategy){
        this.strategy = strategy;
    }

    public void setStrategy(PersonInterface strategy) {
        this.strategy = strategy;
    }

    public void addPerson(LinkedList<Osoba> list, Osoba person){

        if(strategy == null){
            throw new IllegalStateException("Missing person addition strategy!");
        }

        strategy.addPerson(list, person);
    }

    public void removePerson(LinkedList<Osoba> list, long id){

        if(strategy == null){
            throw new IllegalStateException("Missing person addition strategy!");
        }

        if(id < 0){
            throw new IllegalArgumentException("Id can not be less than 0!");
        }

        strategy.removePerson(list, id);
    }
}
