
/**
 * die klasse weist information über räumen die reserviert werden
 * muessen.
 *
 * @barry mamadou siradio,naomie  
 * @version (18/04.2022)
 */
public class Raum
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    Raum r;
    /**
     * Die gebaudenummer
     */
    private int geb;
    /**
     * Die etagenummer
     */
    private int etage;
    /**
     * Die raumnummer
     */
    private int raum;
    /**
     * Die anzahl eingefügter reservierungen mit diesem raum
     */
    
    public  int anzahl;
    /**
     * Die maximal reservierungen pro raum
     */
    private static final  int maxx=100;
    /**
     * array das,alle reservierungen im bezug auf diesem raum enthält
     */
   protected Reservierung []reservierunge = new Reservierung[100];
    
    private static final String MSG_KEINE_PATIENT_IN_WARTESCHLANGE = "keine patient in der warteschlange";
    private static final String MSG_PATIENT_DARF_NICHT_NULL_SEIN = "Der reservierung darf nicht null sein!";
     private static final String MSG_KEINE_PLATZ_WARTESCHLANGE="keine platz mehr in der raum.Sie dürfen nur maximal 100 reservierungen pro raum haben";
     /**
      * Erzeugt ein neuen Raum. Es gibt noch keine Reservierung. 
     * @param geb Die gebaudenummer des Raum. Muss gr&ouml;&szlig;er als 0 sein.
     * @param etage Die etagenummer,wo die raum liegt muss   gr&ouml;&szlig;er als 0 sein.
     * @param raum Die raumNummer der Raum, muss   gr&ouml;&szlig;er als 0 sein.

     */
    public Raum(int geb ,int etage, int raum) {
        intValidierung(geb);
        intValidierung(etage);
        intValidierung(raum);
        this.geb=geb;
        this.etage=etage;
        this.raum=raum;
       
        
        this.anzahl=0;
        
    }
    /**
     * Diese methode wird benutzt um die etageNummer zurückzugeben
     * @return etage;
     */
    
    
    public int getEtage() {
        return this.etage;
    }
    /**
     * Diese methode wird benutzt um die gebäudenummer zurückzugeben
     * @return geb;
     */
    public int getGeb() {
        return this.geb;
    }
    /**
     * Diese methode wird benutzt um die Raumnummer zurückzugeben
     * @return raumNummer;
     */
    public int getRaum() {
        return this.raum;
    }
    /**
     * Diese methode wird benutzt um die gebäudenummer zu setzen
     * @param geb;
     */
    public void setGeb(int geb) {
        intValidierung(geb);
        this.geb=geb;
    }
    /**
     * Diese methode wird benutzt um die etageNummer zu setzen
     * @param etage;
     */
    public void setEtage(int etage) {
        intValidierung(etage);
        this.etage=etage;
    }
    /**
     * Diese methode wird benutzt um die raumnummer zu setzen
     * @param raum;
     */
    public void setRaum(int raum) {
        intValidierung(raum);
        this.raum=raum;
    }
    /**
     * Diese methode wird genutz um die raum als String wieder zu geben
     */
    
    
    public String toString() {
        
        
        StringBuffer ausgabe = new StringBuffer();
        if (anzahl==0) {
            ausgabe.append( "Raum " + geb + "-" + etage + "." + raum);
        }
        else {
            for (int i = 0; i < anzahl ; i++)  {
                Reservierung reservierung = reservierunge[i];
                
                
                ausgabe.append("Raum " + geb + "-" + etage + "." + raum).append("\n").append(reservierung.toString());
                

            
                                    
            }
        }
        return ausgabe.toString();
    }
    /**
     * Diese methode wird genutz um die reservierungen als String wieder zu geben
     * @param index.das index der reservierungen 
     * @return reservierung als string
     */
    public String getReservierung(int index) {
        if ((anzahl>0) &&(index>=0) &&(index<anzahl)) {
      
            Reservierung reservierung = reservierunge[index];
           
                return reservierung.toString();
        
        }else {
       return "Artikel nicht gefunden";
    }
}
/**
     * Diese methode wird genutz um attributen etage,raum und geb auf gültigkeit zu prüfen
     * sie muessen groesser als null und ganzzahliger zahlen sein
     * @param bezeichnung die attribut der verarbeitet wird
     */
    

    public void intValidierung(int bezeichnung) {
        if((bezeichnung<0)&& ((Object)bezeichnung).getClass().getSimpleName()!="Integer"){
            throw new IllegalArgumentException(" raum,etage unbd gebaude muss positiv und groesser als nullssein");
        
    }
}
/**
     * Diese methode wird genutzt um neue reservierung in das array anzulegen
     * @param r(reservierung)
     */
    
    
    
    
    public void addReservierung( Reservierung r) {
        if (r == null) {
            throw new IllegalArgumentException(MSG_PATIENT_DARF_NICHT_NULL_SEIN );
        }
        
        if (anzahl == reservierunge.length) {
            throw new IllegalArgumentException(MSG_KEINE_PLATZ_WARTESCHLANGE);
        }
        reservierunge[anzahl]=r;
        anzahl++;
        
    }
    

}
