import java.util.Arrays;

public class Main {
	

    /*Esercizio Classifica Serie a 🏍

    Progettare una classe Classifica che permetta di gestire la classifica di Serie A costruita a partire da
 20 squadre di calcio. Ogni squadra di calcio ha i seguenti attributi:

            - id
- nome
- rosa di giocatori
- punteggio
- gol fatti
- gol subiti

    Ogni giocatore ha un id, un nome e un cognome.
    In particolare, deve essere possibile gestire le seguenti operazioni:

            - esitoPartita(squadraCasa, golCasa, squadraOspite, golOspite): gestisce il punteggio delle due squadre
    in base all'esito
            - getClassifica(): ritorna la classifica attuale, ordinata per punteggio
- getMigliorAttacco(): ritorna la squadra che ha segnato più gol
- getPeggiorDifesa(): ritorna la squadra che ha concesso più gol*/

	

    static Giocatore Zanetti = new Giocatore("Javier","Zanetti");
    static Giocatore Sanchez = new Giocatore("Alex","Sanchez");
    static Giocatore Barella = new Giocatore("Nicolo'","Barella");
    static Giocatore Vidal = new Giocatore("Arturo","Vidal");
    static Giocatore Correa = new Giocatore("Joaquin","Correa");
    static Giocatore Damian = new Giocatore("Matteo","Damian");

    static Squadra inter =new Squadra("Inter");

    public static void main(String[] args) {
        inter.insertGiocatore(Zanetti);
        inter.insertGiocatore(Sanchez);
        inter.insertGiocatore(Sanchez);
        inter.insertGiocatore(null);
        inter.insertGiocatore(Zanetti);
        inter.insertGiocatore(Barella);
        inter.insertGiocatore(Vidal);
        inter.insertGiocatore(Correa);
        inter.insertGiocatore(Damian);
        System.out.println(inter.getRosaGiocatori());
        Giocatore Bastoni = new Giocatore("Alessandro","Bastoni");
        inter.insertGiocatore(Bastoni);
        Giocatore Casadei = new Giocatore("Cesare","Casadei");
        inter.insertGiocatore(Casadei);
        System.out.println(inter);

        Classifica classificaSerieA = new Classifica();
        classificaSerieA.insertSquadra(inter);
        System.out.println(classificaSerieA);
        Squadra Juventus = new Squadra("Juventus");
        
        System.out.println(Arrays.toString(classificaSerieA.esitoPartita(inter, 3, Juventus, 2)));

        //Controllo che inserendo la Juventus nella classifica posso usare il metodo esito partita
        classificaSerieA.insertSquadra(Juventus);
        System.out.println(classificaSerieA);
        System.out.println(Arrays.toString(classificaSerieA.esitoPartita(inter, 2, Juventus, 1)));

        //Controllo che la classifica è aggiornata dopo la partita
        System.out.println(classificaSerieA);
        System.out.println(Juventus.getRosaGiocatori());
        System.out.println(Juventus.getGolSubiti());
        System.out.println(inter.getPunteggio());

        //Faccio un'altra partita e controllo la classifica
        System.out.println(Arrays.toString(classificaSerieA.esitoPartita(Juventus, 1, inter, 1)));
        System.out.println(classificaSerieA);


        Squadra empoli = new Squadra("Empoli");
        empoli.setPunteggio(10);
        classificaSerieA.insertSquadra(empoli);
        //Controllo che la classifica è ordinata ma non lo è, infatti c'è un metodo per ordinare ma non l'ho richiamato ancora
        System.out.println(classificaSerieA);

        System.out.println(classificaSerieA.getMigliorAttacco());
        System.out.println(classificaSerieA.getPeggiorDifesa());

        //Ordino la classifica e controllo
        classificaSerieA.ordinaClassificaSerieA();
        System.out.println(classificaSerieA);

        //Inserisco il catania con punteggio 5, deve essere seconda
        Squadra catania = new Squadra("Catania");
        catania.setPunteggio(5);
        classificaSerieA.insertSquadra(catania);
        classificaSerieA.ordinaClassificaSerieA();
        System.out.println(classificaSerieA);

        //Faccio un'altra partita
        System.out.println(Arrays.toString(classificaSerieA.esitoPartita(catania, 3, inter, 1)));

        System.out.println(catania.getGolFatti());
        classificaSerieA.ordinaClassificaSerieA();
        System.out.println(classificaSerieA);



    }




}
