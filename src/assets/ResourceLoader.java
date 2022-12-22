package assets;

import java.io.File;
import javafx.scene.image.Image;

public class ResourceLoader {
	static ResourceLoader resourceLoader = new ResourceLoader();
	static File TRACKS_DIRECTORY;
	public static File[] TRACKLIST;
	
	ResourceLoader() {
		TRACKS_DIRECTORY = new File("assets/music");
		TRACKLIST = getTracklist();
	}
	
	public static Image getImage(String filename) {
		return new Image(resourceLoader.getClass().getClassLoader().getResource("assets/images/" + filename).toString());
	}
	
	public static String getTrack(int track_num) {
		String trackDirectory = TRACKLIST[track_num].toString();
		String trackname = trackDirectory.substring(trackDirectory.lastIndexOf("\\") + 1, trackDirectory.length());
		
		return resourceLoader.getClass().getClassLoader().getResource("assets/music/" + trackname).toString();
	}
	
	private static File[] getTracklist() {
        return TRACKS_DIRECTORY.listFiles();
	}
}
