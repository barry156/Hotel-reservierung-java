
/**
 *Die klasse Patient enthält die objekte(Vorname,PatientNummer und Nachname) die,die bestandführung ermöglichen.
 *
 * @Mamadou siradio barry ,Naomi nompgang
 * @version (04/01/2021)
 */
public class Person
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String vorname;
    private String nachname;
    
    public Person(String vorname,String nachname) {
        stringValidierung(nachname);
        stringValidierung(vorname);
        this.vorname=vorname;
        this.nachname=nachname;
    }
    public String getVorname() {
        return this.vorname;
        
    }
    public String getNachname() {
        return this.nachname;
        
    }
    public void setNachname(String nachname) {
        stringValidierung(nachname);
        this.nachname=nachname;
        
    }
    public void setVorname(String vorname) {
        stringValidierung(vorname);
        this.vorname=vorname;
    }
    public String toString() {
        return vorname + " " + nachname;
    }
    public static void stringValidierung(String bezeichnung) {
        if(bezeichnung.strip().isEmpty()) {
            throw new IllegalArgumentException(" die vormame und nachname und bemerkung der Patient muss nicht leer sein");
        }
    }
    
    
}
