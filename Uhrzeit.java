
/**
 * Décrivez votre classe Uhrzeit ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Uhrzeit
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int stunde;
    private int minute;
    public Uhrzeit(int stunde,int minute) {
        intValidierung(minute);
        intValidierung(stunde);
        stundenValidierung(stunde);
        minutenValidierung(minute);
        this.minute=minute;
        this.stunde=stunde;
    }
    public int getMinute() {
        return this.minute;
    }
    public int getStunde() {
        return this.stunde;
    }
    public void setMinute(int minute) {
        this.minute=minute;
    }
    public void setStunde(int stunde) {
        this.stunde=stunde;
    }
    public String toString() {
        return stunde + " : " + minute;
    }
    public int getValueMinute() {
        if (getStunde()==0) {
            return 24*60+getMinute();
        }
        return getStunde()*60+getMinute();
    }
    
        public void intValidierung(int bezeichnung) {
            if((bezeichnung<0)&& ((Object)bezeichnung).getClass().getSimpleName()!="Integer"){
                throw new IllegalArgumentException("stunde und minute muss positiv sein und groesser als null !!");
            
        }
    
    }
    public void stundenValidierung(int stunde ) {
        if(!((stunde>=0) && (stunde<=24))) {
            throw new IllegalArgumentException(" Bitte beachten sie dass die stundenformat muss genauso aussehen( 00,01,02,13 .... Uhr) mit zwei ziffern!! ");
            
        }
        
        
    }
        public void minutenValidierung(int minute) {
             if(!((minute>=0) && (minute<=59))) {
            
            throw new IllegalArgumentException(" Bitte beachten sie dass die minutenformat muss genauso aussehen( 00,01,02,13 .... minute) mit zwei ziffern!! ");
            
        }
            
        }

        
    

    

    
}
