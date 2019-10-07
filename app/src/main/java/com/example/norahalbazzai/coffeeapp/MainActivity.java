package com.example.norahalbazzai.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  // To move to the first activity
    public void moveTofrstAct(View v){

        Intent i = new Intent(getApplicationContext(), frstActivity.class);
        startActivityForResult(i,1);

    }

    // To move to the second activity
    public void moveToSecAct(View v) {
        Intent i = new Intent(getApplicationContext(), secActivity.class);
        startActivityForResult(i, 2);
    }


    // To open intent with data and read the result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        // To check if the operation is successful and the it's my result
        if(resultCode == RESULT_OK && requestCode == 1){

            // To extract data from intent
            String order = "Order is: "+ data.getStringExtra("coffee_Type") +
                    data.getStringExtra("addTo_Coffee");

            // Display result as toast message
            Toast.makeText(getApplicationContext(),
                    order,
                    Toast.LENGTH_LONG).show();
        }

        else if(resultCode == RESULT_OK && requestCode == 2){
            // Homework
        }
    }
}
