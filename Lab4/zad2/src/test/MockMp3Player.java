package test;

import java.util.ArrayList;

public class MockMp3Player implements Mp3Player {

	private ArrayList songs;
	private int idCurrentSong = 0;
	private int timeCurrentSong = 0;
	private boolean songIsPlayed = false;
	
	@Override
	public void play() {
		if (songs != null) {
			timeCurrentSong = 1;
			songIsPlayed = true;
		}
	}

	@Override
	public void pause() {
		songIsPlayed = false;
	}

	@Override
	public void stop() {
		timeCurrentSong = 0;
		songIsPlayed = false;
	}

	@Override
	public double currentPosition() {
		return timeCurrentSong;
	}

	@Override
	public String currentSong() {
		if (songs == null)
			return null;
		return (String) songs.get(idCurrentSong);
	}

	@Override
	public void next() {
		if (idCurrentSong == (songs.size()-1))
			idCurrentSong = 0;
		else
			idCurrentSong++;
		timeCurrentSong = 0;
		play();
	}

	@Override
	public void prev() {
		if (idCurrentSong != 0)
			idCurrentSong--;
		timeCurrentSong = 0;
		play();
	}

	@Override
	public boolean isPlaying() {
		return songIsPlayed;
	}

	@Override
	public void loadSongs(ArrayList names) {
		songs = names;
	}
}
