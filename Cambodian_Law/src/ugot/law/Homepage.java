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

public class Homepage extends Activity {

	WebView mWebView;
	@SuppressWarnings("deprecation")
	@SuppressLint("SetJavaScriptEnabled") public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.webviewda);
	    
	    ImageButton homebtn;
        homebtn=(ImageButton)findViewById(R.id.home);
        homebtn.setOnClickListener(new ImageButton.OnClickListener(){
     	   public void onClick(View v){
     		 Intent intent = new Intent(Homepage.this,MainActivity.class);	
     		 intent.putExtra("splash", "splash");	
     		 startActivity(intent);
     	   }
        });
	    
	    mWebView = (WebView) findViewById(R.id.webview);
	    mWebView.getSettings().setJavaScriptEnabled(true);
	    mWebView.loadUrl("http://www.senate.gov.kh/home/index.php?lang=km");
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