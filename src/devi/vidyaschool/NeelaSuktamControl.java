package devi.vidyaschool;

import java.util.ArrayList;

import android.app.Activity;

import devi.vidyaschool.R;

public class NeelaSuktamControl {
	private Activity activity;
	private ArrayList <String> neelaSuktamLyrics;
	private ArrayList <String> audioLines;
	public NeelaSuktamControl(Activity activity){
		this.activity = activity;
		initializeNeelaSuktamLyrics();
		initializeAudio();
	}
	
	private void initializeNeelaSuktamLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.neela_suktam_lines_all);
		neelaSuktamLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			neelaSuktamLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 0; i < neelaSuktamLyrics.size(); i++){
			audioLines.add("neela_suktam_" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return neelaSuktamLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}