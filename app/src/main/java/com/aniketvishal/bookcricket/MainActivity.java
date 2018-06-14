package com.aniketvishal.bookcricket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.duration;
import static android.R.attr.mode;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    int score_a = 0;
    int score_b = 0;

    int wicket_a = 0;
    int wicket_b = 0;

    int ball_a = 0;
    int ball_b = 0;

    int balla = 0;
    int ballb = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_button_30:
                if (checked) {
                    ball_a = 30;
                    ball_b = 30;
                }
                break;
            case R.id.radio_button_48:
                if (checked) {
                    ball_a = 48;
                    ball_b = 48;
                }
                break;
            case R.id.radio_button_60:
                if (checked) {
                    ball_a = 60;
                    ball_b = 60;
                }
                break;
        }

    }


    public void tap_a(View view) {

        balla++;

        if (balla <= ball_a && wicket_a<10){
            double ran = Math.random();
            int ran_int = (int)(ran*30);
            scorea(ran_int);
        }

        else if(balla > 29) {
            Toast toast = Toast.makeText(this, "No more Balls left", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }

        else if(wicket_a > 9) {
            Toast toast = Toast.makeText(this, "No more Wicket left", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    }

    public void tap_b(View view) {

        ballb++;

        if (ballb <= ball_b && wicket_b<10){
            double ran = Math.random();
            int ran_int = (int)(ran*30);
            scoreb(ran_int);

            if(score_b > score_a){
                display_winner("Team B");
            }
        }

        else if(ballb > 29) {
            Toast toast = Toast.makeText(this, "No more Balls left", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();

            if(score_a > score_b){
                display_winner("Team A");
            }
            else{
                display_winner("Team B");
            }
        }

        else if(wicket_b > 9) {
            Toast toast = Toast.makeText(this, "No more Wicket left", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();

            if(score_a > score_b){
                display_winner("Team A");
            }
            else{
                display_winner("Team B");
            }
        }


    }

    //reset method...

    public void reset(View view) {
        score_a = 0;
        score_b = 0;

        wicket_a = 0;
        wicket_b = 0;

        balla = 0;
        ballb = 0;

        display_a(score_a);
        display_wa(wicket_a);
        display_ba(balla);

        display_b(score_b);
        display_wb(wicket_b);
        display_bb(ballb);

        display_winner("?");

        display_runa(score_a);
        display_runb(score_b);

    }

    //Display method of team a

    private void display_a(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_team_a);
        tv.setText("" + number);
    }


    private void display_wa(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_w_team_a);
        tv.setText("" + number);
    }

    private void display_ba(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_b_team_a);
        tv.setText("" + number);
    }

    private void display_runa(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_run_team_a);
        tv.setText("" + number);
    }

    private void display_outa() {
        TextView tv = (TextView) findViewById(R.id.tv_run_team_a);
        tv.setText("Out!");
    }

    private void display_winner(String str) {
        TextView tv = (TextView) findViewById(R.id.tv_winner);
        tv.setText("Winner : " + str);
    }



    //Display method of team b

    private void display_b(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_team_b);
        tv.setText("" + number);
    }


    private void display_wb(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_w_team_b);
        tv.setText("" + number);
    }

    private void display_bb(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_b_team_b);
        tv.setText("" + number);
    }

    private void display_runb(int number) {
        TextView tv = (TextView) findViewById(R.id.tv_run_team_b);
        tv.setText("" + number);
    }

    private void display_outb() {
        TextView tv = (TextView) findViewById(R.id.tv_run_team_b);
        tv.setText("Out!");
    }



    // score of team a

    private void scorea(int number) {
        switch (number) {
            case 0: score_a = (score_a+0);
                display_runa(0);
                display_a(score_a);
                display_ba(balla);
                break;

            case 1:score_a = (score_a+1);
                display_runa(1);
                display_a(score_a);
                display_ba(balla);
                break;

            case 2:score_a = (score_a+2);
                display_runa(2);
                display_a(score_a);
                display_ba(balla);
                break;

            case 3:score_a = (score_a+3);
                display_runa(3);
                display_a(score_a);
                display_ba(balla);
                break;

            case 4:score_a = (score_a+4);
                display_runa(4);
                display_a(score_a);
                display_ba(balla);
                break;

            case 5:score_a = (score_a+5);
                display_runa(5);
                display_a(score_a);
                display_ba(balla);
                break;

            case 6:score_a = (score_a+6);
                display_runa(6);
                display_a(score_a);
                display_ba(balla);
                break;

            case 7:score_a = (score_a+0);
                wicket_a++;
                display_outa();
                display_a(score_a);
                display_wa(wicket_a);
                display_ba(balla);
                break;

            case 8:score_a = (score_a+0);
                display_runa(0);
                display_a(score_a);
                display_ba(balla);
                break;

            case 9:score_a = (score_a+1);
                display_runa(1);
                display_a(score_a);
                display_ba(balla);
                break;

            case 10:score_a = (score_a+2);
                display_runa(2);
                display_a(score_a);
                display_ba(balla);
                break;

            case 11:score_a = (score_a+3);
                display_runa(3);
                display_a(score_a);
                display_ba(balla);
                break;

            case 12:score_a = (score_a+4);
                display_runa(4);
                display_a(score_a);
                display_ba(balla);
                break;

            case 13:score_a = (score_a+6);
                display_runa(6);
                display_a(score_a);
                display_ba(balla);
                break;

            case 14:score_a = (score_a+0);
                wicket_a++;
                display_outa();
                display_a(score_a);
                display_wa(wicket_a);
                display_ba(balla);
                break;

            case 15:score_a = (score_a+0);
                display_runa(0);
                display_a(score_a);
                display_ba(balla);
                break;

            case 16:score_a = (score_a+1);
                display_runa(1);
                display_a(score_a);
                display_ba(balla);
                break;

            case 17:score_a = (score_a+2);
                display_runa(2);
                display_a(score_a);
                display_ba(balla);
                break;

            case 18:score_a = (score_a+4);
                display_runa(4);
                display_a(score_a);
                display_ba(balla);
                break;

            case 19:score_a = (score_a+6);
                display_runa(6);
                display_a(score_a);
                display_ba(balla);
                break;

            case 20:score_a = (score_a+0);
                wicket_a++;
                display_outa();
                display_a(score_a);
                display_wa(wicket_a);
                display_ba(balla);
                break;

            case 21:score_a = (score_a+0);
                display_runa(0);
                display_a(score_a);
                display_ba(balla);
                break;

            case 22:score_a = (score_a+1);
                display_runa(1);
                display_a(score_a);
                display_ba(balla);
                break;

            case 23:score_a = (score_a+2);
                display_runa(2);
                display_a(score_a);
                display_ba(balla);
                break;

            case 24:score_a = (score_a+4);
                display_runa(4);
                display_a(score_a);
                display_ba(balla);
                break;

            case 25:score_a = (score_a+0);
                wicket_a++;
                display_outa();
                display_a(score_a);
                display_wa(wicket_a);
                display_ba(balla);
                break;

            case 26:score_a = (score_a+0);
                display_runa(0);
                display_a(score_a);
                display_ba(balla);
                break;

            case 27:score_a = (score_a+1);
                display_runa(1);
                display_a(score_a);
                display_ba(balla);
                break;

            case 28:score_a = (score_a+2);
                display_runa(2);
                display_a(score_a);
                display_ba(balla);
                break;

            case 29:score_a = (score_a+0);
                display_runa(0);
                display_a(score_a);
                display_ba(balla);
                break;

        }
    }



    // score of team b

    private void scoreb(int number) {
        switch (number) {
            case 0: score_b = (score_b+0);
                display_runb(0);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 1:score_b = (score_b+1);
                display_runb(1);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 2:score_b = (score_b+2);
                display_runb(2);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 3:score_b = (score_b+3);
                display_runb(3);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 4:score_b = (score_b+4);
                display_runb(4);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 5:score_b = (score_b+5);
                display_runb(5);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 6:score_b = (score_b+6);
                display_runb(6);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 7:score_b = (score_b+0);
                wicket_b++;
                display_outb();
                display_b(score_b);
                display_wb(wicket_b);
                display_bb(ballb);
                break;

            case 8:score_b = (score_b+0);
                display_runb(0);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 9:score_b = (score_b+1);
                display_runb(1);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 10:score_b = (score_b+2);
                display_runb(2);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 11:score_b = (score_b+3);
                display_runb(3);
                display_bb(ballb);
                break;

            case 12:score_b = (score_b+4);
                display_runb(4);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 13:score_b = (score_b+6);
                display_runb(6);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 14:score_b = (score_b+0);
                wicket_b++;
                display_outb();
                display_b(score_b);
                display_wb(wicket_b);
                display_bb(ballb);
                break;

            case 15:score_b = (score_b+0);
                display_runb(0);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 16:score_b = (score_b+1);
                display_runb(1);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 17:score_b = (score_b+2);
                display_runb(2);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 18:score_b = (score_b+4);
                display_runb(4);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 19:score_b = (score_b+6);
                display_runb(6);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 20:score_b = (score_b+0);
                wicket_b++;
                display_outb();
                display_b(score_b);
                display_wb(wicket_b);
                display_bb(ballb);
                break;

            case 21:score_b = (score_b+0);
                display_runb(0);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 22:score_b = (score_b+1);
                display_runb(1);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 23:score_b = (score_b+2);
                display_runb(2);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 24:score_b = (score_b+4);
                display_runb(4);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 25:score_b = (score_b+0);
                wicket_b++;
                display_outb();
                display_b(score_b);
                display_wb(wicket_b);
                display_bb(ballb);
                break;

            case 26:score_b = (score_b+0);
                display_runb(0);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 27:score_b = (score_b+1);
                display_runb(1);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 28:score_b = (score_b+2);
                display_runb(2);
                display_b(score_b);
                display_bb(ballb);
                break;

            case 29:score_b = (score_b+0);
                display_runb(0);
                display_b(score_b);
                display_bb(ballb);
                break;

        }
    }



}
