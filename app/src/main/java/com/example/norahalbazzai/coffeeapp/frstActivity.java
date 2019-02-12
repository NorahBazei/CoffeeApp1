package com.example.norahalbazzai.coffeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class frstActivity extends AppCompatActivity {

    private String coffeeType;
    private String addToCoffee;
    private CheckBox cre;
    private CheckBox sug;
    private Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frst);

        // To read user additions ( Cream & Sugar )
        cre = (CheckBox) findViewById(R.id.creamChkBox);
        sug = (CheckBox) findViewById(R.id.sugarChkBox);


        // To add listener
        btnOrder = (Button) findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addToCoffee = "";

                // To check if user selects cream and sugar
                if(cre.isChecked())
                    addToCoffee = " ... Cream added";
                if(sug.isChecked())
                    addToCoffee += "... Sugar added";


                Intent returnIntent = new Intent();

                // Add data to intent
                returnIntent.putExtra("coffee_Type", coffeeType);
                returnIntent.putExtra("addTo_Coffee", addToCoffee);

                setResult(RESULT_OK, returnIntent);

                finish();

            }
        });
    }


// To read coffee seclection and store it in a string coffeeType
    public void selectCoffee( View V){

        switch (V.getId()){

            case R.id.radioDecaf:
                coffeeType = "Decaf";
                break;

            case R.id.radioExpresso:
                coffeeType = "Espresso";
                break;

            case R.id.radioColombian:
                coffeeType = "Colombian";
                break;
        }

    }
}
