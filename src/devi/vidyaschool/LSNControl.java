package devi.vidyaschool;

import java.util.ArrayList;

import android.app.Activity;

import devi.vidyaschool.R;

public class LSNControl {
	private Activity activity;
	private ArrayList <String> lSNLyrics;
	private ArrayList <String> audioLines;
	public LSNControl(Activity activity){
		this.activity = activity;
		initializeLSNLyrics();
		initializeAudio();
	}
	
	private void initializeLSNLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.lalitha_lines_all);
		lSNLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			lSNLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 0; i <= lSNLyrics.size(); i++){
			audioLines.add("lsn_" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return lSNLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}
