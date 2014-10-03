package devi.vidyaschool;

import java.util.ArrayList;

import devi.vidyaschool.R;

import android.app.Activity;

public class SriSuktamControl {
	private Activity activity;
	private ArrayList <String> sriSuktamLyrics;
	private ArrayList <String> audioLines;
	public SriSuktamControl(Activity activity){
		this.activity = activity;
		initializeSriSuktamLyrics();
		initializeAudio();
	}
	
	private void initializeSriSuktamLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.sri_suktam_lines_all);
		sriSuktamLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			sriSuktamLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 0; i < sriSuktamLyrics.size(); i++){
			audioLines.add("sri_sooktam_" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return sriSuktamLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}
