import java.util.LinkedList;

public class BookContext {
    private BookInterface strategy;

    public BookContext(BookInterface strategy){
        this.strategy = strategy;
    }

    public void SetStrategy(BookInterface strategy){
        this.strategy = strategy;
    }

    public LinkedList<Knjiga> findBook(LinkedList<Knjiga> list, String searchInput){

        if(strategy == null){
            throw new IllegalStateException("Missing search strategy");

        }

        return strategy.findBook(list, searchInput);
    }

    public void changeBook(Knjiga book, String newData){

        if(strategy == null){
            throw new IllegalStateException("Missing category strategy");

        }

        strategy.changeBook(book, newData);
    }
}