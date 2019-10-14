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

public class SixthActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText eed1, eed2, eed3, eed4;
    Button bed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        db = openOrCreateDatabase("BD", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS livre(num INTEGER PRIMARY KEY AUTOINCREMENT, NomLivre VARCHAR,Auteur VARCHAR,Prix VARCHAR);");

        eed1 = (EditText) findViewById(R.id.eeeeee1);
        eed2 = (EditText) findViewById(R.id.eeeeee2);
        eed3 = (EditText) findViewById(R.id.eeeeee3);
        eed4 = (EditText) findViewById(R.id.eeeeee4);
        bed = (Button) findViewById(R.id.bbbbbb1);
        bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (eed1.getText().toString().trim().length() == 0) {
                    Toast.makeText(getApplicationContext(),"Entrer le nom de livre",Toast.LENGTH_LONG).show();
                    return;
                }
                Cursor c = db.rawQuery("SELECT * FROM livre WHERE NomLivre='" + eed1.getText() + "'", null);
                if (c.moveToFirst()) {
                    db.execSQL("UPDATE livre SET NomLivre ='" + eed2.getText() + "', Auteur='" + eed3.getText() + "',Prix='" + eed4.getText() + "' WHERE NomLivre ='" + eed1.getText() + "'");
                    Toast.makeText(getApplicationContext(),"Livre modifie",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"Nom de Livre invalide",Toast.LENGTH_LONG).show();
                }
            }


        });
    }
}

