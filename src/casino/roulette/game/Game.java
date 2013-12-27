package casino.roulette.game;
import java.util.Random;
import casino.roulette.game.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener {
    private Random rand = new Random();
    private String[] PossibleNumbers = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", 
    		"13", "14", "15", "16","17","18","19","20","21","22","23","24",
    		"25","26", "27", "28","29","30","31","32","33","34", "35", "36"};   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.game);  
           
      // Set up click listeners for all the buttons
      View betButton1 = findViewById(R.id.button13);
      betButton1.setOnClickListener(this);
      View betButton2 = findViewById(R.id.button14);
      betButton2.setOnClickListener(this);
      View betButton3 = findViewById(R.id.button15);
      betButton3.setOnClickListener(this);      
      View gameButton1 = findViewById(R.id.button1);
      gameButton1.setOnClickListener(this);
      View gameButton2 = findViewById(R.id.button2);
      gameButton2.setOnClickListener(this);  
      View gameButton3 = findViewById(R.id.button3);
      gameButton3.setOnClickListener(this);
      View gameButton4 = findViewById(R.id.button4);
      gameButton4.setOnClickListener(this);
      View gameButton5 = findViewById(R.id.button5);
      gameButton5.setOnClickListener(this);
      View gameButton6 = findViewById(R.id.button6);
      gameButton6.setOnClickListener(this);
      View gameButton7 = findViewById(R.id.button7);
      gameButton7.setOnClickListener(this); 
      View gameButton8 = findViewById(R.id.button8);
      gameButton8.setOnClickListener(this);
      View gameButton9 = findViewById(R.id.button9);
      gameButton9.setOnClickListener(this);      
      View gameButton10 = findViewById(R.id.button10);
      gameButton10.setOnClickListener(this);
      View gameButton11 = findViewById(R.id.button11);
      gameButton11.setOnClickListener(this);
      View gameButton12 = findViewById(R.id.button12);
      gameButton12.setOnClickListener(this);  
      View finishButton = findViewById(R.id.finish);
      finishButton.setOnClickListener(this);      
   }
   private int initial_score=500;
   private int bet_amount=0;
   private int final_score=0;
   boolean win; 
   
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
	      case R.id.button13:
	    	  bet_amount = 5;
	          String bet = Integer.toString(bet_amount);
	          TextView BetDisplay = (TextView)findViewById(R.id.txt3);
	          BetDisplay.setText(bet);
	          BetDisplay.setTextColor(getResources().getColor(R.color.white));	          
	         break;
	      case R.id.button14:
	    	  bet_amount = 20;
	    	  bet = Integer.toString(bet_amount);
	          BetDisplay = (TextView)findViewById(R.id.txt3);
	          BetDisplay.setText(bet);
	          BetDisplay.setTextColor(getResources().getColor(R.color.black));
	         break;
	      case R.id.button15:
	    	  bet_amount = 100;
	          bet = Integer.toString(bet_amount);
	          BetDisplay = (TextView)findViewById(R.id.txt3);
	          BetDisplay.setText(bet);
	          BetDisplay.setTextColor(getResources().getColor(R.color.red));	          
	         break;	         
	      case R.id.button1:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  int num=generate_random_number();
	    	  if(num>0 && num<=12)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	  break;
	      case R.id.button2:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num>12 && num<=24)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);	    	  
	    	  break; 
	      case R.id.button3:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num>24 && num<=36)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button4:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num>=1 && num<=18)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button5:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num%2==0)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button6:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num==1||num==7||num==16||num==25||num==34||num==5||num==14||num==23||num==32||num==3||num==9||num==12||num==18||num==21||num==27||num==30||num==36)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button7:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num!=1||num!=7||num!=16||num!=25||num!=34||num!=5||num!=14||num!=23||num!=32||num!=3||num!=9||num!=12||num!=18||num!=21||num!=27||num!=30||num!=36)	    	 
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button8:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num%2==1)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button9:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num>=19 && num<=36)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button10:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num%3==1)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button11:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num%3==2)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.button12:
              //start wheel rotation
	    	  start_rotate_wheel();
              //stop wheel rotation
	    	  stop_rotate_wheel();
              //generate random number
	    	  num=generate_random_number();
	    	  if(num%3==0)
	    			  win=true;
	    		  else
	    			  win=false;
	    	  check_update_results(win);
	    	   break;
	      case R.id.finish:
	          Bundle b = getIntent().getExtras(); 
	          String username = b.getString("username");
	          DBAdapter db = new DBAdapter(this);
	          //---Add information---
	          db.open();        
	          long id;
	          id = db.insertPlayer(
	          		username,
	          		"",
	          		"",
	          		"",
	          		"",
	          		0,final_score); 	          
	          db.close();	          
	          
	          startActivity(new Intent(Game.this, CasinoRoulette.class));
	          Game.this.finish(); 
	    	   break;	    	   
      }   
   }
public void start_rotate_wheel(){
    Animation spinin = AnimationUtils.loadAnimation(this, R.anim.wheel_anim);
    LayoutAnimationController controller = new LayoutAnimationController(spinin);
    TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
    for (int i = 0; i < table.getChildCount(); i++) {
        TableRow row = (TableRow) table.getChildAt(i);
        row.setLayoutAnimation(controller);
    } 	          	
}

public int generate_random_number(){
	  int num = rand.nextInt( PossibleNumbers.length );
	  String result = PossibleNumbers[num];
	  TextView ResultDisplay = (TextView)findViewById(R.id.txt1);	
	  ResultDisplay.setText(result);
	  return Integer.parseInt(result);	
}

public void stop_rotate_wheel(){
	TableLayout  table = (TableLayout) findViewById(R.id.TableLayout01);
      for (int i = 0; i < table.getChildCount(); i++) {
          TableRow row = (TableRow) table.getChildAt(i);
          row.clearAnimation();
      }	  	      
}

public void check_update_results(boolean win){
		if(win==true){
  		  initial_score = initial_score + bet_amount;
		  final_score=final_score+bet_amount;
		  TextView ScoreDisplay = (TextView)findViewById(R.id.txt2);
          ScoreDisplay.setText(Integer.toString(initial_score));
          TextView BetDisplay = (TextView)findViewById(R.id.txt3);
          BetDisplay.setText(Integer.toString(0));
          TextView FinalDisplay = (TextView)findViewById(R.id.txt4);
          FinalDisplay.setText(Integer.toString(final_score));				
		} else {
		  initial_score = initial_score - bet_amount;
		  final_score=final_score-bet_amount;
		  TextView ScoreDisplay = (TextView)findViewById(R.id.txt2);
		  ScoreDisplay.setText(Integer.toString(initial_score));
	      TextView BetDisplay = (TextView)findViewById(R.id.txt3);
	      BetDisplay.setText(Integer.toString(0));
	      TextView FinalDisplay = (TextView)findViewById(R.id.txt4);
	      FinalDisplay.setText(Integer.toString(final_score));			
		}
}

}

   