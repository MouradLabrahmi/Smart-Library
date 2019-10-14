package com.example.sbiblio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FifthActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText e5, ee5, eee5;
    Button b5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);


        db = openOrCreateDatabase("BD", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS livre(num INTEGER PRIMARY KEY AUTOINCREMENT, NomLivre VARCHAR,Auteur VARCHAR,Prix VARCHAR);");

        e5 = (EditText) findViewById(R.id.eeeee1);
        ee5 = (EditText) findViewById(R.id.eeeee2);
        eee5 = (EditText) findViewById(R.id.eeeee3);
        b5 = (Button) findViewById(R.id.bbbbb1);

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (e5.getText().toString().trim().length() == 0 ||
                        ee5.getText().toString().trim().length() == 0 ||
                        eee5.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(), "veuillez entrer toutes les valeurs", Toast.LENGTH_LONG).show();
                    return;
                }
                db.execSQL("INSERT INTO livre(NomLivre,Auteur,Prix)VALUES('" + e5.getText() + "','" + ee5.getText() + "','" + eee5.getText() + "');");
                Toast.makeText(getApplicationContext(), "Livre ajoute", Toast.LENGTH_LONG).show();

            }


        });
    }
}

