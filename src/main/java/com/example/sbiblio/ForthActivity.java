package com.example.sbiblio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForthActivity extends AppCompatActivity   {
    SQLiteDatabase db;
    EditText es1;
    Button bs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        db = openOrCreateDatabase("BD", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS livre(num INTEGER PRIMARY KEY AUTOINCREMENT,NomLivre VARCHAR,Auteur VARCHAR,Prix VARCHAR);");

        es1 = (EditText) findViewById(R.id.eeee1);
        bs = (Button) findViewById(R.id.bbbb1);

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (es1.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(),"Entrer le nom de livre",Toast.LENGTH_LONG).show();
                    return;
                }
                Cursor c = db.rawQuery("SELECT * FROM livre WHERE NomLivre ='" + es1.getText() + "'", null);
                if (c.moveToFirst()) {
                    db.execSQL("DELETE FROM livre WHERE NomLivre ='" + es1.getText() + "'");
                    Toast.makeText(getApplicationContext(),"Livre Supprime",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Nom de Livre invalide",Toast.LENGTH_LONG).show();
                }


            }

        });
    }
}

