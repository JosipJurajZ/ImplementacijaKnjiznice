import java.util.List;

public class MainKlasa {

    List<Knjiga> libraryBooks;
    List<Korisnik> libraryUsers;

    public static void main(String[] args) {

    }

    public void AddBook(Knjiga book){
        libraryBooks.add(book);
    }

    public void AddBook(String title, String author, String genre){
        libraryBooks.add(new Knjiga(title, author, genre));
    }

    public List<Knjiga> SearchBookByTitle(String searchInput){

        List<Knjiga> matchingBooks = null;

        for(Knjiga book : libraryBooks){

            if(book.GetTitle().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public List<Knjiga> SearchBookByAuthor(String searchInput){

        List<Knjiga> matchingBooks = null;

        for(Knjiga book : libraryBooks){

            if(book.GetAuthor().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }


        return matchingBooks;
    }

    public List<Knjiga> SearchBookByGenre(String searchInput){

        List<Knjiga> matchingBooks = null;

        for(Knjiga book : libraryBooks){

            if(book.GetGenre().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public Knjiga ChangeBookTitle(Knjiga book, String title){
        if(book == null){
            System.out.println("Error, book cannot be null!");
            return null;
        }
        book.SetTitle(title);
        return book;
    }

    public Knjiga ChangeBookAuthor(Knjiga book, String author){

        if(book == null){
            System.out.println("Error, book cannot be null!");
            return null;
        }

        book.SetAuthor(author);
        return book;
    }

    public Knjiga ChangeBookGenre(Knjiga book, String genre){

        if(book == null){
            System.out.println("Error, book cannot be null!");
            return null;
        }

        book.SetGenre(genre);
        return book;
    }

    public void RemoveBookById(long id){
        for(Knjiga book : libraryBooks){
            if(book.GetId() == id ){
                libraryBooks.remove(book);
                return;
            }
        }
        System.out.println("Book with id of \"" + id + "\" not found!");
    }

    public void AddUser(Korisnik user){
        libraryUsers.add(user);
    }

    public void AddUser(String name, String surname, int maxBooks){
        libraryUsers.add(new Korisnik(name, surname, maxBooks));
    }

    public void RemoveUserById(long id){
        for(Korisnik user : libraryUsers){
            if(user.GetId() == id){
                libraryUsers.remove(user);
                return;
            }
        }
        System.out.println("User with id of \"" + id + "\"does not exist");
    }
}
