public class Knjiga {

    private static long idTotal = 0;

    private long id;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Knjiga(String title, String author, String genre){

        this.title = title;
        this.author = author;
        this.genre = genre;

        isAvailable = true;
        id = idTotal;
        idTotal++;
    }

    public void ChangeAvailability(){
        this.isAvailable = !isAvailable;
    }

    public void ChangeAvailability(boolean availability){
        this.isAvailable = availability;
    }

    public String GetTitle(){
        return title;
    }

    public  String GetAuthor(){
        return author;
    }

    public String GetGenre(){
        return genre;
    }

    public long GetId(){
        return id;
    }

    public void SetTitle(String title){
        this.title = title;
    }

    public void SetAuthor(String author) {
        this.author = author;
    }

    public void SetGenre(String genre) {
        this.genre = genre;
    }

    public boolean GetStatus(){
        return this.isAvailable;
    }
}
