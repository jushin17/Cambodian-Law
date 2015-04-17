package ugot.law;


import android.app.Activity;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class Support extends Activity implements OnTouchListener {
	ViewFlipper flipper;
	float xAtDown;
	float xAtUp;
	int count=0;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.support);
	    
	    ImageButton homebtn;	//��ü ����.
        homebtn=(ImageButton)findViewById(R.id.home); //����
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
     	   public void onClick(View v){	//onClick �Լ�.
     		 Intent intent = new Intent(Support.this,MainActivity.class);	//MainActivity ��(this) sub�� .
     		 intent.putExtra("splash", "splash");	
     		 startActivity(intent);
     	   }
        });
	    
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        flipper.setOnTouchListener(this);
	}
	    // TODO Auto-generated method stub


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if( v != flipper) return false;
		if(event.getAction() == MotionEvent.ACTION_DOWN){
			xAtDown = event.getX();
		}
		else if(event.getAction() == MotionEvent.ACTION_UP){
			xAtUp = event.getX();
			if(xAtDown > xAtUp){
				flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.animator.push_left_in));
				flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.animator.push_left_out));
				count++;
				if(count<5)
					flipper.showNext();
				else{
					Toast.makeText(this, "LastPage", Toast.LENGTH_SHORT).show();
					count--;
				}
			}
			else if(xAtDown < xAtUp){
				flipper.setInAnimation(AnimationUtils.loadAnimation(this,  R.animator.push_right_in));
				flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.animator.push_right_out));
				count--;
				if(count> -1)
					flipper.showPrevious();
				else{
					Toast.makeText(this, "First page.", Toast.LENGTH_SHORT).show();
					count++;
				}
			}
		}
		return true;
	}
}
