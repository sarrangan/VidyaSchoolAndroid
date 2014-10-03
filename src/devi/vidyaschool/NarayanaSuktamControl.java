package devi.vidyaschool;

import java.util.ArrayList;

import android.app.Activity;

import devi.vidyaschool.R;

public class NarayanaSuktamControl {
	private Activity activity;
	private ArrayList <String> narayanaSuktamLyrics;
	private ArrayList <String> audioLines;
	public NarayanaSuktamControl(Activity activity){
		this.activity = activity;
		initializeNarayanaSuktamLyrics();
		initializeAudio();
	}
	
	private void initializeNarayanaSuktamLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.narayana_suktam_lines_all);
		narayanaSuktamLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			narayanaSuktamLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 0; i < narayanaSuktamLyrics.size(); i++){
			audioLines.add("narayana_suktam_" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return narayanaSuktamLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}
