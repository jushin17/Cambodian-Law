package ugot.law;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchFile extends Activity {

   final MyAdapter Adapter = new MyAdapter(this);   // Adapter for managing a list
    String YearFolder;
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
          setContentView(R.layout.search);
          
          // TODO Auto-generated method stub
          ListView list = (ListView)findViewById(R.id.listView1);
          String mainQ = getIntent().getStringExtra("search");
          
          for(int i=0; i<files.filename.length; i++){
            for (int j = 1; j < files.filename[i].length; j++) {
               if(files.filename[i][j].toLowerCase().contains(mainQ.toLowerCase())){
                  Adapter.addItem(files.filename[i][j]);
               }
             }
          }
          
          list.setAdapter(Adapter);
          list.setOnItemClickListener(mItemClickListener);
          
      }
   private OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position,
               long id) {
            // TODO Auto-generated method stub
            
            String filename;
            filename= Adapter.getArr().get(position);
            CopyReadAssets(filename);
         }
      };
      
      private void CopyReadAssets(String filename) {
         
         AssetManager assetManager2 = getAssets();
         InputStream in = null;
         OutputStream out = null;
         
         File tempFile = new File(getFilesDir(), filename);
         
      
         for(int i=0; i<files.filename.length; i++){
            for(int j=0; j<files.filename[i].length; j++){
               if(files.filename[i][j] == filename){
                  YearFolder = files.filename[i][0];
               }
            }
         }       
       
         try {
      
            in = assetManager2.open(YearFolder+"/"+filename);
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
               Uri.parse("file://" + getFilesDir() + "/" + filename),"application/pdf");
         startActivity(view);
      }

      private void copyFile(InputStream in, OutputStream out) throws IOException {
         byte[] buffer = new byte[1024];
         int read;
         while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
         }
      }
   }