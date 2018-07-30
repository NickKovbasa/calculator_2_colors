package com.example.kolyakb.calculator_2;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    AnimationDrawable anim;
    LinearLayout container;

    Button btn_c, btn_plusMinus, btn_percent, btn_division, btn_7, btn_8, btn_9, btn_multiply, btn_4, btn_5, btn_6, btn_minus, btn_dot, btn_0, btn_enter, btn_3, btn_2, btn_1, btn_plus;

  static   TextView text_1, text_2, text_3;

   static String symbol_1, symbol_2, symbol_3;
   static String lastOperation;

   static Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_0 = findViewById(R.id.id_0);
        btn_1 = findViewById(R.id.id_1);
        btn_2 = findViewById(R.id.id_2);
        btn_3 = findViewById(R.id.id_3);
        btn_4 = findViewById(R.id.id_4);
        btn_5 = findViewById(R.id.id_5);
        btn_6 = findViewById(R.id.id_6);
        btn_7 = findViewById(R.id.id_7);
        btn_8 = findViewById(R.id.id_8);
        btn_9 = findViewById(R.id.id_9);
        btn_c = findViewById(R.id.id_c);
        btn_plus = findViewById(R.id.id_plus);
        btn_division = findViewById(R.id.id_division);
        btn_percent = findViewById(R.id.id_percent);
        btn_plusMinus = findViewById(R.id.id_plus_minus);
        btn_multiply = findViewById(R.id.id_multiply);
        btn_minus = findViewById(R.id.id_minus);
        btn_dot = findViewById(R.id.id_dot);
        btn_enter = findViewById(R.id.id_enter);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_division.setOnClickListener(this);
        btn_percent.setOnClickListener(this);
        btn_plusMinus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_enter.setOnClickListener(this);

        text_1 = findViewById(R.id.id_text_1);
        text_2 = findViewById(R.id.id_text_2);
        text_3 = findViewById(R.id.id_text_3);

        symbol_1 = "";
        symbol_2 = "";
        symbol_3 = "";
        lastOperation = "";
        result = 0.0;

        container = findViewById(R.id.container);

        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(6000);
        anim.setExitFadeDuration(2000);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (anim != null  && anim.isRunning())
            anim.stop();
    }

    @Override
    public void onClick(View view) {


       switch(view.getId()){

           case R.id.id_0:
               if (!symbol_1.equals("") || !lastOperation.equals("")){
                   symbol_1 += "0";

                   text_2.setText(symbol_1);
               }

               break;
           case R.id.id_1:
                   symbol_1 += "1";

                   text_2.setText(symbol_1);

               break;
           case R.id.id_2:
               symbol_1 += "2";

               text_2.setText(symbol_1);

               break;
           case R.id.id_3:
               symbol_1 += "3";

               text_2.setText(symbol_1);

               break;
           case R.id.id_4:
               symbol_1 += "4";

               text_2.setText(symbol_1);

               break;
           case R.id.id_5:
               symbol_1 += "5";

               text_2.setText(symbol_1);

               break;
           case R.id.id_6:
               symbol_1 += "6";

               text_2.setText(symbol_1);

               break;
           case R.id.id_7:
               symbol_1 += "7";

               text_2.setText(symbol_1);

               break;
           case R.id.id_8:
               symbol_1 += "8";

               text_2.setText(symbol_1);

               break;
           case R.id.id_9:
               symbol_1 += "9";

               text_2.setText(symbol_1);

               break;
           case R.id.id_dot:
               if (symbol_1.equals("")){
                   symbol_1 = "0.";
               } else {
                   symbol_1 += ".";
               }


               text_2.setText(symbol_1);

               break;
           case R.id.id_plus_minus:
               try{
                   if (symbol_1.equals("")){
                       symbol_1 = "-";
                       text_2.setText(symbol_1);
                   } else if (Double.parseDouble(symbol_1.toString()) > 0){
                       symbol_1 = "-" + symbol_1;
                       text_2.setText(symbol_1);
                   } else if (Double.parseDouble(symbol_1.toString()) < 0){
                       symbol_1 = Math.abs(Double.parseDouble(symbol_1.toString())) + "";
                       text_2.setText(symbol_1);

                   } else text_2.setText("Error");
               } catch (Exception e){
                   text_2.setText("Error");
               }

               break;
           case R.id.id_c:
               symbol_1 = "";
               symbol_2 = "";
               lastOperation = "";
               text_1.setText("");
               text_2.setText("");
               text_3.setText("");
               result = 0.0;


               break;

           case R.id.id_plus:
               if (!symbol_1.equals("")){
                   symbol_2 += symbol_1 + " + ";
                   text_1.setText(symbol_2);
                   text_2.setText("+");

                   symbol_3 = symbol_1;
                   symbol_1 = "";
                   lastOperation = "+";
               }

               break;

           case R.id.id_minus:
               if (!symbol_1.equals("")){
                   symbol_2 += symbol_1 + " - ";
                   text_1.setText(symbol_2);
                   text_2.setText("-");

                   symbol_3 = symbol_1;
                   symbol_1 = "";
                   lastOperation = "-";
               }
               break;
           case R.id.id_division:
               if (!symbol_1.equals("")){
                   symbol_2 += symbol_1 + " \u00F7 ";
                   text_1.setText(symbol_2);
                   text_2.setText("\u00F7");

                   symbol_3 = symbol_1;
                   symbol_1 = "";
                   lastOperation = "\u00F7";
               }
               break;
           case R.id.id_multiply:
               if (!symbol_1.equals("")){
                   symbol_2 += symbol_1 + " x ";
                   text_1.setText(symbol_2);
                   text_2.setText("x");

                   symbol_3 = symbol_1;
                   symbol_1 = "";
                   lastOperation = "x";
               }
               break;
           case R.id.id_percent:
               if (!symbol_1.equals("")){
                   symbol_2 += symbol_1 + " % ";
                   text_1.setText(symbol_2);
                   text_2.setText("%");

                   symbol_3 = symbol_1;
                   symbol_1 = "";
                   lastOperation = "%";
               }
               break;

           case R.id.id_enter:
               if (!symbol_1.equals("")){
                  ourResult(symbol_3, text_2.getText().toString(), lastOperation);
                  text_2.setText(result.toString());

                   text_1.setText("");

                   symbol_1 = "";
                   symbol_2 = "";
                   lastOperation = "=";


               }


               break;
       }

    }

    public static void ourResult(String first, String second, String operation){

        switch (operation){

            case "+":
                result =  ((Double.parseDouble(first.toString()) + Double.parseDouble(second.toString()) + 0.000000));
                break;
            case "-":
                result =  ((Double.parseDouble(first) - Double.parseDouble(second)) + 0.000000);
                break;
            case "\u00F7":
                result =  ((Double.parseDouble(first) / Double.parseDouble(second)) + 0.000000);
                break;
            case "x":
                result =  ((Double.parseDouble(first) * Double.parseDouble(second)) + 0.000000);
                break;
            case "%":
                result =  ((Double.parseDouble(first) % Double.parseDouble(second)) + 0.000000);
                break;
        }


    }






}
