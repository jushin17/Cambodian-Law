package ugot.law;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.PluginState;
import android.widget.ImageButton;
import android.os.Bundle;

public class Email extends Activity {

	WebView mWebView;
	@SuppressWarnings("deprecation")
	@SuppressLint("SetJavaScriptEnabled") public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.email);
	    
	    ImageButton homebtn;	//��ü ����.
        homebtn=(ImageButton)findViewById(R.id.home); //����
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){// ��ü�� Ŭ�� �Ǹ�.
     	   public void onClick(View v){	//onClick �Լ�.
     		 Intent intent = new Intent(Email.this,MainActivity.class);	//MainActivity ��(this) sub�� .
     		 intent.putExtra("splash", "splash");	
     		 startActivity(intent);
     	   }
        });
	    
	    mWebView = (WebView) findViewById(R.id.email_web);
	    mWebView.getSettings().setJavaScriptEnabled(true);
	    mWebView.loadUrl("http://www.senate.gov.kh/home/index.php?option=com_contact&view=contact&id=1&Itemid=50&lang=km");
	    mWebView.setWebViewClient(new BlogWebViewClient());
	    mWebView.getSettings().setBuiltInZoomControls(true);
	    mWebView.getSettings().setSupportZoom(true);
	}
	 public boolean onCreateOptionsMenu(Menu menu){
			getMenuInflater().inflate(R.menu.main,menu);
			return true;
		}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if((keyCode == KeyEvent.KEYCODE_BACK)&& mWebView.canGoBack()){
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	private class BlogWebViewClient extends WebViewClient{
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}
}