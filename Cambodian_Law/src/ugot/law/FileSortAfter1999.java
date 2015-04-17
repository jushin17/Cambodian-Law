package ugot.law;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;


import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextUtils;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.text.Editable;
import android.text.TextWatcher;

public class FileSortAfter1999 extends ListActivity {
	
	private EditText et;	// Variable for the search function		
	int textlength = 0;		// Variable for the search function
	
	private TextView layoutTitle;
	
	ArrayList<String> tempList = new ArrayList<String>();	//Temporary array for initializing the search function		
	
	private ListView list;		
	private String[] files;		
	
	final MyAdapter Adapter = new MyAdapter(this);	// Adapter for managing a list
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.filelist);
		
		ImageButton homebtn;	//객체 생성.
        homebtn=(ImageButton)findViewById(R.id.home); //선언
        
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){// 객체가 클릭 되면.
     	   public void onClick(View v){	//onClick 함수.
     		 Intent intent = new Intent(FileSortAfter1999.this,MainActivity.class);	//MainActivity 를(this) sub로 .
     		intent.putExtra("splash", "splash");
     		 startActivity(intent);
     	   }
        });
        
        layoutTitle=(TextView) findViewById(R.id.title);
        layoutTitle.setText("Law of "+YearAfter1999.folderName);

		et = (EditText) findViewById(R.id.searchText);

		// 출력할 listview ID받아오기
				list = (ListView) findViewById(android.R.id.list);
				// 리스트뷰와 파일이름 배열 연결 adapter
				
				// AssetManager를 통해 asset폴더에 접근
				AssetManager assetManager1 = getAssets();
				try {
					// asset 하위 폴더에 files 라는 폴더의 파일 목록에 접근
					files = assetManager1.list(YearAfter1999.folderName);
					// 파일 갯수 만큼 반복문돌려서 파일 이름 배열에 add
					for (int i = 0; i < files.length; i++) {
						Adapter.addItem(files[i]);
					}
					// listview에 출력!!!!!!!!
					list.setAdapter(Adapter);
					// 항목클릭리스너 등록
					list.setTextFilterEnabled(true);

			et.addTextChangedListener(new TextWatcher() {
				public void afterTextChanged(Editable s) {
					// Abstract Method of TextWatcher Interface.
				}

				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// Abstract Method of TextWatcher Interface.
				}
				//Search in list
				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					textlength = et.getText().length();		//Length of the input string
					tempList=Adapter.getArr();		//Temporary arraylist for a list initialized		
					Adapter.clearItem();		//Make an empty adapter
					
					//The adapter added to the input string containing the list.
					for (int i = 0; i < files.length; i++) {
						if (textlength <= files[i].length()) {
							if (files[i].toLowerCase().contains(
									et.getText().toString().toLowerCase()
											.trim())) {
								Adapter.addItem(files[i]);
							}
						}
					}
					// If not the search is initialized to the original arrangement.
					if(textlength==0)
						Adapter.recovery(tempList);
					//Create list
					list.setAdapter(Adapter);
					
				}
			});
			//Click event
			list.setOnItemClickListener(mItemClickListener);

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			// 항목 파일이름 받아오기
			String mes;
			// Copy the selected string in a list
			mes = Adapter.getArr().get(position);
			// Call CopyReadAssets function
			CopyReadAssets(mes);
			

		}
	};

	private void CopyReadAssets(String filename) {
		AssetManager assetManager2 = getAssets();
		InputStream in = null;
		OutputStream out = null;

		File tempFile = new File(getFilesDir(), filename);

		try {
			in = assetManager2.open(YearAfter1999.folderName + "/" + filename);
			out = openFileOutput(tempFile.getName(),
					Context.MODE_WORLD_READABLE);

			copyFile(in, out);
			in.close();
			in = null;

			out.flush();
			out.close();
			out = null;

		} catch (Exception e) {
			Log.e("tag", e.getMessage());
		}
				
		Intent view = new Intent(Intent.ACTION_VIEW);
		view.setDataAndType(
				Uri.parse("file://" + getFilesDir() + "/" + filename),
				"application/pdf");
		startActivity(view);
	}

	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
	}

	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}

	public void AppendList(ArrayList<String> str) {
		setListAdapter((ListAdapter) new bsAdapter(this));
	}

	public class bsAdapter extends BaseAdapter {
		Activity cntx;

		public bsAdapter(Activity context) {
			// TODO Auto-generated constructor stub
			this.cntx = context;

		}

		public int getCount() {
			// TODO Auto-generated method stub
			return Adapter.getArr().size();
		}

		public Object getItem(int position) {
			// TODOArray Auto-generated method stub
			return Adapter.getArr().get(position);
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return Adapter.getArr().size();
		}
		
		
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			View row = null;

			LayoutInflater inflater = cntx.getLayoutInflater();
			
			//if you want to change layout of list, you edit list_item.xml
			row = inflater.inflate(R.layout.list_item, null);

			TextView tv = (TextView) row.findViewById(R.id.lblListItem);

			tv.setText(Adapter.getArr().get(position));

			return row;
		}
	}

}