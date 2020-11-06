package ihecso.pfe.myihec.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import ihecso.pfe.myihec.DisciplineActivity;
import ihecso.pfe.myihec.EmploiEtudiantActivity;
import ihecso.pfe.myihec.EventActivity;
import ihecso.pfe.myihec.GroupActivity;
import ihecso.pfe.myihec.NewsActivity;
import ihecso.pfe.myihec.R;
import ihecso.pfe.myihec.ResultatActivity;
import ihecso.pfe.myihec.TeacherEmploiActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private String user ="Olfa";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = null;

        /*Bundle b = getArguments();
        String user  = b.getString("user");*/

        if (user.equals("Olfaa")) {
            root = inflater.inflate(R.layout.fragment_teacher_menu, container, false);
            LinearLayout news_layout = (LinearLayout) root.findViewById(R.id.layout_news);
            news_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), NewsActivity.class);
                    startActivity(intentMain);
                }
            });

            LinearLayout emploi_layout = (LinearLayout) root.findViewById(R.id.layout_emploi);
            emploi_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), TeacherEmploiActivity.class);
                    startActivity(intentMain);
                }
            });

            LinearLayout group_layout = (LinearLayout) root.findViewById(R.id.layout_group);
            group_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), GroupActivity.class);
                    startActivity(intentMain);
                }
            });
        } else {
            root = inflater.inflate(R.layout.fragment_student_menu, container, false);

            LinearLayout news_layout = (LinearLayout) root.findViewById(R.id.layout_news);
            news_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), NewsActivity.class);
                    startActivity(intentMain);
                }
            });

            LinearLayout emploi_layout = (LinearLayout) root.findViewById(R.id.layout_emploi);
            emploi_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), EmploiEtudiantActivity.class);
                    startActivity(intentMain);
                }
            });

            LinearLayout discipline_layout = (LinearLayout) root.findViewById(R.id.layout_discipline);
            discipline_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), DisciplineActivity.class);
                    startActivity(intentMain);
                }
            });

            LinearLayout result_layout = (LinearLayout) root.findViewById(R.id.layout_result);
            result_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), ResultatActivity.class);
                    startActivity(intentMain);
                }
            });

            LinearLayout event_layout = (LinearLayout) root.findViewById(R.id.layout_event);
            event_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentMain = new Intent(getActivity(), EventActivity.class);
                    startActivity(intentMain);
                }
            });
        }


        return root;

    }
}