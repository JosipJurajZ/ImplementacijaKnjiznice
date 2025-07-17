import java.util.LinkedList;

public class MainKlasa {

    private static LinkedList<Knjiga> libraryBooks;
    private static LinkedList<Osoba> libraryPeople;

    private static BookContext bookContext = new BookContext(new Title());
    private static PersonContext personContext = new PersonContext(new UserManagment());

    public static void main(String[] args) {

    }

    public static void addBook(Knjiga book){
        libraryBooks.add(book);
    }

    public static LinkedList<Knjiga> searchForBook(BookCategory category, String searchInput){

        switch (category){
            case TITLE:
                bookContext.SetStrategy(new Title());
                break;
            case AUTHOR:
                bookContext.SetStrategy(new Author());
                break;
            case GENRE:
                bookContext.SetStrategy(new Genre());
                break;
            default:
                //invalid search
                return null;
        }

        return bookContext.findBook(libraryBooks, searchInput);
    }

    public static void changeBook(Knjiga book, BookCategory category, String newData){

        if(book == null){
            //No book
            return;
        }

        switch (category){
            case TITLE:
                bookContext.SetStrategy(new Title());
                break;
            case AUTHOR:
                bookContext.SetStrategy(new Author());
                break;
            case GENRE:
                bookContext.SetStrategy(new Genre());
                break;
            default:
                //invalid search
                return;
        }

        bookContext.changeBook(book, newData);

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

    public static void addPerson(Osoba person, PersonCategory userType){

        if(person == null){
            return;
        }

        switch (userType){
            case KORISNIK:
                personContext.setStrategy(new UserManagment());
                break;
            case ZAPOSLENIK:
                personContext.setStrategy(new EmployeeManagment());
                break;
            default:
                return;
        }

        personContext.addPerson(libraryPeople, person);
    }

    public static void removePerson(long id, PersonCategory userType){

        if(id < 0){
            return;
        }

        switch (userType){
            case KORISNIK:
                personContext.setStrategy(new UserManagment());
                break;
            case ZAPOSLENIK:
                personContext.setStrategy(new EmployeeManagment());
                break;
            default:
                return;
        }

        personContext.removePerson(libraryPeople, id);

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

    // needs a validation check if the sent user is Korisnik from the sent function

    public static void BorrowBook(Korisnik user, Knjiga book) throws BookNotAvailableException {

        if(user == null){
            System.out.println("Korisnik ne postoji");
            return;
        }

        if(!libraryPeople.contains(user)){
            System.out.println("Korisnik nije u sustavu!");
            return;
        }

        if(book == null){
            System.out.println("Knjiga ne postoji!");
            return;
        }

        if(!libraryBooks.contains(book)){
            System.out.println("Knjiga nije u sustavu!");
            return;
        }

        if(book.GetStatus()){
            book.ChangeAvailability(false);
            user.AddBorrowedBook(book);
        }
        else{
            throw new BookNotAvailableException();
        }
    }

    public static void ReturnBook(Korisnik user, Knjiga book){

        if(user == null){
            System.out.println("Korisnik ne postoji");
            return;
        }

        if(!libraryPeople.contains(user)){
            System.out.println("Korisnik nije u sustavu!");
            return;
        }

        if(book == null){
            System.out.println("Knjiga ne postoji!");
            return;
        }

        if(!libraryBooks.contains(book)){
            System.out.println("Knjiga nije u sustavu!");
            return;
        }

        if(user.RemoveBorrowedBook(book)){
            book.ChangeAvailability(true);
        }
    }
}
