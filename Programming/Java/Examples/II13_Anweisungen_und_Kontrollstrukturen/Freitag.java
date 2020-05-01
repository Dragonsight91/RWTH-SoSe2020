public class Freitag {

    public static void main (String[] args) {
        
        int wochentag = SimpleIO.getInt ("Gib letzten Wochentag des Vorjahres ein");
        
        int schalttag = SimpleIO.getInt ("Gib 1 ein, falls Schaltjahr, sonst 0: ");

        monatsschleife: 
        for (int monat = 1; monat <= 12; monat++) {
          
            tagesschleife: 
            for (int tag = 1; tag <= 31; tag++) {
              
                //Wenn es tag nicht gibt, dann breche tagesschleife ab
        
                switch (monat) {
                    case 2 : if (tag > 28 + schalttag) continue monatsschleife;
                    case 4: case 6: case 9: case 11:
                    if (tag > 30) continue monatsschleife; 
                }
        
                wochentag = wochentag % 7 + 1; // naechster wochentag

                if (tag != 13) continue tagesschleife; // Wenn tag kein 13., dann neuer tag
    
                // Wenn es ein Freitag ist, dann gib das Datum aus
                if (wochentag == 5) System.out.println ("Freitag, der 13. " + monat + ".");
            
                if (monat == 12) break monatsschleife; // Abbruch nach dem 13. 12.

            }
        }
        
    }
}
