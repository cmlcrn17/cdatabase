package databaseexample.databaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class TalepListele extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talep_listele);

        final ListView lList_o = (ListView) findViewById(R.id.lList2);
        CDatabase veritabani = new CDatabase(this);
        List<String> Veriler = veritabani.VeriListele();

        ArrayAdapter<String> adapter = new  ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Veriler);

        lList_o.setAdapter(adapter);


    }

}
