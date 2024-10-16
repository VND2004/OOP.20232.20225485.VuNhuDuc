package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	

	public String getArtist() {
		return artist;
	}
	
	public void play() {
		System.out.println("Artist: " + this.artist);
		for(Track track : tracks) {
			track.play();
		}
	}


	public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
		super(id, title, category, cost, 0, null);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track trackName) {
		if(!tracks.contains(trackName)) {
			tracks.add(trackName);
			System.out.println("The track has been added!");
		} else {
			System.out.println("Cannot add the track because it has already been added!");
		}
	}
	
	public void removeTrack(Track trackName) {
		if(tracks.contains(trackName)) {
			tracks.add(trackName);
			System.out.println("Remove " + trackName);
		} else {
			System.out.println("The " + trackName + " is not existed!");
		}
	}
	
	@Override
	public int getLength() {
		int cnt = 0;
		for(Track track : tracks) {
			cnt += track.getLength();
		}
		return cnt;
	}

}
