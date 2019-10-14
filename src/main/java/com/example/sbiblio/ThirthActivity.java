package com.example.sbiblio;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ThirthActivity extends AppCompatActivity {
    SQLiteDatabase db;
    public final static String EXTRA_MESSAGE = "cle";
    EditText ec1, ec2,ec3, ec4;
    Button bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirth);


        db = openOrCreateDatabase("BD", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS livre(num INTEGER PRIMARY KEY AUTOINCREMENT,NomLivre VARCHAR,Auteur VARCHAR,Prix VARCHAR);");

        ec1 = (EditText) findViewById(R.id.eee1);
        ec2= (EditText) findViewById(R.id.eee2);
        ec3= (EditText) findViewById(R.id.eee3);
        ec4= (EditText) findViewById(R.id.eee4);
        bc = (Button) findViewById(R.id.bbb);

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ec1.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(),"Entrer le nom de livre",Toast.LENGTH_LONG).show();
                    return;
                }


                Cursor c = db.rawQuery("SELECT * FROM livre WHERE NomLivre='" + ec1.getText() + "'", null);
                if (c.moveToFirst()) {

                    ec2.setText(c.getString(1));
                    ec3.setText(c.getString(2));
                    ec4.setText(c.getString(3));

                    Intent intent = new Intent(ThirthActivity.this, ChercherActivity.class);
                    String st = "Nom de livre : " + ec2.getText() + "\n\n" + "L'auteur : " + ec3.getText() + "\n\n" + "Le prix : " + ec4.getText() + "\n\n";
                    intent.putExtra(EXTRA_MESSAGE, st);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"Nom de livre invalide",Toast.LENGTH_LONG).show();
                }
            }

        });
    }

}
