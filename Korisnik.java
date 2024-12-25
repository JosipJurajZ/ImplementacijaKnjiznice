import java.util.ArrayList;

public class Korisnik extends Osoba{

    private int maxBrojKnjiga;
    private Knjiga[] posudeneKnjige;
    private ArrayList<Knjiga> sveKnjigeKojeSuBilePosudene;

    public Korisnik(String ime, String prezime,int maxBrojKnjiga){
        super(ime,prezime);
        this.maxBrojKnjiga = maxBrojKnjiga;
        posudeneKnjige = new Knjiga[maxBrojKnjiga];
    }

    public void PrikazDetalja(){
        System.out.println(super.getIme() + " " + super.getPrezime() + "\n id: " + super.getId());
        System.out.println("Knjige trenutno u posudbi: ");
        for(Knjiga k : posudeneKnjige){
            System.out.println(k.getTitle());
        }
        System.out.println("Povijest posudbi: ");
        for (Knjiga k : sveKnjigeKojeSuBilePosudene){
            System.out.println(k.getTitle());
        }
    }
}
