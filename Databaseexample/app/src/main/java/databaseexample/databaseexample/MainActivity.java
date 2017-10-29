package databaseexample.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText tSubject_o = (EditText) findViewById(R.id.tSubject);
        final EditText tSummary_o = (EditText) findViewById(R.id.tSummary);
        Button bInsert_o = (Button) findViewById(R.id.bInsert);
        Button bListFull_o = (Button) findViewById(R.id.bListFull);
        final ListView lList_o = (ListView) findViewById(R.id.lList);



        bInsert_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CDatabase veritabani = new CDatabase(MainActivity.this); //yeni oluşturduğum CDatabase sınıfından, veritabani isminde değişken tanımlıyorum.
                veritabani.VeriEkle(tSubject_o.getText().toString(), tSummary_o.getText().toString());
            }
        });


        bListFull_o.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TalepListele .class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        });

    }
}
