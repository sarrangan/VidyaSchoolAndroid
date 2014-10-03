package devi.vidyaschool;

import java.util.ArrayList;

import android.app.Activity;

import devi.vidyaschool.R;

public class MedhaSuktamControl {
	private Activity activity;
	private ArrayList <String> medhaSuktamLyrics;
	private ArrayList <String> audioLines;
	public MedhaSuktamControl(Activity activity){
		this.activity = activity;
		initializeMedhaSuktamLyrics();
		initializeAudio();
	}
	
	private void initializeMedhaSuktamLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.medha_suktam_lines_all);
		medhaSuktamLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			medhaSuktamLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 0; i < medhaSuktamLyrics.size(); i++){
			audioLines.add("medha_suktam_" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return medhaSuktamLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}
