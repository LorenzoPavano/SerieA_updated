import java.util.Arrays;

public class Classifica {

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

    private Squadra[] classificaSerieA;

    public Classifica() {
        this.classificaSerieA = new Squadra[20];
    }
    
    

    public void insertSquadra(Squadra squadra) {
    	
        for (int i = 0; i < classificaSerieA.length; i++) {
        	
            if(squadra !=null && classificaSerieA[i] == null){
            	int j = 0;            	
                while (j < i && i >= 1) {        //verifichiamo che la squadra non sia già presente con il while              
                    if(classificaSerieA[j].equals(squadra)){
                        System.out.println("Impossibile eseguire il comando: la squadra gia' presente");
                        return;
                    } 
                j++;   
                }
                                
                classificaSerieA[i] = squadra;   //inseriamo la squadra
                return;
            }
        }
        
        System.out.println("Impossibile eseguire il comando: tutte le squadre inserite");
    }
    
    
    

    public Integer[] esitoPartita(Squadra squadraCasa, Integer golSquadraCasa, Squadra squadraOspite, Integer golSquadraOspite) {

        if(squadraCasa == null || squadraOspite ==null || golSquadraCasa == null || golSquadraOspite == null){
            System.out.println("--Errore di inserimento--");
            return null;
        }
        
        boolean check1 = false;      // Spiegazione sotto
        boolean check2 = false;
        Integer punteggioSquadraCasa = 0;
        Integer punteggioSquadraOspite = 0;
        Integer[] esitoPartita = new Integer[2];
                                                          //Aggiorno i valori delle Squadre in base ai gol
        if (golSquadraCasa > golSquadraOspite) {
        	
            punteggioSquadraCasa = 3;
            for (Squadra squadra : classificaSerieA) {
                if (squadra !=null && squadra.equals(squadraCasa)) {
                    check1 = true;
                    squadra.setGolFatti(squadra.getGolFatti() + golSquadraCasa);
                    squadra.setGolSubiti(squadra.getGolSubiti() + golSquadraOspite);
                    squadra.setPunteggio(squadra.getPunteggio() + punteggioSquadraCasa);
                }
                if (squadra != null && squadra.equals(squadraOspite)) {
                    check2 = true;
                    squadra.setGolFatti(squadra.getGolFatti() + golSquadraOspite);
                    squadra.setGolSubiti(squadra.getGolSubiti() + golSquadraCasa);
                }
                if(check1&&check2)                        //Posso uscire dal ciclo for, i valori sono aggiornati
                	break;
            }
        } else if (golSquadraOspite > golSquadraCasa) {
        	
            punteggioSquadraOspite = 3;
            for (Squadra squadra : classificaSerieA) {
                if (squadra != null && squadra.equals(squadraOspite)) {
                    check1 = true;
                    squadra.setGolFatti(squadra.getGolFatti() + golSquadraOspite);
                    squadra.setGolSubiti(squadra.getGolSubiti() + golSquadraCasa);
                    squadra.setPunteggio(squadra.getPunteggio() + punteggioSquadraOspite);
                }
                if (squadra != null && squadra.equals(squadraCasa)) {
                    check2 = true;
                    squadra.setGolFatti(squadra.getGolFatti() + golSquadraCasa);
                    squadra.setGolSubiti(squadra.getGolSubiti() + golSquadraOspite);
                }
                if(check1&check2)
                	break;
            }
        } else {
        	
            punteggioSquadraCasa = 1;
            punteggioSquadraOspite = 1;
            for (Squadra squadra : classificaSerieA) {
                if (squadra != null && squadra.equals(squadraCasa)) {
                    check1 = true;
                    squadra.setGolFatti(squadra.getGolFatti() + golSquadraCasa);
                    squadra.setGolSubiti(squadra.getGolSubiti() + golSquadraOspite);
                    squadra.setPunteggio(squadra.getPunteggio() + punteggioSquadraCasa);
                }
                if (squadra != null && squadra.equals(squadraOspite)) {
                    check2 = true;
                    squadra.setGolFatti(squadra.getGolFatti() + golSquadraOspite);
                    squadra.setGolSubiti(squadra.getGolSubiti() + golSquadraCasa);
                    squadra.setPunteggio(squadra.getPunteggio() + punteggioSquadraOspite);
                }
                if(check1&check2)
                	break;
            }
        }
                 
        if(check1 && check2){               //Check se le squadre sono presenti nella Classifica, else risetto i valori
        	                                //Può succedere che una squadra è presente e l'altra non è presente nella Classifica
        	                                          
            esitoPartita[0] = punteggioSquadraCasa;
            esitoPartita[1] = punteggioSquadraOspite;
            System.out.println("Esito Partita: [Punteggio Squadra in casa, Punteggio squadra ospite]");
            return esitoPartita;
            
        }        
        else{                               //Devo risettare i valori perchè può succedere che una squadra si aggiorna e l'altra no,perchè non è in Classifica
        	                               
            for (Squadra squadra : classificaSerieA) {
                if(squadra != null && squadra.equals(squadraCasa)){
                    squadra.setGolFatti(squadra.getGolFatti() - golSquadraCasa);
                    squadra.setGolSubiti(squadra.getGolSubiti() - golSquadraOspite);
                    squadra.setPunteggio(squadra.getPunteggio() - punteggioSquadraCasa);
                }
                if(squadra != null && squadra.equals(squadraOspite)){
                    squadra.setGolFatti(squadra.getGolFatti() - golSquadraOspite);
                    squadra.setGolSubiti(squadra.getGolSubiti() - golSquadraCasa);
                    squadra.setPunteggio(squadra.getPunteggio() - punteggioSquadraOspite);
                }
            }
            
            System.out.println("Impossibile eseguire il comando: Almeno Una delle Squadre non e' presente nella Classifica");
            return null;

        }
    }
    
    
    

    public void ordinaClassificaSerieA() {
    	
        //writecode oppure usare compareto per ordinamento
        //scegliamo ordinamento manuale
    	
        Squadra squadraProvvisoria;
        int count;
        
        for (int i = 1; i < classificaSerieA.length; i++) {
            if(classificaSerieA[i] != null){
                count = 0;
                for (int j = i - 1; j >= 0 && count < classificaSerieA.length - 1; j--) {
                    if(classificaSerieA[i - count].getPunteggio() > classificaSerieA[j].getPunteggio()){
                        squadraProvvisoria = classificaSerieA[j];
                        classificaSerieA[j] = classificaSerieA[i- count];
                        classificaSerieA[i - count] = squadraProvvisoria;
                        count++;                    //con il count scorriamo l'array Classifica dall'ultima posizione alle precedenti per ordinare
                    }
                }
            }
        }
    }
    
    
    

    public Squadra[] getClassificaSerieA() {
        return classificaSerieA;
    }   
    
    
    

    public Squadra getMigliorAttacco() {
    	
        Squadra squadraMigliorAttacco = classificaSerieA[0];
        for (int i = 1; i < classificaSerieA.length; i++) {
        	
            Squadra squadra = classificaSerieA[i];
            if (squadra != null && squadra.getGolFatti() > squadraMigliorAttacco.getGolFatti()) {
                squadraMigliorAttacco = squadra;
            }
        }
        return squadraMigliorAttacco;
    }
    
    
    

    public Squadra getPeggiorDifesa() {
    	
        Squadra squadraPeggiorDifesa = classificaSerieA[19];

        // assegniamo un valore non Null con il seguente ciclo
        
        for (int i = classificaSerieA.length - 1; i >= 0 ; i--) {   
        	
            if(classificaSerieA[i] != null){
                squadraPeggiorDifesa = classificaSerieA[i];
                break;
            }
        }
        
        for (int i = classificaSerieA.length - 2; i >= 0; i--) {
        	
            Squadra squadra = classificaSerieA[i];
            if (squadra != null && squadra.getGolSubiti() > squadraPeggiorDifesa.getGolSubiti()) {
                squadraPeggiorDifesa = squadra;
            }
        }
        return squadraPeggiorDifesa;
    }

    
    
    

    @Override
    public String toString() {
        return "Classifica{" +
                "classificaSerieA=" + Arrays.toString(classificaSerieA) +
                '}';
    }
}
