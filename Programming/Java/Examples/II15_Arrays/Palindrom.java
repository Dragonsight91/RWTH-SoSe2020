public class Palindrom{

    public static void main (String [] args) {

        char [] wort = args[0].toCharArray();
        boolean palindrom = true;
    
        for (int i = 0; i <= (wort.length - 2) / 2 && palindrom; i++)
            palindrom = wort [i] == wort [wort.length - 1 - i];

        System.out.println(palindrom);
    
    }
    
}

