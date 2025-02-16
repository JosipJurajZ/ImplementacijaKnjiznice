import java.util.ArrayList;
import java.util.Scanner;

public class Knjiznica {

    public static void main(String[] args) {

        ArrayList<Knjiga> popisKnjiga = new ArrayList<>();
        ArrayList<Osoba> popisOsoba = new ArrayList<>();


        for (int i = 0; i < 4; i++) {
            dodajKnjigu(popisKnjiga);
        }

        for(Knjiga k: popisKnjiga){
           k.ispisInfo();
        }

        pretraga(popisKnjiga);
        mijenjanjeInformacijeOKnjizi(popisKnjiga);
        brisanjeKnjige(popisKnjiga);

        for(Knjiga k: popisKnjiga){
            k.ispisInfo();
        }
    }

    public static void dodajKnjigu(ArrayList<Knjiga> listaSKnjigama){

        listaSKnjigama.add(ZaposlenikBiblioteke.dodajKnjigu(stvaranjeKnjige()));
    }

    public static void pretraga(ArrayList<Knjiga> listaSKnjigama){

        Scanner scan = new Scanner(System.in);
        char unos;
        String pretraga;
        boolean done = false;
        boolean found;

        do{
            found = false;
            System.out.println("Unesite A za pretraživanje po autoru, N za naslov ili Z za žanr ");
            unos = scan.nextLine().toUpperCase().charAt(0);
            System.out.println("Unesite pojam za pretraživanje");
            pretraga = scan.nextLine();

            if(pretraga.isBlank()){
                System.out.println("Pojam za pretraživanje ne smije biti prazan");
                continue;
            }
            else {
                switch (unos){
                    case 'A':
                        for(Knjiga k: listaSKnjigama){
                            if(k.getAuthor().equalsIgnoreCase(pretraga)){
                                System.out.println("Knjiga je nađena!");
                                System.out.println("id: " + k.getId());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Knjiga nije nađena!");
                        }
                        break;
                    case 'N':
                        for(Knjiga k: listaSKnjigama){
                            if(k.getTitle().equalsIgnoreCase(pretraga)){
                                System.out.println("Knjiga je nađena!");
                                System.out.println("id: " + k.getId());
                                found = true;
                                break;
                            }

                        }
                        if (!found) {
                            System.out.println("Knjiga nije nađena");
                        }
                        break;
                    case 'Z':
                        for(Knjiga k: listaSKnjigama){
                            if(k.getGenre().equalsIgnoreCase(pretraga)){
                                System.out.println("Knjiga je nađena!");
                                System.out.println("id: " + k.getId());
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            System.out.println("Knjiga nije nađena");
                        }
                        break;
                    default:
                        System.out.println("Krivi unos za pretragu!");
                        break;
                }
            }

            System.out.println("Jeste li gotovi sa pretragom? Y za da:");
            unos = scan.nextLine().toUpperCase().charAt(0);
            if(unos == 'Y'){
                done = true;
            }

        }while (!done);
    }

    public static void mijenjanjeInformacijeOKnjizi(ArrayList<Knjiga> listaSKnjigama){

        Scanner scan = new Scanner(System.in);
        System.out.println("Unesi id knjige koju želiš promijeniti: ");
        while (true){
            try{

                int id = scan.nextInt();
                boolean found = false;

                for(Knjiga k: listaSKnjigama){
                    if(k.getId() == id){
                        System.out.println("Knjiga je nađena!");
                        k.promjenaPodataka(stvaranjeKnjige());

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Knjiga nije nađena!");
                }
                else {
                    break;
                }

            }catch (Exception ex){
                System.out.println("ID je ne važeći!");
            }
        }

    }

    public static Knjiga stvaranjeKnjige() {

        Scanner scan = new Scanner(System.in);
        String autor, naslov, zanr;
        char uvjet;

        while (true) {
            System.out.println("Unesite: autora, naslov i žanr knjige (sa enterom):");
            autor = scan.nextLine();
            naslov = scan.nextLine();
            zanr = scan.nextLine();

            System.out.println("Podaci knjige: \nAutor: " + autor + "\nNaslov: " + naslov + "\nŽanr: " + zanr + "\nJeste li zadovoljni sa svojim odabirom(Y za da):");
            uvjet = scan.nextLine().toUpperCase().charAt(0);
            if (uvjet == 'Y') {
                if (autor.isBlank() || naslov.isBlank() || zanr.isBlank()) {
                    System.out.println("Unos ne smije biti prazan!");
                }
                else {
                    return new Knjiga(autor,naslov,zanr);
                }
            }
        }
    }

    public static void brisanjeKnjige(ArrayList<Knjiga> listaSKnjigama){

        Scanner scan = new Scanner(System.in);
        boolean found = false;
        System.out.println("Unesite id knjige za brisanje: ");
        try{
            int id = scan.nextInt();
            for(Knjiga k: listaSKnjigama){
                if(k.getId() == id){
                    System.out.println("Knjiga je nađena!");
                    k.dodajURed((id));
                    listaSKnjigama.remove(k);
                    found = true;
                    break;
                }
            }
            if (found){
                System.out.println("Knjiga je izbrisana!");
            }
        }catch (Exception ex){
            System.out.println("Unijeli ste ne važeći id!");
        }
    }

    public static void dodajKorisnika(ArrayList<Osoba> popisOsoba){
        Scanner scan =  new Scanner(System.in);

        System.out.println("Unesi ime i prezime korisnika:");
        String ime,prezime;
        ime = scan.nextLine();
        prezime = scan.nextLine();

        popisOsoba.add(Osoba.kreirajOsobu(ime,prezime,'k'));
    }

    public static void brisanjeKorisnika(ArrayList<Osoba> popisOsoba){

        Scanner scan = new Scanner(System.in);
        boolean found = false;
        System.out.println("Unesite id osobe za brisanje: ");
        try{
            int id = scan.nextInt();
            for(Osoba osoba: popisOsoba){
                if(osoba.getId() == id){
                    System.out.println("Osoba je nađena!");
                    osoba.dodajURed((id));
                    popisOsoba.remove(osoba);
                    found = true;
                    break;
                }
            }
            if (found){
                System.out.println("Osoba je izbrisana!");
            }
        }catch (Exception ex){
            System.out.println("Unijeli ste ne važeći id!");
        }
    }


}
