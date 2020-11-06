package ihecso.pfe.myihec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class DiscilineListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> disciplineList; // String type list
    private HashMap<String, List<String>> dateabscenceList;

    public DiscilineListViewAdapter(Context context, List<String> disciplineList, HashMap<String, List<String>> dateabscenceList) {
        this.context = context;
        this.disciplineList = disciplineList;
        this.dateabscenceList = dateabscenceList;
    }

    @Override
    public int getGroupCount() {
        return this.disciplineList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.dateabscenceList.get(this.disciplineList.get(groupPosition)).size();

    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.disciplineList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.dateabscenceList.get(this.disciplineList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String chapterView = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.discipline_list, null);

        }

        TextView listdiscp = convertView.findViewById(R.id.list_discp);
        listdiscp.setText(chapterView);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String topics = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.date_abcsence_list, null);

        }

        TextView listabsc = convertView.findViewById(R.id.list_absc);
        listabsc.setText(topics);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
