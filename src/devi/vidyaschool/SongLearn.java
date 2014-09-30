package devi.vidyaschool;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;

import devi.vidyaschool.R;

public class SongLearn extends ActionBarActivity {
	private final String LYRICS_TAG = "lyrical";
	private MediaPlayer audioFile;
	private CustomAdapter mAdapter;
	ArrayList<String> audioList;
	ArrayList<String> lyricsList;
	private String title;
	private AsyncTask<Void, Void, Void> playSong;
	private static boolean isReleased = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lyrics_list);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		setupScreen();
	}

	private void setupScreen() {
		Intent intent = getIntent();
		this.title = intent.getStringExtra(MainActivity.TITLE);
		setTitle(title);
		lyricsList = intent.getStringArrayListExtra(MainActivity.LYRICS_TAG);
		audioList = intent.getStringArrayListExtra(MainActivity.AUDIO_TAG);
		initializeListView(lyricsList);
		initAudio();
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		setupScreen();
	}
	
	private void initAudio() {
		if(audioFile != null){
			stopChants();
		}
		int resource = getResources().getIdentifier(audioList.get(0),
				"raw", "devi.vidyaschool");
		audioFile = MediaPlayer.create(this, resource);
	}

	private void initializeListView(ArrayList<String> suktam_lyrics) {
		ListView listView = (ListView) findViewById(R.id.lines_of_song);
		mAdapter = new CustomAdapter(this, true);
		ArrayList<HashMap<String, String>> lyrics = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < suktam_lyrics.size(); i++) {
			if(i%10 == 0 && i != 0){
				mAdapter.addSectionHeaderItem("Line " + i);
			}
			mAdapter.addItem(suktam_lyrics.get(i));
		}
		listView.setAdapter(mAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				try {
					String checkLine = ((TextView) view
							.findViewById(R.id.line_of_lyric_text)).getText()
							.toString();
				} catch (Exception e) {
					return;
				}
				if (playSong != null) {
					playSong.cancel(true);
				}
				
				startChant(adjustedPos(position));
			}
		});
		listView.setOnItemLongClickListener (new OnItemLongClickListener() {
			  public boolean onItemLongClick(AdapterView parent, View view, int position, long id) {
			    if(playSong != null){
			    	playSong.cancel(true);
			    }
			    startChantWithLooping(adjustedPos(position));
				  return true;
			  }
			});
	}

	private void startChant(int position) {
		stopChants();
		int resource = getResources().getIdentifier(audioList.get(position),
				"raw", "devi.vidyaschool");
		audioFile = MediaPlayer.create(this, resource);
		audioFile.start();
		isReleased = false;
	}
	
	private void startChantWithLooping(int position) {
		stopChants();
		int resource = getResources().getIdentifier(audioList.get(position),
				"raw", "devi.vidyaschool");
		audioFile = MediaPlayer.create(this, resource);
		audioFile.setLooping(true);
		audioFile.start();
		isReleased = false;
	}

	private void stopChants() {
		if(!isReleased){
		audioFile.stop();
		audioFile.reset();
		audioFile.release();
		isReleased = true;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.song_action_bar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_play) {
			if (playSong != null) {
				playSong.cancel(true);
			}
			stopChants();
			playSong = new playAll(this).execute();
		}
		else if(id == R.id.action_stop){
			if(playSong != null){
				playSong.cancel(true);
			}
			stopChants();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (playSong != null) {
			playSong.cancel(true);
		}
		stopChants();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	private class playAll extends AsyncTask<Void, Void, Void> {
		private Activity activity;
		private int position;

		public playAll(Activity activity) {
			position = 0;
			this.activity = activity;
		}

		@Override
		protected Void doInBackground(Void... params) {
			while (!isCancelled() && position < audioList.size()) {
				if (isReleased || !audioFile.isPlaying()) {
					startChant(position);
					position++;
				}
			}
			return null;
		}

		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			position = 0;
		}
	}
	
	private int adjustedPos(int position){
		return position -= (int)(position / 11);
	}
}
