public class ZaposlenikBiblioteke extends Osoba{

    public ZaposlenikBiblioteke(String ime, String prezime){
        super(ime,prezime);
    }

   public void dodajKnjigu(){
        Knjiznica.dodajKnjigu(this.getClass());
    }

    public void izbrisiKnjigu(){
        Knjiznica.brisanjeKnjige(this.getClass());
    }

    public void promijeniInfoOKnjizi(){
        Knjiznica.mijenjanjeInformacijeOKnjizi(this.getClass());
    }

}
