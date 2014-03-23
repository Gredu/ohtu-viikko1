package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StatisticsTest {

	Statistics stats;

	Reader readerStub = new Reader() {
		
		public List<Player> getPlayers() {
			ArrayList<Player> players = new ArrayList<Player>();
			
			players.add(new Player("Semenko", "EDM", 4, 12));
			players.add(new Player("Lemieux", "PIT", 45, 54));
			players.add(new Player("Kurri",   "EDM", 37, 53));
			players.add(new Player("Yzerman", "DET", 42, 56));
			players.add(new Player("Gretzky", "EDM", 35, 89));
			
			return players;
		}
	};

	@Before
	public void setUp() {
		this.stats = new Statistics(readerStub);
	}

	@Test
	public void teamTest() {
		List<Player> tiimit = stats.team("EDM");
		ArrayList<Player> oikeaTiimi = new ArrayList<Player>();
		oikeaTiimi.add(new Player("Semenko", "EDM", 4, 12));
		oikeaTiimi.add(new Player("Kurri",   "EDM", 37, 53));
		oikeaTiimi.add(new Player("Gretzky", "EDM", 35, 89));

		// assertEquals(tiimit, oikeaTiimi);		// miksi tämä ei toimi?

		assertEquals(tiimit.get(0).getName(), oikeaTiimi.get(0).getName());
		assertEquals(tiimit.get(1).getName(), oikeaTiimi.get(1).getName());
		assertEquals(tiimit.get(2).getName(), oikeaTiimi.get(2).getName());
	}

	@Test
	public void topScorerTest() {
		List<Player> player = stats.topScorers(3);
		ArrayList<Player> topScorerTest = new ArrayList<Player>();
		
		topScorerTest.add(new Player("Gretzky", "EDM", 35, 89));
		topScorerTest.add(new Player("Lemieux", "PIT", 45, 54));
		topScorerTest.add(new Player("Yzerman", "DET", 42, 56));

		// assertEquals(player, topScorerTest);		// miksi tämä ei toimi?

		assertEquals(player.get(0).getName(), topScorerTest.get(0).getName());
		assertEquals(player.get(1).getName(), topScorerTest.get(1).getName());
		assertEquals(player.get(2).getName(), topScorerTest.get(2).getName());
	} 

	@Test
	public void playerSearchTest() {
		List<Player> player = stats.topScorers(3);

		Player wantedPlayer = stats.search("Yzerman");
		assertEquals(wantedPlayer.getName(), "Yzerman");

		wantedPlayer = stats.search("Gredu");
		assertEquals(wantedPlayer, null);
		
		// assertEquals(tiimit, oikeaTiimi);		// miksi tämä ei toimi?
	} 

}
