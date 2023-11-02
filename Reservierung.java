
/**
 * Décrivez votre classe Reservierung ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Reservierung
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String bemerkung;
    private Uhrzeit begin;
    private Uhrzeit ende;
    private Mitarbeiter mitarbeiter;
    private Raum raum;
    private static Reservierung reservierung;
    
    public Reservierung(Uhrzeit begin ,Uhrzeit ende) {
        uhrzeitValidierung(begin,ende);
        
        this.begin=begin;
        this.ende=ende;
        this.raum=raum;
        this.mitarbeiter=mitarbeiter;
        this.bemerkung=bemerkung;
        
    }
    public void uhrzeitValidierung(Uhrzeit begin,Uhrzeit ende) {
        if (begin.getValueMinute()>ende.getValueMinute()) {
           
                 throw new IllegalArgumentException(" die begin der reservierung muss vor deren ende erfolgen");
             }
        
    }
    public Uhrzeit geBegin() {
        return this.begin;
    }
    public Uhrzeit getEnde() {
        return this.ende;
    }
    public Mitarbeiter getMitarbeiter() {
        return this.mitarbeiter;
    }
    public String getBemerkung() {
        return this.bemerkung;
    }
    public Raum getRaum() {
        return this.raum;
    }
    public void setBegin(Uhrzeit begin) {
        this.begin=begin;
    }
    public void setRaum(Raum raum) {
        this.raum=raum;
    }
    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter=mitarbeiter;
    }
    public void setEnde(Uhrzeit ende) {
        this.ende=ende;
    }
    public void setBemerkung(String bemerkung) {
        stringValidierung(bemerkung);
        this.bemerkung=bemerkung;
    }
    public  void stringValidierung(String bezeichnung) {
        if(bezeichnung.strip().isEmpty()) {
            throw new IllegalArgumentException(" die Bemerkung muss nicht leer sein");
        }
    }
    
    
    public String toString() {
        return " gebucht  vom " + mitarbeiter +  begin + " Uhr bis " + ende + " Uhr für: " + bemerkung;
    }
    

    
}

