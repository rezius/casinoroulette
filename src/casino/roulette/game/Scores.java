package casino.roulette.game;

import casino.roulette.game.DBAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Scores extends Activity implements OnClickListener {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.scores); 
      
      View scoresButton = findViewById(R.id.scores_button);
      scoresButton.setOnClickListener(this);
      View cancelButton = findViewById(R.id.cancel_button);
      cancelButton.setOnClickListener(this);      
   }
      
   public void onClick(View v) {
	   switch (v.getId()) {
	      case R.id.scores_button:	   
	          DBAdapter db = new DBAdapter(this); 
	          TextView tvusername = (TextView)findViewById(R.id.username);
	          CharSequence username = tvusername.getText();
	          String user=username.toString(); 	   
	          //---get the scores of all games for a player---
	          db.open();
	          Cursor c = db.getScores(user);
	          playerInfo(c);
	          db.close(); 
	          break;
	      case R.id.cancel_button:
	    	  startActivity(new Intent(Scores.this, CasinoRoulette.class));
	          Scores.this.finish(); 	    	  
	   }        
   }
    private void playerInfo(Cursor cursor) {
      // Stuff them all into a big string
      StringBuilder builder = new StringBuilder( 
            "Scores(wins):\n");
      long id=1;
      while (cursor.moveToNext()) { 
    	  if(cursor.getString(3).equals(cursor.getString(1)))
    		  cursor.moveToNext();  
         // Could use getColumnIndexOrThrow() to get indexes 
         long score = cursor.getLong(7);
         builder.append("Game");
         builder.append(id).append(":");
         builder.append(score).append(" Points\n");
         ++id;
      }
      // Display on the screen
      TextView text = (TextView) findViewById(R.id.scores); 
      text.setText(builder);
   }  
}
