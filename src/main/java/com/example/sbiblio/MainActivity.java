package com.example.sbiblio;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity    {

    SQLiteDatabase db;
    Button button1,button2,button3,button4,button5;
    public final static String EXTRA_MESSAGE="cle";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("BD", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS livre(num INTEGER PRIMARY KEY AUTOINCREMENT,NomLivre VARCHAR,Auteur VARCHAR,Prix VARCHAR);");


        button1 = (Button) findViewById(R.id.b1);
        button2 = (Button) findViewById(R.id.b2);
        button3 = (Button) findViewById(R.id.b3);
        button4 = (Button) findViewById(R.id.b4);
        button5 = (Button) findViewById(R.id.b5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor c = db.rawQuery("SELECT * FROM livre", null);

                if (c.getCount() == 0) {
                    Toast.makeText(getApplicationContext(),"Il n'y a pas de livres",Toast.LENGTH_LONG).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()) {
                    buffer.append("Nom de livre: " + c.getString(1) + "\n");
                    buffer.append("Nom d'auteur: " + c.getString(2) + "\n");
                    buffer.append("Prix de livre: " + c.getString(3) + "\n\n");
                }
                Intent intent = new Intent(MainActivity.this, LivresActivity.class);
                String b = buffer.toString();
                intent.putExtra(EXTRA_MESSAGE, b);
                startActivity(intent);

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, ThirthActivity.class);
                startActivity(intent2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, ForthActivity.class);
                startActivity(intent3);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, FifthActivity.class);
                startActivity(intent4);




            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainActivity.this, SixthActivity.class);
                startActivity(intent5);



            }

        });




    }
}


