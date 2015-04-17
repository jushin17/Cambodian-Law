package ugot.law;


import android.support.v7.app.ActionBarActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import android.os.Bundle;
public class YearAfter1999 extends Activity {

	static String folderName;		//Variable to access the asset folder
	List<String> listMandate;		//Array to store Mandate
	HashMap<String, List<String>> listYear;		//Array to store Year
	ExpandableListAdapter listAdapter;		
	ExpandableListView expListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yearlist);
		
		ImageButton homebtn;	//��ü ����.
        homebtn=(ImageButton)findViewById(R.id.home); //����
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
     	   public void onClick(View v){	//onClick �Լ�.
     		 Intent intent = new Intent(YearAfter1999.this,MainActivity.class);	//MainActivity ��(this) sub�� .
    		 intent.putExtra("splash", "splash");
     		 startActivity(intent);
     	   }
        });


		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp);

		// preparing list data
		prepareListData();
		
		listAdapter = new ExpandableListAdapter(this, listMandate,listYear);

		// setting list adapter
		expListView.setAdapter(listAdapter);

		expListView.setOnChildClickListener(new OnChildClickListener() {
			
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				folderName = listYear.get(listMandate.get(groupPosition)).get(childPosition);
				Intent intent = new Intent(YearAfter1999.this,FileSortAfter1999.class);
				
				startActivity(intent);
				return false;
			}

		});
	}

	/*
	 * Preparing the list data
	 */
	private void prepareListData() {
		listMandate = new ArrayList<String>();
		listYear = new HashMap<String, List<String>>();


		// Adding Mandate data
				listMandate.add("First Mandate");
				listMandate.add("Second Mandate");
				listMandate.add("Third Mandate");
				
				// Adding Year data
				List<String> first = new ArrayList<String>();
				first.add("1999");
				first.add("2000");
				first.add("2001");
				first.add("2002");
				first.add("2003");
				first.add("2004");
				first.add("2005");
				first.add("2006");

				List<String> second = new ArrayList<String>();
				second.add("2007");
				second.add("2008");
				second.add("2009");
				second.add("2010");
				second.add("2011");
				second.add("2012");
				List<String> third = new ArrayList<String>();
				third.add("2013");
				third.add("2014");
				
				// Set data
				listYear.put(listMandate.get(0), first); 
				listYear.put(listMandate.get(1), second);
				listYear.put(listMandate.get(2), third);

			}

		}
