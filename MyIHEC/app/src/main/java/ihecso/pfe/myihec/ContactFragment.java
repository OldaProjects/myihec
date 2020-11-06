package ihecso.pfe.myihec;

import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private ContactViewModel mViewModel;
    private  View root ;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root =   inflater.inflate(R.layout.contact_fragment, container, false);;
        List<ContactItem> image_details = getListData();
        final ListView listView = (ListView) root.findViewById(R.id.listView);
        listView.setAdapter(new ContactAdapter(getContext(), image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                ContactItem country = (ContactItem) o;
                Toast.makeText(getContext(), country.toString(), Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }

    private  List<ContactItem> getListData() {
        List<ContactItem> list = new ArrayList<ContactItem>();
        ContactItem adresse = new ContactItem("Adresse", "ic_adresse","Route Hzamia Sahloul 3 - BP n° 40 - 4054 Sousse - 4054 Sousse");
        ContactItem email = new ContactItem("Email", "ic_email","ihecsousse@ihecso.rnu.tn");
        ContactItem telephone = new ContactItem("Téléphone", "ic_tel","+216 73 368 351 - 73 368 358");
        ContactItem fax = new ContactItem("Fax", "ic_fax","+216 73 368 350");

        list.add(adresse);
        list.add(email);
        list.add(telephone);
        list.add(fax);
        return list;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        // TODO: Use the ViewModel
    }

}