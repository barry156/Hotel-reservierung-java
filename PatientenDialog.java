

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Diese Klasse ist ein Dialog, zur Kommunikation mit dem Benutzer. Sie nimmt die Eingaben auf
 * und gibt das Ergebnisse auf dem Bildschirm aus. Dieser Dialog dient der Bestandfuehrung eines
 * warteschlange. 
 * 
 * @author Barry mamadou siradio, Naomie
 *
 */

 
public class PatientenDialog
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private static final int  Patient_NICHT_GEFUNDEN=-1;
    private Raum raum;   
    /**
     * dimension des array ,das die räume enthält
     */
    private    int maxx;
    /**
     * erzeugt ein array mit dimension maxx
     */
   protected Raum []raume = new Raum[maxx];
    private Scanner input;
    private static final int RAUM_ANLEGEN = 1;
    private static final int RESERVIERE= 2;
    private static final int HOTEL_ANLEGEN=3;
    
    private static final int RAUM_AUSGEBEN = 4;
    private static final int RESERVIERUNG_UBERSICHT = 5;
    
    
    
    private static final int ENDE = 0;
    /**
     * anzahl eingefuegene raüme in dem array
     */
    private int anzahl2;
    

    public PatientenDialog() {
        input = new Scanner(System.in);
        
        
    }
    
    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
       

        int funktion = -1;

        while (funktion != ENDE) {
            try {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                input.nextLine();

            } catch (Exception e) {
                System.out.println("Irgendeine Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Menü ausgeben und Funktion einlesen.
     * 
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        int funktion;
        System.out.print(RAUM_ANLEGEN      + ": raumanlegen\n"    + 
            RESERVIERE   + ": reserviere\n"  +
             + HOTEL_ANLEGEN +":Hotel anlegen\n"  +
            

            RAUM_AUSGEBEN + ": raum ausgeben\n" +
            RESERVIERUNG_UBERSICHT + ":reservierungubersicht\n"  +
            ENDE        + ": beenden -> ");

        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Ausführen der ausgewählten Funktion
     * 
     * @param die auszuführende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion) {
        switch(funktion) {

        case RAUM_ANLEGEN:raumAnlegen();
        break;
        case RESERVIERE  : Reserviere();
        break;
        
        case  RAUM_AUSGEBEN :raumAusgeben ();
        break;
        case  HOTEL_ANLEGEN :hotelAnlegen() ;
        break;
        case  RESERVIERUNG_UBERSICHT:reservierungUbersicht() ;
       
        }
        
    }

    /**
     * Diese Methode erlaubt uns ein raum anzulegen und speichert ihn in dem raume array
     */
    
    private void raumAnlegen() {
        if (raume.length==0) {
            throw new IllegalArgumentException("sie müssen zuerst ein hotel anlegen");
        }
        if ((anzahl2>0) &&(anzahl2==raume.length)) {
            throw new IllegalArgumentException("hotel ist voll .keine platz neu raum aufzubauen!!");
            
        }
            raum=null;
        System.out.print("gebaude");
            int geb=input.nextInt();
            System.out.print("etage");
            int etage=input.nextInt();
            System.out.print("Raum");
            int raums=input.nextInt();
            
            raum=new Raum(geb,etage,raums);
            raume[anzahl2]=raum;;
            anzahl2++;
            
        }
        public void printrRaume() {
            for(int i=0;i< raume.length;i++) {
                raum=raume[i];
                System.out.println(raum);
            }
        }
        /**
     * diese methode nimmt information von dem benutzer und reserviere ein raum
     */
        
    private void Reserviere() {
        if(anzahl2==0) {
            throw new IllegalArgumentException("sie haben keine raum aufgebaut.bitte legen Sie einen Raum und versuchen sie nochmal!!");
        }
        Reservierung reservierung=null;
        Mitarbeiter mitarbeiter=null;
         raum=null;
        
        System.out.println("begin der reservierung");
        System.out.println("stunde: ");
        int stunde = input.nextInt();
        
        System.out.println("minute: ");
        int minute=input.nextInt();
        Uhrzeit begin=new Uhrzeit(stunde,minute);
        System.out.println("Ende der reservierung: ");
        System.out.println("stunde: ");
        int stunde1 = input.nextInt();
        
        System.out.println("minute: ");
        int minute1=input.nextInt();
        Uhrzeit ende=new Uhrzeit(stunde1,minute1);
        input.nextLine();
        System.out.println("Vorname: ");
        String vorname = input.nextLine();
        System.out.println("Nachname: ");
        String nachname = input.nextLine();
        System.out.println("email: ");
        String email=input.nextLine();
        mitarbeiter = new Mitarbeiter(vorname, nachname,email);
        
        System.out.println("bemerkung: ");
        
        String bemerkung=input.nextLine();
        //System.out.println("raum");
        reservierungUbersicht();
        System.out.println("jetzt  geben sie die gebaudenummer ein .Sie können unter der oben gerade angezeigte liste auswählen");
        int geb=input.nextInt();
        System.out.println("etageNummer: ");
        int etage=input.nextInt();
        System.out.println("Raumummer: ");
        int raums=input.nextInt();
        int result=findeRaum(geb,etage,raums);
        if(result==-1) {
            System.out.println("diese Raum existiert nicht");
        }else {
             raum=raume[result];
            
            System.out.println(raum);
            
        
        mitarbeiter.reserviere(raum,begin,ende,bemerkung);
       }
}
/**
     * diese methode fragt dem benutzer welche raum er in dem bildschirm ausgeben will
     */
    public void raumAusgeben() {
        System.out.println("welche raum wollen sie ausgeben");
        System.out.println("gebaude: ");
        int geb=input.nextInt();
        System.out.println("etage: ");
        int etage=input.nextInt();
        System.out.println("Raum: ");
        int raums=input.nextInt();
        int result=findeRaum(geb,etage,raums);
        if(result==-1) {
            System.out.println("diese Raum existiert nicht");
        }else {
            System.out.println(raume[result].toString());
        
    }
}
/**
     * diese methode sucht ein raum mittels gebaude,etage und raum.
     */
    public int findeRaum(int geb,int etage,int raums) {
        for (int i = 0; i < anzahl2 ; i++) {
            Raum raum = raume[i];
            if ((raum.getGeb()==geb)&&(raum.getEtage()==etage)&&(raum.getRaum()==raums)) {
                return i;
            }
        }
        
        return Patient_NICHT_GEFUNDEN;
        
    }
    
    /**
     * Diese Methode initialisiert das hotel
     */
    private  void  hotelAnlegen() {
        
        System.out.print("Maximale Raume in Hotel: ");
        maxx  = input.nextInt();
        raume = new Raum[maxx];
        
        
        
    }
    /**
     * diese methode gibt in dem bildschirm alle reservierungen nach räumen
     */
    private void reservierungUbersicht() {
        for(int i=0;i< anzahl2;i++) {
            raum=raume[i];
            System.out.println(raum);
            }
        }
        

    /**
     * Main-Methode zum Erzeugen des KontoDialog-Objektes und zum Anstarten der
     * Testschleife
     */
    public static void main(String[] args) {
        
        new PatientenDialog().start();
         
        
    }
}