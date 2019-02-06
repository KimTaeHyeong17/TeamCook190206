package com.example.uuzaz.teamcook04_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Main_Feedback_ListViewAdapter extends BaseAdapter {
    private ArrayList<Main_Feedback_ListItem> listViewItemList = new ArrayList<Main_Feedback_ListItem>() ;

    // ListViewAdapter의 생성자
    public Main_Feedback_ListViewAdapter() {
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View View, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (View == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View = inflater.inflate(R.layout.listitem_main_feedback, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView feedback_nameTextView = (TextView) View.findViewById(R.id.feedback_name) ;
        TextView feedback_levelTextView = (TextView) View.findViewById(R.id.feedback_level) ;
        TextView feedback_rollTextView = (TextView) View.findViewById(R.id.feedback_roll) ;


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        Main_Feedback_ListItem main_feedback_listItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        feedback_nameTextView.setText(main_feedback_listItem.getFeedback_name());
        feedback_levelTextView.setText(main_feedback_listItem.getFeedback_level());
        feedback_rollTextView.setText(main_feedback_listItem.getFeedback_roll());


        return View;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String feedback_name, String feedback_level, String feedback_roll) {
        Main_Feedback_ListItem item = new Main_Feedback_ListItem();

        item.setFeedback_name(feedback_name);
        item.setFeedback_level(feedback_level);
        item.setFeedback_roll(feedback_roll);

        listViewItemList.add(item);
    }
}

