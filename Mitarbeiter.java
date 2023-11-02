
/**
 * Décrivez votre classe Mitarbeiter ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Mitarbeiter extends Person
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String email;
   
    protected Raum raum;
    public int anzahlreservierung;
    private static final  int max=100;
   protected Reservierung []reservierung1 = new Reservierung[max];
    
   public Mitarbeiter (String vorname, String nachname,String email) {
       
       super(vorname , nachname);
        emailValidierung(email);
       this.email= email;
       this.anzahlreservierung=0;
    }
    public String getEmail() {
        return this.email;
        
    }
    public void reserviere(Raum raum , Uhrzeit begin ,Uhrzeit ende,String bemerkung) {
        stringValidierung(bemerkung);
        Reservierung reservierung=new Reservierung( begin , ende);
        reservierung.setMitarbeiter(this);
        reservierung.setBemerkung(bemerkung);
        reservierung.setRaum(raum);
        raum.addReservierung(reservierung);
        addReservierung1(reservierung);
        
        
        
       }
    public void addReservierung1(Reservierung reservierung) {
        if (reservierung == null) {
            throw new IllegalArgumentException("MSG_PATIENT_DARF_NICHT_NULL_SEIN" );
        }
        
        if (anzahlreservierung == reservierung1.length) {
            throw new IllegalArgumentException("MSG_KEINE_PLATZ_WARTESCHLANGE");
        }
        reservierung1[anzahlreservierung]=reservierung;
        anzahlreservierung++;
    }
    public void setEmail(String email) {
        emailValidierung(email);
        
        this.email=email;
        
    }
    public void emailValidierung( String email) {
        if ((!(email.contains("@")))){
            throw new IllegalArgumentException("diese email ist nicht gülitig");
        }
    }
    
    
        
        
    
    
    public String toString() {
        return  super.getVorname() + " " + super.getNachname() + " ( " +  email + ") ";
    }
    
}
