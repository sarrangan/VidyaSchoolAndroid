package devi.vidyaschool;

import java.util.ArrayList;

import android.app.Activity;

import devi.vidyaschool.R;

public class DurgaSuktamControl {
	private Activity activity;
	private ArrayList <String> durgaSuktamLyrics;
	private ArrayList <String> audioLines;
	public DurgaSuktamControl(Activity activity){
		this.activity = activity;
		initializeDurgaSuktamLyrics();
		initializeAudio();
	}
	
	private void initializeDurgaSuktamLyrics() {
		String [] lyricArray = activity.getResources().getStringArray(R.array.durga_suktam_lines_all);
		durgaSuktamLyrics = new ArrayList<String>();
		for(int i = 0; i < lyricArray.length; i++){
			durgaSuktamLyrics.add(lyricArray[i]);
		}
	}
	
	private void initializeAudio(){
		audioLines = new ArrayList<String>();
		for(int i = 0; i < durgaSuktamLyrics.size(); i++){
			audioLines.add("durga_suktam_" + i);
		}
	}
	
	public ArrayList<String> getLyrics (){
		return durgaSuktamLyrics;
	}
	
	public ArrayList<String> getAudioList(){
		return audioLines;
	}
}
