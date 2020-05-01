public class Listen_Programm {

    public static void main (String [] args) {

        boolean x = 'a' < 'b';
    
        System.out.println(x);
    
        Liste l = new Liste ();
        
        l.fuegeVorneEin (30);
        l.fuegeVorneEin (25);
        l.fuegeVorneEin (17);
        l.fuegeVorneEin  (4);
        
        l.drucke ();
        l.druckeRueckwaerts ();
            
        l.fuegeSortiertEin (28);
        l.fuegeSortiertEin (12);
        l.fuegeSortiertEin (45);
        l.fuegeSortiertEin (2);
    
        l.drucke ();
    
        if  (l.suche (17)  != null) System.out.println (l.suche(17));
        else                        System.out.println ("17 ist nicht in der Liste");   
    
        if  (l.suche (10) != null)  System.out.println (l.suche(10));
        else                        System.out.println ("10 ist nicht in der Liste");   
            
        l.loesche (28);
        l.loesche (10);
        l.loesche (17);
    
        l.drucke ();
    
        l.loesche ();
        l.drucke ();
    
    }

}
