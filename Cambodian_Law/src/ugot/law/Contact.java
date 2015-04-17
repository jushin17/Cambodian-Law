package ugot.law;


import android.app.Activity;
import android.os.Bundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.support.v7.app.ActionBarActivity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;		
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import android.widget.Button;
import java.util.ArrayList;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan; 
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.app.*;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.*;
import android.view.*;
import android.widget.*;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
public class Contact extends Activity {
	
	
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.contactus);
	    
	   RadioGroup Num = (RadioGroup)findViewById(R.id.numbergroup);
	   Num.setOnCheckedChangeListener(mRadioCheck);
	   ImageButton button_actionCall;
	   

	    ImageButton homebtn;	//��ü ����.
        homebtn=(ImageButton)findViewById(R.id.home); //����
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
     	   public void onClick(View v){	//onClick �Լ�.
     		 Intent intent = new Intent(Contact.this,MainActivity.class);	//MainActivity ��(this) sub�� .
     		 intent.putExtra("splash", "splash");	
     		 startActivity(intent);
     	   }
        });
	   
        ImageButton button_map;
		button_map = (ImageButton)findViewById(R.id.map);
		button_map.setOnClickListener(new ImageButton.OnClickListener(){
			public void onClick(View v){
				Uri uri = Uri.parse("geo:11.541335,104.926839?q=Cambodia Senate");
				Intent intent = new Intent(Intent.ACTION_VIEW, uri);
				startActivity(intent);
		}
		});
		
		ImageButton button_email;	//��ü ����.
		button_email=(ImageButton)findViewById(R.id.email); //����
		button_email.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
	 	   public void onClick(View v){	//onClick �Լ�.
	 		   Intent intent = new Intent(Contact.this,Email.class);	//MainActivity ��(this) sub�� .
	 			startActivity(intent);	
	 	   }
	    });
	}
	
	RadioGroup.OnCheckedChangeListener mRadioCheck = new RadioGroup.OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			ImageButton button_actionCall;
			if(group.getId()==R.id.numbergroup){
				switch(checkedId){
				case R.id.check1:
					
					button_actionCall = (ImageButton)findViewById(R.id.call);
					button_actionCall.setOnClickListener(new ImageButton.OnClickListener(){
						public void onClick(View v){
							Intent intent = new Intent(Intent.ACTION_CALL,
							Uri.parse("tel:023-211-441"));
							startActivity(intent);
					}
					});
						
					break;
				case R.id.check2:
					button_actionCall = (ImageButton)findViewById(R.id.call);
					button_actionCall.setOnClickListener(new ImageButton.OnClickListener(){
						public void onClick(View v){
							Intent intent = new Intent(Intent.ACTION_CALL,
							Uri.parse("tel:023-211-442"));
							startActivity(intent);
					}
					});
					break;
				case R.id.check3:
					button_actionCall = (ImageButton)findViewById(R.id.call);
					button_actionCall.setOnClickListener(new ImageButton.OnClickListener(){
						public void onClick(View v){
							Intent intent = new Intent(Intent.ACTION_CALL,
							Uri.parse("tel:023-211-443"));
							startActivity(intent);
					}
					});
					break;
				}
			}
		}
	};
	
}