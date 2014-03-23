package ohtuesimerkki;

public class Main {
    public static void main(String[] args) {

	    Statistics stats = new Statistics( new PlayerReader("http://nhlstats-2013-14.herokuapp.com/players.txt") );
          
        System.out.println("Philadelphia Flyers");
        for (Player player : stats.team("PHI") ) {
            System.out.println( player );
        }
        
        System.out.println("");
        
        System.out.println("Top scorers");
        for (Player player : stats.topScorers(10) ) {
            System.out.println( player );
        }
    }
}


/*

Ohjelma koostuu kolmesta luokasta.

    Statistics tarjoaa metodit yhden pelaajan tietojen näyttämiseen, pistepörssin näyttämiseen ja yhden joukkueen pelaajien tietojen näyttämiseen
    Player on luokka, jonka olioina Statistics käsittelee yksittäisen pelaajan tietoja
    PlayerReader on luokka, jonka avulla ohjelma käy hakemassa pelaajien tiedot internetistä

Ohjelma on nyt ikävästi struktoroitu ja esim. yksikkötestaus on kovin hankalaa

*/