import java.util.List;

public class MainKlasa {

    List<Knjiga> libraryBooks;
    List<Korisnik> libraryUsers;


    public static void main(String[] args) {

    }

    public static void AddBook(Knjiga book){
        libraryBooks.add(book);
    }

    public static void AddBook(String title, String author, String genre){
        libraryBooks.add(new Knjiga(title, author, genre));
    }

    public static List<Knjiga> SearchBookByTitle(String searchInput){


        List<Knjiga> matchingBooks = null;

        for(Knjiga book : libraryBooks){

            if(book.GetTitle().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public static List<Knjiga> SearchBookByAuthor(String searchInput){


        List<Knjiga> matchingBooks = null;

        for(Knjiga book : libraryBooks){

            if(book.GetAuthor().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }


        return matchingBooks;
    }

    public static List<Knjiga> SearchBookByGenre(String searchInput){

        List<Knjiga> matchingBooks = null;

        for(Knjiga book : libraryBooks){

            if(book.GetGenre().toLowerCase().contains(searchInput.toLowerCase())){
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public static Knjiga ChangeBookTitle(Knjiga book, String title){

        if(book == null){
            System.out.println("Error, book cannot be null!");
            return null;
        }
        book.SetTitle(title);
        return book;
    }

    public static Knjiga ChangeBookAuthor(Knjiga book, String author){


        if(book == null){
            System.out.println("Error, book cannot be null!");
            return null;
        }

        book.SetAuthor(author);
        return book;
    }

    public static Knjiga ChangeBookGenre(Knjiga book, String genre){


        if(book == null){
            System.out.println("Error, book cannot be null!");
            return null;
        }

        book.SetGenre(genre);
        return book;
    }
  
    public static void RemoveBookById(long id){

        for(Knjiga book : libraryBooks){
            if(book.GetId() == id ){
                libraryBooks.remove(book);
                return;
            }
        }
        System.out.println("Book with id of \"" + id + "\" not found!");
    }

    public static void AddUser(Korisnik user){
        libraryUsers.add(user);
    }

    public static void AddUser(String name, String surname, int maxBooks){
        libraryUsers.add(new Korisnik(name, surname, maxBooks));
    }

    public static void RemoveUserById(long id){

        for(Korisnik user : libraryUsers){
            if(user.GetId() == id){
                libraryUsers.remove(user);
                return;
            }
        }
        System.out.println("User with id of \"" + id + "\"does not exist");
    }

    public static void AddLibraryEmployee(String name, String surname){
        libraryEmployees.add(new ZaposlenikBiblioteke(name, surname));
    }

    public static void RemoveLibraryEmployeeById(long id){

        for(ZaposlenikBiblioteke employee : libraryEmployees){
            if(employee.GetId() == id){
                libraryEmployees.remove(employee);
                return;
            }
        }

        System.out.println("Employee with id \"" + id + "\" not found");
    }

    public static boolean CheckBookAvailability(long id){
        for(Knjiga book : libraryBooks){
            if(book.GetId() == id){
                return book.GetStatus();
            }
        }
        System.out.println("Knjiga koja ima id \"" + id +  "\" ne postoji");
        return false;
    }

}
