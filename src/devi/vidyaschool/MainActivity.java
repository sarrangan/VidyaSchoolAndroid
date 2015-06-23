package devi.vidyaschool;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import devi.vidyaschool.R;

public class MainActivity extends ActionBarActivity {
	private static final String TAG_ITEM = "main_menu_item";
	public static final String LYRICS_TAG = "lyrics";
	public static final String AUDIO_TAG = "audio";
	public static final String TITLE = "title";
	private CustomAdapter mAdapter;
	private NeelaSuktamControl neelaSuktamControl;
	private PurushaSuktamControl purushaSuktamControl;
	private NarayanaSuktamControl narayanaSuktamControl;
	private SriSuktamControl sriSuktamControl;
	private DurgaSuktamControl durgaSuktamControl;
	private MedhaSuktamControl medhaSuktamControl;
	private RudramControl rudramControl;
	private LSNControl lsnControl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		neelaSuktamControl = new NeelaSuktamControl(this);
		purushaSuktamControl = new PurushaSuktamControl(this);
		narayanaSuktamControl = new NarayanaSuktamControl(this);
		sriSuktamControl = new SriSuktamControl(this);
		durgaSuktamControl = new DurgaSuktamControl(this);
		medhaSuktamControl = new MedhaSuktamControl(this);
		lsnControl = new LSNControl(this);
		rudramControl = new RudramControl(this);
		setUpMainMenuItems();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setUpMainMenuItems() {
		ListView main_menu = (ListView) findViewById(R.id.main_menu_list);
		mAdapter = new CustomAdapter(this, false);
		setUpSuktamSection();
		main_menu.setAdapter(mAdapter);

		main_menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String menu_item_name;
				try {
					menu_item_name = ((TextView) view
							.findViewById(R.id.main_menu_list_items)).getText()
							.toString();
				} catch (Exception e) {
					menu_item_name = ((TextView) view
							.findViewById(R.id.listview_section_header))
							.getText().toString();
				}
				if (menu_item_name == getString(R.string.neela_suktam_title)) {
					Intent in = new Intent(getApplicationContext(),
							SongLearn.class);
					in.putExtra(
							TITLE,
							getResources().getString(
									R.string.neela_suktam_title));
					in.putExtra(LYRICS_TAG, neelaSuktamControl.getLyrics());
					in.putExtra(AUDIO_TAG, neelaSuktamControl.getAudioList());
					startActivity(in);
				} else if (menu_item_name == getString(R.string.purusha_suktam_title)) {
					Intent in = new Intent(getApplicationContext(),
							SongLearn.class);
					in.putExtra(
							TITLE,
							getResources().getString(
									R.string.purusha_suktam_title));
					in.putExtra(LYRICS_TAG, purushaSuktamControl.getLyrics());
					in.putExtra(AUDIO_TAG, purushaSuktamControl.getAudioList());
					startActivity(in);
				} else if (menu_item_name == getString(R.string.narayana_suktam_title)) {
					Intent in = new Intent(getApplicationContext(),
							SongLearn.class);
					in.putExtra(
							TITLE,
							getResources().getString(
									R.string.narayana_suktam_title));
					in.putExtra(LYRICS_TAG, narayanaSuktamControl.getLyrics());
					in.putExtra(AUDIO_TAG, narayanaSuktamControl.getAudioList());
					startActivity(in);
				} else if (menu_item_name == getString(R.string.sri_suktam_title)) {
					Intent in = new Intent(getApplicationContext(),
							SongLearn.class);
					in.putExtra(TITLE,
							getResources().getString(R.string.sri_suktam_title));
					in.putExtra(LYRICS_TAG, sriSuktamControl.getLyrics());
					in.putExtra(AUDIO_TAG, sriSuktamControl.getAudioList());
					startActivity(in);
				} else if (menu_item_name == getString(R.string.LSN_title)) {
					Intent in = new Intent(getApplicationContext(),
							SongLearn.class);
					in.putExtra(TITLE,
							getResources().getString(R.string.LSN_title_short));
					in.putExtra(LYRICS_TAG, lsnControl.getLyrics());
					in.putExtra(AUDIO_TAG, lsnControl.getAudioList());
					startActivity(in);
				}
				else if (menu_item_name == getString(R.string.durga_suktam_title)){
					Intent in = new Intent(getApplicationContext(),
							SongLearn.class);
					in.putExtra(TITLE,
							getResources().getString(R.string.durga_suktam_title));
					in.putExtra(LYRICS_TAG, durgaSuktamControl.getLyrics());
					in.putExtra(AUDIO_TAG, durgaSuktamControl.getAudioList());
					startActivity(in);
				}
				else if(menu_item_name == getString(R.string.medha_suktam_title)){
					Intent in = new Intent(getApplicationContext(), SongLearn.class);
					in.putExtra(TITLE,
							getResources().getString(R.string.medha_suktam_title));
					in.putExtra(LYRICS_TAG, medhaSuktamControl.getLyrics());
					in.putExtra(AUDIO_TAG, medhaSuktamControl.getAudioList());
					startActivity(in);
				}
				else if(menu_item_name == getString(R.string.rudram__namakam_title)){
					Intent in = new Intent(getApplicationContext(), SongLearn.class);
					in.putExtra(TITLE, getResources().getString(R.string.rudram__namakam_title));
					in.putExtra(LYRICS_TAG, rudramControl.getLyrics());
					in.putExtra(AUDIO_TAG, rudramControl.getAudioList());
					startActivity(in);
				}
			}
		});
	}

	private void setUpSuktamSection() {
		mAdapter.addSectionHeaderItem("Suktams");
		mAdapter.addItem(getString(R.string.purusha_suktam_title));
		mAdapter.addItem(getString(R.string.sri_suktam_title));
		mAdapter.addItem(getString(R.string.neela_suktam_title));
		mAdapter.addItem(getString(R.string.narayana_suktam_title));
		mAdapter.addItem(getString(R.string.durga_suktam_title));
		mAdapter.addItem(getString(R.string.medha_suktam_title));
		mAdapter.addSectionHeaderItem("LSN");
		mAdapter.addItem(getString(R.string.LSN_title));
		mAdapter.addSectionHeaderItem("Rudram");
		mAdapter.addItem(getString(R.string.rudram__namakam_title));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}
}
