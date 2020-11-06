package ihecso.pfe.myihec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private ArrayList<Item> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new Adapter(items,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items.add(new Item(R.drawable.croissantrouge,getString(R.string.covid),getString(R.string.covid_desc)));
        items.add(new Item(R.drawable.rappel,getString(R.string.rappel),getString(R.string.rappel_desc)));
        items.add(new Item(R.drawable.aviis,getString(R.string.avis),getString(R.string.avis_desc)));
        items.add(new Item(R.drawable.aviis,getString(R.string.stage),getString(R.string.stage_desc)));


    }
}