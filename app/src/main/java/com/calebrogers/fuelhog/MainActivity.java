package com.calebrogers.fuelhog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // variables for user input
    private EditText distanceTraveled;
    private EditText fuelUsed;
    private Button calculateEfficiency;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // hook up layout fields with class variables
        distanceTraveled = (EditText) findViewById(R.id.editDistanceTraveled);
        fuelUsed = (EditText) findViewById(R.id.editFuelUsed);
        calculateEfficiency = (Button) findViewById(R.id.btnCalculateEfficiency);
        resultView = (TextView) findViewById(R.id.txtResult);

        calculateEfficiency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(distanceTraveled.getText().length() > 0 && fuelUsed.getText().length() > 0) {
                    double distanceInput = Double.parseDouble(distanceTraveled.getText().toString());
                    double fuelUsedInput = Double.parseDouble(fuelUsed.getText().toString());
                    double fuelEfficiency = distanceInput / fuelUsedInput;
                    String fuelEfficiencyFormatted;

                    // format the decmial points
                    DecimalFormat twoDecimalPlaces = new DecimalFormat("0.00");
                    fuelEfficiencyFormatted = twoDecimalPlaces.format(fuelEfficiency);

                    resultView.setText(fuelEfficiencyFormatted);
                }
                else {
                    // display error message for user
                    Toast.makeText(MainActivity.this, "Please enter a value into both fields.", Toast.LENGTH_LONG).show();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
