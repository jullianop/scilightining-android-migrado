package br.ufrj.scilighting;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class SciLightingActivity extends Activity {
    /** Called when the activity is first created. */
   
	private OnClickListener clickRegisterNowListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(v.getContext(), RegisterMobileActivity.class);
			startActivity(intent);
			
		}
	};
	
	@Override
protected void onResume() {
		super.onResume();
		 
		// verifyRegistered();
		
		
	};
	
	
	@Override
	public void onAttachedToWindow()  {
			super.onAttachedToWindow();
			
			verifyRegistered();
			
			
		};
		
		@Override
		protected void onRestart() {
			// TODO Auto-generated method stub
			super.onRestart();
			//verifyRegistered();
		}
		
		@Override
		protected void onRestoreInstanceState(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onRestoreInstanceState(savedInstanceState);
			//verifyRegistered();
			
			
			
		}
		
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
          
        Button button = (Button)findViewById(R.id.buttonRegisterNow);
        
        button.setOnClickListener(clickRegisterNowListener);
        
        
		//verifyRegistered();
        
        

    }
	
	

	private void verifyRegistered() {
		SharedPreferences settings = getSharedPreferences(Config.PREFS_NAME, 0);
		Boolean registered = settings.getBoolean("registered",false);
		
        if(registered){

    		Intent intent = new Intent(getApplicationContext(), NotificationsListActivity.class);
    		startActivity(intent);
            	
        	
       }
	}
}