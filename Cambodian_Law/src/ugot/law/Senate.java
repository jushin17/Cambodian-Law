package ugot.law;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Senate extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.aboutsenate);
	    
	    ImageButton homebtn;	//��ü ����.
        homebtn=(ImageButton)findViewById(R.id.home); //����
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
     	   public void onClick(View v){	//onClick �Լ�.
     		 Intent intent = new Intent(Senate.this,MainActivity.class);	//MainActivity ��(this) sub�� .
     		 intent.putExtra("splash", "splash");	
     		 startActivity(intent);
     	   }
        });
	    
	   
	}

}