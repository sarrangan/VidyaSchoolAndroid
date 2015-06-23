package devi.vidyaschool;

import java.util.ArrayList;

import android.app.Activity;

import devi.vidyaschool.R;

public class RudramControl {
	private Activity activity;
	private ArrayList <String> rudramLyrics;
	private ArrayList <String> audioLines;
	public RudramControl(Activity activity){
		this.activity = activity;
		initializeRudramLyrics();
		initializeAudio();
	}
	
	private void initializeRudramLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.rudram_lines_all);
		rudramLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			rudramLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 0; i < rudramLyrics.size(); i++){
			audioLines.add("rudram_" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return rudramLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}
