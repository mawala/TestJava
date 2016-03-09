package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class TestMp3Player {
	private Mp3Player mp3;
	private ArrayList list = new ArrayList();
	
	private static double EPSILON = 1E-15;

	@Before
	public void setUp() {
		mp3 = new MockMp3Player();
		list = new ArrayList();
		list.add("Bill Chase -- Open Up Wide");
		list.add("Jethro Tull -- Locomotive Breath");
		list.add("The Boomtown Rats -- Monday");
		list.add("Carl Orff -- O Fortuna");
	}

	@Test
	public void testPlay() {
		mp3.loadSongs(list);
		// Assercja
		assertNotNull(mp3.currentSong());
		
		mp3.play();
		// Assercje
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), EPSILON);
		assertTrue(mp3.isPlaying());
		
		mp3.pause();
		// Assercje
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), EPSILON);
		assertFalse(mp3.isPlaying());
		
		mp3.stop();
		// Assercje
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), EPSILON);
		assertFalse(mp3.isPlaying());
	}

	@Test
	public void testPlayNoList() {
		// Assercja
		assertNull(mp3.currentSong());
		
		mp3.play();
		// Assercje
		assertNull(mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), EPSILON);
		assertFalse(mp3.isPlaying());
		
		mp3.pause();
		// Assercje
		assertNull(mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), EPSILON);
		assertFalse(mp3.isPlaying());
		
		mp3.stop();
		// Assercje
		assertNull(mp3.currentSong());
		assertEquals(0, mp3.currentPosition(), EPSILON);
		assertFalse(mp3.isPlaying());
	}

	@Test
	public void testAdvance() {
		mp3.loadSongs(list);
		mp3.play();
		// Assercje
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), EPSILON);
		assertTrue(mp3.isPlaying());
		
		mp3.prev();
		// Assercje
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), EPSILON);
		assertTrue(mp3.isPlaying());
		
		mp3.next();
		// Assercja
		assertEquals(list.get(1), mp3.currentSong());
		
		mp3.next();
		// Assercja
		assertEquals(list.get(2), mp3.currentSong());
		
		mp3.prev();
		// Assercja
		assertEquals(list.get(1), mp3.currentSong());
		
		mp3.next();
		// Assercja
		assertEquals(list.get(2), mp3.currentSong());
		
		mp3.next();
		// Assercja
		assertEquals(list.get(3), mp3.currentSong());
		
		mp3.next();
		// Assercje
		assertEquals(list.get(0), mp3.currentSong());
		assertEquals(1, mp3.currentPosition(), EPSILON);
		assertTrue(mp3.isPlaying());
	}

	@After
	public void teardown() {
		mp3 = null;
		list = null;
	}
}
