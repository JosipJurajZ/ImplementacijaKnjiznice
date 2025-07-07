import java.util.List;

public abstract class Osoba {

    private long idTotal;

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
}
