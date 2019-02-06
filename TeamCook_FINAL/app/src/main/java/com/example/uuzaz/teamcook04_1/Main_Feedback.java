package com.example.uuzaz.teamcook04_1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class Main_Feedback extends Activity {
    ImageButton btn_back_main_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_feedback);
        btn_back_main_feedback = (ImageButton) findViewById(R.id.btn_back_main_feedback);


        btn_back_main_feedback.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main_Feedback.this, Main_Profile_Fragments_Second_TeamList_Detail.class);
                startActivity(intent);
                finish();
            }
        });

        Main_Feedback_ListViewAdapter adapter;
        ListView listView;

        //ListView02
        // Adapter 생성
        adapter = new Main_Feedback_ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listView = (ListView) findViewById(R.id.list_main_feedback) ;
        listView.setAdapter(adapter) ;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Main_Feedback.this,Feedback.class);
                startActivity(intent);
                finish();
            }
        });

        // 첫 번째 아이템 추가.
        adapter.addItem("최하윤","6","디자이너") ;
        // 두 번째 아이템 추가.
        adapter.addItem("김태형","7","개발자") ;
        // 세 번째 아이템 추가.
        adapter.addItem("이교원","3","개발자") ;
        // 네 번째 아이템 추가.
        adapter.addItem( "김기현","5","디자이너") ;



        return ;

    }
}
