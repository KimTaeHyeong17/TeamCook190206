package com.example.uuzaz.teamcook04_1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email_login;
    EditText pwd_login;
    Button signup, login;
    FirebaseAuth firebaseAuth;
    //두번눌러 종료
    private BackPressCloseHandler backpressclosehandler;

    //두번눌러 종료
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backpressclosehandler.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email_login = (EditText) findViewById(R.id.loginactivity_edittext_email);
        pwd_login = (EditText) findViewById(R.id.loginactivity_edittext_password);
        signup = (Button) findViewById(R.id.loginactivity_button_signup);
        login = (Button) findViewById(R.id.loginactivity_button_login);

        firebaseAuth = firebaseAuth.getInstance();
        backpressclosehandler = new BackPressCloseHandler(this); //두번눌러 종료


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                //finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력값 string 으로 변환
                String email = email_login.getText().toString().trim();
                String pwd = pwd_login.getText().toString().trim();

                //null point handler
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd) ){
                    Toast.makeText(LoginActivity.this,"이메일과 비밀번호를 입력해주세요",Toast.LENGTH_LONG).show();
                }
                else {
                    //null 입력시 에러남
                    firebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "로그인오류", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }/**else**/
            }//Onclick
        });//login.setonclickListener
    }/**end of Oncreate**/


}
