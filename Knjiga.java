import java.util.PriorityQueue;
import java.util.Queue;

public class Knjiga {

    private static long idDodjeljivac = 0;
    private static Queue<Integer> idIzbrisanih = new PriorityQueue<>();
    private String author;
    private String title;
    private String genre;
    private long id;
    private boolean availability;


    public Knjiga(String author, String title, String genre){
        this.author = author;
        this.title = title;
        this.genre = genre;
        if (idIzbrisanih.isEmpty()) {
            this.id = idDodjeljivac++;
        }
        else {
            this.id = idIzbrisanih.poll();
        }
        this.availability = true;
    }

    public void promjeniDostupnost(){
        this.availability = !this.availability;
    }

    public void ispisInfo(){

        System.out.println("\nPodaci knjige:\nAutor: " + author + "\nNaslov: " + title + "\nŽanr: " + genre + "\nId: " + id);
    }


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public long getId() {
        return id;
    }

    public void promjenaPodataka(Knjiga zamjena){
        this.author = zamjena.getAuthor();
        this.genre = zamjena.getGenre();
        this.title = zamjena.getTitle();
        idDodjeljivac--;
    }

    public void dodajURed(Integer id){
        idIzbrisanih.add(id);
    }
}
