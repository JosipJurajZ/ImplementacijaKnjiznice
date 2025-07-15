import java.util.List;

public abstract class Osoba {

    private long idTotal = 0;

    private String name;
    private String surname;
    private  long id;

    public Osoba(String name, String surname) {

        this.name = name;
        this.surname = surname;

        this.id = idTotal;

        idTotal++;
    }

    public abstract String ShowDetails();

    public long GetId(){
        return id;
    }

    public String GetNameSurnamme(){
        return name + " " + surname;
    }
}

class Korisnik extends Osoba{

    private int maxBookAmount;
    private List<Knjiga> borrowedBooks;

    public Korisnik(String name, String surname, int maxBookAmount){

        super(name,surname);

        this.maxBookAmount = maxBookAmount;
        borrowedBooks = null;
    }

    @Override
    public String ShowDetails(){

        String returnString = super.GetNameSurnamme() + " " + super.GetId() + "\n" + maxBookAmount + "\n" + "Books:\n";
        if(borrowedBooks.isEmpty()){
            returnString += "No books borrowed";
        }
        else{
            for(Knjiga book : borrowedBooks){
                returnString += book.GetTitle() + " " + book.GetAuthor() + " " + book.GetGenre() + " " + book.GetId() + "\n";
            }
        }

        return returnString;
    }

    public void AddBorrowedBook(Knjiga book){

        try {
            if (borrowedBooks.size() < maxBookAmount) {
                borrowedBooks.add(book);
            } else {
                // books exceeded
                throw new ExceededBorrowedBookLimitException();
            }
        } catch (ExceededBorrowedBookLimitException e){
            System.out.println("Book limit has been exceeded!");

        }
    }
}

class ZaposlenikBiblioteke extends Osoba{

    ZaposlenikBiblioteke(String name, String surname){
        super(name, surname);
    }

    public void AddBook(Knjiga book){
        MainKlasa.AddBook(book);
    }

    public void RemoveBook(long id){
        MainKlasa.RemoveBookById(id);
    }

    @Override
    public String ShowDetails(){
        return super.GetNameSurnamme();
    }

}
