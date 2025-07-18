import java.util.LinkedList;

public class MainKlasa {

    private static LinkedList<Knjiga> libraryBooks = new LinkedList<>();
    private static LinkedList<Osoba> libraryPeople = new LinkedList<>();

    private static BookContext bookContext = new BookContext(new Title());
    private static PersonContext personContext = new PersonContext(new UserManagement());

    public static void main(String[] args) {

    }

    public static void addBook(Knjiga book){
        libraryBooks.add(book);
    }

    public static LinkedList<Knjiga> searchForBook(BookCategory category, String searchInput){

        bookContext.setStrategy(category.getStrategy());

        return bookContext.findBook(libraryBooks, searchInput);
    }

    public static void changeBook(Knjiga book, BookCategory category, String newData){

        if(book == null){
            //No book
            return;
        }

        bookContext.setStrategy(category.getStrategy());

        bookContext.changeBook(book, newData);

    }

    public static void removeBookById(long id){
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

        personContext.setStrategy(userType.getStrategy());

        personContext.addPerson(libraryPeople, person);
    }

    public static void removePerson(long id, PersonCategory userType){

        if(id < 0){
            return;
        }

        personContext.setStrategy(userType.getStrategy());

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

    public static void borrowBook(Korisnik user, Knjiga book) throws BookNotAvailableException {

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

    public static void returnBook(Korisnik user, Knjiga book){

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