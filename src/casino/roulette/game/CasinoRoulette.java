/***
 * Game Casino Roulette
***/
package casino.roulette.game;

import casino.roulette.game.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class CasinoRoulette extends Activity implements OnClickListener {
   
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      // Set up click listeners for all the buttons
      View newButton = findViewById(R.id.new_button);
      newButton.setOnClickListener(this);
      View registerButton = findViewById(R.id.register_button);
      registerButton.setOnClickListener(this);
      View scoresButton = findViewById(R.id.scores_button);
      scoresButton.setOnClickListener(this);
      View aboutButton = findViewById(R.id.about_button);
      aboutButton.setOnClickListener(this);
      View exitButton = findViewById(R.id.exit_button);
      exitButton.setOnClickListener(this);
   }
   
   @Override
   protected void onResume() {
      super.onResume();
      Music.play(this, R.raw.main);
   }

   @Override
   protected void onPause() {
      super.onPause();
      Music.stop(this);
   }
     
   public void onClick(View v) {
      switch (v.getId()) {
      	case R.id.new_button:
    	  Intent i = new Intent(this, Login.class);    	  
          startActivity(i); 
          this.finish();
         break;

        case R.id.register_button:
      	  i = new Intent(this, Register.class);
            startActivity(i);
            break; 
            
      case R.id.scores_button:
    	  i = new Intent(this, Scores.class);    	  
          startActivity(i);         	  
         break;
         
      case R.id.about_button:
         i = new Intent(this, About.class);
         startActivity(i);
         break;
            
      case R.id.exit_button:
         finish();
         break;         
      }
   }
     
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      super.onCreateOptionsMenu(menu);
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.menu, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
      case R.id.settings:
         startActivity(new Intent(this, Prefs.class));
         return true;
      }
      return false;
   }

}