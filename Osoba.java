import java.util.PriorityQueue;
import java.util.Queue;

public class Osoba {

    private static long idDodjeljivac = 0;
    private static Queue<Integer> idIzbrisanih = new PriorityQueue<>();
    private String ime;
    private String prezime;
    private long id;

    protected Osoba(String ime,String prezime){
        this.ime = ime;
        this.prezime = prezime;
        if (idIzbrisanih.isEmpty()) {
            this.id = idDodjeljivac++;
        }
        else {
            this.id = idIzbrisanih.poll();
        }
    }

    public static Osoba kreirajOsobu(String ime, String prezime, char tipOsobe ){
        tipOsobe =(char) (tipOsobe | ' ');
        return switch (tipOsobe){
            case 'k' -> new Korisnik(ime,prezime,3);
            case 'z' -> new ZaposlenikBiblioteke(ime,prezime);// dodaj zaposlenika
            default -> new Osoba(ime,prezime);
        };
    }

    protected void dodajURed(Integer id){

        idIzbrisanih.add(id);
    }

    public long getId() {
        return id;
    }

    protected String getIme(){
        return ime;
    }
    protected String getPrezime(){
        return prezime;
    }
}
