package casino.roulette.game;

import casino.roulette.game.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Login extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.login);
      
      Button button = (Button)findViewById(R.id.login_button);
      button.setOnClickListener(mOneShotListener);
      
      Button cancelButton = (Button)findViewById(R.id.cancel_button);
      cancelButton.setOnClickListener(mTwoShotListener);          
         
   }
   DBAdapter db = new DBAdapter(this); 
   private OnClickListener mOneShotListener = new OnClickListener() {
       public void onClick(View v) {
	    	  //Login Parameters - saved in a database
	    	  String usertest="";
	          String passwordtest="";
        	  Bundle bundle = new Bundle();

             //Login Parameters entered by the user
	          TextView tvusername = (TextView)findViewById(R.id.username);
	          TextView tvpassword = (TextView)findViewById(R.id.password);
	          
	          CharSequence username = tvusername.getText();
	          String user=username.toString();
	          
	          CharSequence password = tvpassword.getText();
	          String pass=password.toString();
	          
	          //Get information from the database
	          db.open();
	          Cursor c = db.getPlayer(user);
	          if (c.moveToFirst()){      
	        	  usertest=c.getString(3);
	              passwordtest=c.getString(4);
	          }
	          db.close();
	          
	          //Comparison
	          boolean comp1=usertest.contentEquals(username);
	          boolean comp2=passwordtest.contentEquals(password);
	          
	          if(comp1==true && comp2==true){
	        	  bundle.putString("username", usertest);
                  Intent newIntent = (new Intent(Login.this, Game.class));
	        	  newIntent.putExtras(bundle);	  
	              startActivity(newIntent);
	          Login.this.finish(); 
	        }
       }
   };
   
   private OnClickListener mTwoShotListener = new OnClickListener() {
       public void onClick(View v) {
	          startActivity(new Intent(Login.this, CasinoRoulette.class));
	          Login.this.finish(); 
       }
   };    
}