package com.example.uuzaz.teamcook04_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class Main_Fragment_TeamSearch_Detail extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.activity_main__fragment__team_search__detail);

        findViewById(R.id.back_btn_x02).setOnClickListener(this);
        findViewById(R.id.apply_btn).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_btn_x02 :
                this.finish();
                break;
            case R.id.apply_btn :
                Toast.makeText(Main_Fragment_TeamSearch_Detail.this, "팀원 요청이 발송되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
