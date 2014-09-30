package devi.vidyaschool;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import devi.vidyaschool.R;

public class LyricsControl {
	private static final String TAG_DEFAULT = "default";

	public void initializeListViewWithLyrics(Activity activity,
			ArrayList<String> lyrics_container, ListView lyrics_list) {
		ArrayList<HashMap<String, String>> lyrics_setter = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < lyrics_container.size(); i++) {
			HashMap<String, String> individual_items = new HashMap<String, String>();
			individual_items.put(TAG_DEFAULT, lyrics_container.get(i));
			lyrics_setter.add(individual_items);
		}
		ListAdapter adapter = new SimpleAdapter(activity, lyrics_setter,
				R.layout.a_line_of_lyric, new String[] { TAG_DEFAULT, },
				new int[] { R.id.main_menu_list_items });
		lyrics_list.setAdapter(adapter);
	}
}
