package ugot.law;

import android.support.v7.app.ActionBarActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.*;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
public class MainActivity extends ActionBarActivity implements SearchView.OnQueryTextListener,SearchView.OnCloseListener{	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(getIntent().getExtras()==null)
        	startActivity(new Intent(this, SplashActivity.class));
        
        setContentView(R.layout.activity_main);
        
        SearchView Search = (SearchView)findViewById(R.id.searchView);
		Search.setQueryHint("Search");
		Search.setIconifiedByDefault(false);
		Search.setOnQueryTextListener(this);
		Search.setOnCloseListener(this);
		
		Search.setOnQueryTextListener(new OnQueryTextListener() {
			public boolean onQueryTextSubmit(String query) {
				// TODO Auto-generated method stub
				Intent searchIntent = new Intent(MainActivity.this,SearchFile.class);
				searchIntent.putExtra("search", query);
				startActivity(searchIntent);
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) {
				// TODO Auto-generated method stub
				return false;
			}
		});

        ImageButton homebtn;
        homebtn=(ImageButton)findViewById(R.id.home);
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){
     	   public void onClick(View v){
     		 Intent intent = new Intent(MainActivity.this,MainActivity.class);
     		 intent.putExtra("splash", "splash");	
     		 startActivity(intent);
     	   }
        });
        
        ImageButton mBtn1;	.
    mBtn1=(ImageButton)findViewById(R.id.icon_law1);
    mBtn1.setOnClickListener(new ImageButton.OnClickListener(){/
 	   public void onClick(View v){
 	
 		 Intent intent = new Intent(MainActivity.this,YearBefore1999.class);	
			startActivity(intent);
 	   }
    });
    
    ImageButton mBtn2;	//��ü ����.
    mBtn2=(ImageButton)findViewById(R.id.icon_law2); //����
    mBtn2.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
 	   public void onClick(View v){	//onClick �Լ�.
 		
 		   Intent intent = new Intent(MainActivity.this,YearAfter1999.class);	//MainActivity ��(this) sub�� .
 			startActivity(intent);	
 	   }
    });
    
    ImageButton mBtn3;	//��ü ����.
    mBtn3=(ImageButton)findViewById(R.id.icon_website); //����
    mBtn3.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
 	   public void onClick(View v){	//onClick �Լ�.
 		  
 		   Intent intent = new Intent(MainActivity.this,Homepage.class);	//MainActivity ��(this) sub�� .
 			startActivity(intent);	
 	   }
    });
    
    ImageButton mBtn4;	//��ü ����.
    mBtn4=(ImageButton)findViewById(R.id.icon_senate); //����
    mBtn4.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
 	   public void onClick(View v){	//onClick �Լ�.
 		 
 		   Intent intent = new Intent(MainActivity.this,Senate.class);	//MainActivity ��(this) sub�� .
 			startActivity(intent);	
 	   }
    });
    
    
   
    ImageButton mBtn5;	//��ü ����.
    mBtn5=(ImageButton)findViewById(R.id.icon_contact); //����
    mBtn5.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
 	   public void onClick(View v){	//onClick �Լ�.
 		
 		  Intent intent = new Intent(MainActivity.this,Contact.class);	//MainActivity ��(this) sub�� .
 			startActivity(intent);	
 	   }
    });
    
    
    ImageButton mBtn6;	//��ü ����.
    mBtn6=(ImageButton)findViewById(R.id.icon_manual); //����
    mBtn6.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
 	   public void onClick(View v){	//onClick �Լ�.
 		
 		   Intent intent = new Intent(MainActivity.this,Support.class);	//MainActivity ��(this) sub�� .
 			startActivity(intent);	
 	   }
    });

    }
	@Override
	public boolean onClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}
	
}