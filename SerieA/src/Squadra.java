import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Squadra implements Comparable<Squadra> {

    private UUID id;
    private String nome;
    private Giocatore[] rosaGiocatori;
    private Integer punteggio;
    private Integer golFatti;
    private Integer golSubiti;

    public Squadra(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.rosaGiocatori = new Giocatore[20];
        this.punteggio = 0;
        this.golFatti = 0;
        this.golSubiti = 0;
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRosaGiocatori() {
        return Arrays.toString(rosaGiocatori);           
    }

   
    public void insertGiocatore(Giocatore giocatore) {
    	
        if(giocatore != null){
            for (int i = 0; i < rosaGiocatori.length; i++) {            	
                if(rosaGiocatori[i] == null){
                	
                    int j = 0;
                    while (j < i && i >= 1) {       //verifichiamo che il giocatore da inserire non sia già presente nell'array, tra gli indici precedenti
                        if(rosaGiocatori[j].equals(giocatore)){
                            System.out.println("Impossibile eseguire il comando: giocatore già presente");
                            return;
                        }
                        j++;
                    }
                    
                    rosaGiocatori[i] = giocatore;   //inseriamo il giocatore nell'array rosaGiocatori
                    return;
                }
            }
        }
        System.out.println("Impossibile eseguire il comando: rosa giocatori completa");
    }



    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setGolFatti(Integer golFatti) {
        this.golFatti = golFatti;
    }

    public void setGolSubiti(Integer golSubiti) {
        this.golSubiti = golSubiti;
    }

    public Integer getGolFatti() {
        return golFatti;
    }

    public Integer getGolSubiti() {
        return golSubiti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squadra squadra = (Squadra) o;
        return Objects.equals(id, squadra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "nome='" + nome + '\'' +
                ", punteggio=" + punteggio +
                ", golFatti=" + golFatti +
                ", golSubiti=" + golSubiti +
                '}';
    }

    @Override                                                   
    public int compareTo(Squadra o) {
        return this.punteggio.compareTo(o.getPunteggio());
    }
}
