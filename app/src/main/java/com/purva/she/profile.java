package com.purva.she;


import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dell on 04/11/2017.
 */

public class profile extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText fName,lname,start,end;
    Button submitBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = DatabaseHelper.getInstance(this);

        fName = (EditText) findViewById(R.id.firstNameField);
        lname = (EditText) findViewById(R.id.lastNameField);
        start = (EditText) findViewById(R.id.startOfMonthField);
        end= (EditText) findViewById(R.id.endOfMonthField);
        submitBtn = (Button)findViewById(R.id.submitButton);
        UpdateData();
    }

    public void UpdateData() {
        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override

                        public void onClick(View v) {
                            boolean isUpdate = myDb.updateData(fName.getText().toString(),
                                    lname.getText().toString(),
                                    start.getText().toString(),end.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(profile.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(profile.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
