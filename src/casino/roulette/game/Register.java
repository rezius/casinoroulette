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

public class Register extends Activity {
	DBAdapter db = new DBAdapter(this); 	
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.register);
      
      Button registerButton = (Button)findViewById(R.id.register_button);
      registerButton.setOnClickListener(mOneShotListener);  
      
      Button cancelButton = (Button)findViewById(R.id.cancel_button);
      cancelButton.setOnClickListener(mTwoShotListener);           
   }

   private OnClickListener mOneShotListener = new OnClickListener() {
       public void onClick(View v) {

             //Registration parameters
	          TextView name_text     = (TextView)findViewById(R.id.name);
	          TextView surname_text  = (TextView)findViewById(R.id.surname);
	          TextView username_text = (TextView)findViewById(R.id.username);
	          TextView password_text = (TextView)findViewById(R.id.password);
	          TextView email_text    = (TextView)findViewById(R.id.email);
	          
	          CharSequence name_char 	 = name_text.getText(); 
	          String name            	 = name_char.toString();
	          CharSequence surname_char  = surname_text.getText(); 
	          String surname             = surname_char.toString();	          
	          CharSequence username_char = username_text.getText(); 
	          String username            = username_char.toString();	          
	          CharSequence password_char = password_text.getText(); 
	          String password            = password_char.toString();
	          CharSequence email_char    = email_text.getText(); 
	          String email               = email_char.toString();	          
	          
	          //---Add registration information---
	          db.open();        
	          long id;
	          id = db.insertPlayer(
	          		name,
	          		surname,
	          		username,
	          		password,
	          		email,
	          		0,0); 	          
	          db.close();	          
	          
	          startActivity(new Intent(Register.this, Login.class));
	          Register.this.finish(); 

       }
   };  
   
   private OnClickListener mTwoShotListener = new OnClickListener() {
       public void onClick(View v) {
	          startActivity(new Intent(Register.this, CasinoRoulette.class));
	          Register.this.finish(); 
       }
   };     
}
