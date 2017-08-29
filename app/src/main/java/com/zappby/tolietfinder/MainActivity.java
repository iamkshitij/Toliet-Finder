package com.zappby.tolietfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText toiletName,toiletAddress;
    Spinner hygieneMeter;
    Button sendTodB;
    DatabaseReference databaseToilet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toiletName = (EditText) findViewById(R.id.location_name);
        toiletAddress= (EditText) findViewById(R.id.location_address);
        hygieneMeter = (Spinner) findViewById(R.id.hygeneMeter);
        sendTodB = (Button) findViewById(R.id.sendTodB);
        databaseToilet = FirebaseDatabase.getInstance().getReference("Toilets");


        sendTodB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToiletInfo();
            }
        });

    }

    private void addToiletInfo() {
        String name = toiletName.getText().toString().trim();
        String address = toiletAddress.getText().toString().trim();
        String rating = hygieneMeter.getSelectedItem().toString();
        String key = databaseToilet.push().getKey();
        ToiletModel model = new ToiletModel(key,name,address,rating);

        databaseToilet.child(key).setValue(model);
        Toast.makeText(this, "Toilet Added", Toast.LENGTH_SHORT).show();


    }
}
