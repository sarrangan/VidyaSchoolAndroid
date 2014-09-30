package devi.vidyaschool;

import java.util.ArrayList;

import android.app.Activity;

import devi.vidyaschool.R;

public class PurushaSuktamControl {
	private Activity activity;
	private ArrayList <String> purushaSuktamLyrics;
	private ArrayList <String> audioLines;
	public PurushaSuktamControl(Activity activity){
		this.activity = activity;
		initializePurushaSuktamLyrics();
		initializeAudio();
	}
	
	private void initializePurushaSuktamLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.purusha_suktam_lines_all);
		purushaSuktamLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			purushaSuktamLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 1; i <= purushaSuktamLyrics.size(); i++){
			audioLines.add("purusha_suktam" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return purushaSuktamLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}
