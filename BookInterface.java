import java.util.LinkedList;

public interface BookInterface {

    LinkedList<Knjiga> findBook(LinkedList<Knjiga> list, String searchInput);

    void changeBook(Knjiga book, String newInfo);
}

class Title implements BookInterface {

    @Override
    public LinkedList<Knjiga> findBook(LinkedList<Knjiga> list, String searchInput){

        LinkedList<Knjiga> matchingBooks = new LinkedList<>();

        for(Knjiga book : list){

            if(book.GetTitle().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    @Override
    public void changeBook(Knjiga book, String newInfo) {
        book.SetTitle(newInfo);
    }
}

class Author implements BookInterface {

    @Override
    public LinkedList<Knjiga> findBook(LinkedList<Knjiga> list, String searchInput){

        LinkedList<Knjiga> matchingBooks = new LinkedList<>();

        for(Knjiga book : list){

            if(book.GetAuthor().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    @Override
    public void changeBook(Knjiga book, String newInfo) {
        book.SetAuthor(newInfo);
    }
}

class Genre implements BookInterface {

    @Override
    public LinkedList<Knjiga> findBook(LinkedList<Knjiga> list, String searchInput){

        LinkedList<Knjiga> matchingBooks = new LinkedList<>();

        for(Knjiga book : list){

            if(book.GetGenre().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    @Override
    public void changeBook(Knjiga book, String newInfo) {
        book.SetGenre(newInfo);
    }
}
