package devi.vidyaschool;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class CustomAdapter extends BaseAdapter {

	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;

	private ArrayList<String> mData = new ArrayList<String>();
	private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

	private LayoutInflater mInflater;

	private boolean isSongLearn = false;

	public CustomAdapter(Context context, Boolean isSongPage) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		isSongLearn = isSongPage;
	}

	public void addItem(final String item) {
		mData.add(item);
		notifyDataSetChanged();
	}

	public void addSectionHeaderItem(final String item) {
		mData.add(item);
		sectionHeader.add(mData.size() - 1);
		notifyDataSetChanged();
	}

	@Override
	public int getItemViewType(int position) {
		return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public String getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		int rowType = getItemViewType(position);

		if (convertView == null) {
			holder = new ViewHolder();
			switch (rowType) {
			case TYPE_ITEM:{
				if(isSongLearn){
					convertView = mInflater.inflate(R.layout.a_line_of_lyric, null);
					holder.textView = (TextView) convertView
							.findViewById(R.id.line_of_lyric_text);
				}
				else{
				convertView = mInflater.inflate(R.layout.listview_item, null);
				holder.textView = (TextView) convertView
						.findViewById(R.id.main_menu_list_items);
				}
				break;
			}
			case TYPE_SEPARATOR: {
				if (isSongLearn) {
					convertView = mInflater.inflate(
							R.layout.song_lines_seperator, null);
					holder.textView = (TextView) convertView
							.findViewById(R.id.line_number_indicator);
				} else {
					convertView = mInflater.inflate(
							R.layout.listview_section_headers, null);
					holder.textView = (TextView) convertView
							.findViewById(R.id.listview_section_header);
				}
				break;
			}
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(mData.get(position));
		if(isSongLearn){
		setBackgroundOnLyrics(position, convertView);
		}
		return convertView;
	}

	private void setBackgroundOnLyrics(final int position, View convertView) {
		try{
			SongLearn.audioFile.isPlaying();
		}
		catch(IllegalStateException e){
			return;
		}
		if(SongLearn.adjustedPos(position) == SongLearn.selectedPos){
			convertView.setBackgroundResource(R.color.gold_listview_divider);
		}
		else{
			convertView.setBackgroundResource(R.drawable.lyrics_default);
		}
	}

	public static class ViewHolder {
		public TextView textView;
	}
}
