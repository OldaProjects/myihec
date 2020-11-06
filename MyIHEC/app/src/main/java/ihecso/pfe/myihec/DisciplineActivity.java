package ihecso.pfe.myihec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisciplineActivity extends AppCompatActivity {

    DiscilineListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> disciplineList;
    HashMap<String, List<String>> dateabscenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.eListview);

        showList();


        listViewAdapter = new DiscilineListViewAdapter(this, disciplineList, dateabscenceList);
        expandableListView.setAdapter(listViewAdapter);
    }

    private void showList() {

        disciplineList = new ArrayList<String>();
        dateabscenceList = new HashMap<String, List<String>>();

        disciplineList.add("Management International " +
                "(TD)");
        disciplineList.add("Anglais (CI)");
        disciplineList.add("Gestion des projets (TD)");
        disciplineList.add("Théorie de la descision " +
                "(cours)");
        disciplineList.add("Controle de gestion (CI)");

        List<String> topic1 = new ArrayList<>();
        topic1.add("01/11/2019");

        List<String> topic2 = new ArrayList<>();
        topic2.add("01/11/2019");
        topic2.add("15/11/2019");
        topic2.add("05/12/2019");

        List<String> topic3 = new ArrayList<>();
        topic3.add("01/10/2019");
        topic3.add("15/11/2019");
        topic3.add("02/12/2019");
        topic3.add("03/12/2019");
        topic3.add("07/12/2019");


        List<String> topic4 = new ArrayList<>();
        topic4.add("01/10/2019");
        topic4.add("21/10/2019");

        List<String> topic5 = new ArrayList<>();
        topic5.add("30/10/2019");

        dateabscenceList.put(disciplineList.get(0), topic1);
        dateabscenceList.put(disciplineList.get(1), topic2);
        dateabscenceList.put(disciplineList.get(2), topic3);
        dateabscenceList.put(disciplineList.get(3), topic4);
        dateabscenceList.put(disciplineList.get(4), topic5);


    }
}