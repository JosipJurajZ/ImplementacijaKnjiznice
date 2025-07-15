# Knjiznica

Implementacija sustava za upravljanje knjižnicom
Kao administrator knjižnice, želim imati funkcionalan sustav za upravljanje knjigama, korisnicima i zaposlenicima kako bih olakšao rad knjižnice i omogućio korisnicima jednostavno posuđivanje knjiga.
________________________________________
Zadatak 1: Upravljanje knjigama
Kao zaposlenik knjižnice,
želim dodavati, pregledavati, pretraživati, uređivati i uklanjati knjige iz sustava,
tako da mogu održavati točan popis knjiga i njihove dostupnosti.
Funkcionalnosti:
1.	Implementirati klasu Knjiga s atributima (id, naslov, autor, žanr, dostupna).
2.	Dodati metodu promijeniDostupnost() u klasu Knjiga.
3.	Napraviti funkcionalnost za dodavanje knjiga u knjižnicu.
4.	Implementirati pretragu knjiga prema naslovu, autoru ili žanru.
5.	Kreirati funkcionalnost za uređivanje informacija o knjizi.
6.	Implementirati uklanjanje knjige prema njenom ID-u.
________________________________________
Zadatak 2: Upravljanje korisnicima
Kao administrator knjižnice,
želim registrirati korisnike, pregledavati njihove podatke i pratiti posuđene knjige,
tako da mogu upravljati korisnicima i njihovim interakcijama sa sustavom.
Taskovi:
1.	Napraviti apstraktnu klasu Osoba s atributima (ime, prezime, id) i apstraktnom metodom prikaziDetalje().
2.	Implementirati klasu Korisnik koja nasljeđuje Osoba i ima dodatne atribute:
o	maxBrojKnjiga
o	posuđeneKnjige (niz objekata Knjiga).
3.	Implementirati funkcionalnost za dodavanje novih korisnika u sustav.
4.	Implementirati funkcionalnost za uklanjanje korisnika iz sustava prema njihovom ID-u.
5.	Kreirati prikaz detalja o korisnicima (uključujući njihovu povijest posudbi).
________________________________________
Zadatak 3: Upravljanje zaposlenicima
Kao zaposlenik knjižnice,
želim dodavati nove knjige i uklanjati stare,
tako da mogu upravljati inventarom knjižnice.
Taskovi:
1.	Implementirati klasu ZaposlenikBiblioteke koja nasljeđuje Osoba.
2.	Dodati metode u klasu ZaposlenikBiblioteke:
o	dodajKnjigu(Knjiga knjiga)
o	ukloniKnjigu(int id).
3.	Omogućiti unos podataka o zaposleniku i njihovo pohranjivanje u sustav.
________________________________________
Zadatak 4: Posudba knjiga
Kao korisnik knjižnice,
želim posuditi knjigu ako je dostupna,
tako da mogu uživati u čitanju knjiga iz knjižnice.
Taskovi:
1.	Implementirati metodu za provjeru dostupnosti knjige.
2.	Kreirati funkcionalnost za dodavanje knjige u popis posuđenih knjiga korisnika.
3.	Implementirati ograničenje posudbe na maksimalan broj knjiga.
4.	Dodati iznimku KnjigaNijeDostupnaException i integrirati je u sustav.
5.	Dodati iznimku PremašenLimitPosudbiException i integrirati je u sustav.
________________________________________
Zadatak 5: Vraćanje knjiga
Kao korisnik knjižnice,
želim vratiti knjigu koju sam posudio,
tako da mogu osloboditi mjesto za nove posudbe.
Taskovi:
1.	Kreirati funkcionalnost za vraćanje knjiga (uklanjanje iz popisa posuđenih knjiga korisnika).
2.	Ažurirati dostupnost knjige nakon vraćanja.
________________________________________
Zadatak 6: Generiranje izvještaja
Kao administrator knjižnice,
želim generirati izvještaje o knjigama i korisnicima,
tako da mogu pratiti posudbe i upravljati resursima knjižnice.
Taskovi:
1.	Implementirati izvještaj o najposuđivanijim knjigama.
2.	Implementirati izvještaj o korisnicima s najviše posuđenih knjiga.
3.	Implementirati izvještaj o trenutno nedostupnim knjigama.
________________________________________
User Story 7: Pretraga i sortiranje
Kao korisnik knjižnice,
želim pretraživati i sortirati knjige po naslovu, autoru ili žanru,
tako da mogu brzo pronaći knjige koje me zanimaju.
Taskovi:
1.	Implementirati pretragu knjiga prema ključnim atributima (naslov, autor, žanr).
2.	Implementirati sortiranje knjiga prema naslovu, autoru i žanru.
________________________________________
Dodatni zadaci za izazov
•	Dodaj funkcionalnost za automatsku dodjelu ID-a knjigama i korisnicima.
•	Omogući spremanje i učitavanje podataka iz datoteka (npr. pomoću serijalizacije).
•	Kreiraj sustav za autentifikaciju korisnika (korisničko ime i lozinka za zaposlenike i korisnike).

