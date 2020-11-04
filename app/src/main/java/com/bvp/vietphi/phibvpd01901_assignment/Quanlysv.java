package com.bvp.vietphi.phibvpd01901_assignment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Quanlysv extends AppCompatActivity {
Button qllop , qlsv,dx;
    String user ="", pass = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlysv);
        qllop= (Button) findViewById(R.id.qllop);
        qlsv= (Button) findViewById(R.id.qlsv);
        dx = (Button) findViewById(R.id.dx);
        showLogin();
        if (user.length()==0 && pass.length()==0){
            Intent intent3 = new Intent(Quanlysv.this,MainActivity.class);
            startActivity(intent3);
        }
        //Buttom quản lý lớp
        qllop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Quanlysv.this,Quanlylop.class);
                startActivity(intent);
            }
        });
        //Buttom quản lý sinh viên
        qlsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(Quanlysv.this,Quanlysinhvien.class);
                startActivity(intent2);
            }
        });
        dx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Quanlysv.this,MainActivity.class);
                startActivity(intent4);
            }
        });
    }
    public void showLogin(){
        SharedPreferences sharedPre = getSharedPreferences("fileLogin",MODE_PRIVATE);
        boolean ck = sharedPre.getBoolean("Savetatus",false);
        if (ck) {
            user = sharedPre.getString("user", "");
            pass = sharedPre.getString("pass", "");

        }

    }
}
