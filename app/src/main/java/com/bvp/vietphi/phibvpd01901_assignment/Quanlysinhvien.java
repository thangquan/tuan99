package com.bvp.vietphi.phibvpd01901_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Quanlysinhvien extends AppCompatActivity {
    Button bntadd2 , bntedit2,bntdelete2;
    EditText tenSV, maSV , Age,email,phone,address;
    TextView tvcount2;
    ListView lsView2;
    ArrayList<Student> lsStudent = new ArrayList<>();
    ArrayList<Student> arrayAdapter;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlysinhvien);
        tenSV = (EditText) findViewById(R.id.tensv);
        maSV = (EditText) findViewById(R.id.masv);
        Age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        tvcount2 = (TextView) findViewById(R.id.tvcount2);
        lsStudent.add(new Student("Phi","1","20","phi@gmail.com","330255","đà nẵng"));
        lsStudent.add(new Student("Mậu","2","20","mau@gmail.com","123013","đà nẵng"));
        lsStudent.add(new Student("Hùng","3","20","hung@gmail.com","197557","đà nẵng"));
        bntadd2 = (Button) findViewById(R.id.btnadd2);
        bntedit2 = (Button) findViewById(R.id.btnedit2);
        bntdelete2 = (Button) findViewById(R.id.btndelete2);
        lsView2 = (ListView) findViewById(R.id.lsView2);
        final ArrayAdapter<Student> arrayAdapter=
                new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1,lsStudent);
        lsView2.setAdapter(arrayAdapter);
        bntadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student st = new Student();
                st.setTenSV(tenSV.getText().toString());
                st.setMaSV(maSV.getText().toString());
                st.setAge(Age.getText().toString());
                st.setEmail(email.getText().toString());
                st.setPhone(phone.getText().toString());
                st.setDiaChi(address.getText().toString());
                lsStudent.add(st);
                tvcount2.setText("Count : "+lsStudent.size());
                arrayAdapter.notifyDataSetChanged();
                tenSV.setText(" ");
                maSV.setText(" ");
                Age.setText(" ");
                email.setText(" ");
                phone.setText(" ");
                address.setText(" ");
            }
        });
        lsView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item"+position,Toast.LENGTH_SHORT).show();
                Student st = lsStudent.get(position);
                tenSV.setText(st.getTenSV());
                maSV.setText(st.getMaSV());
                Age.setText(st.getAge());
                email.setText(st.getEmail());
                phone.setText(st.getPhone());
                address.setText(st.getDiaChi());
                vitri = position;
            }
        });
        bntedit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student st = new Student();
                st.setTenSV(tenSV.getText().toString());
                st.setMaSV(maSV.getText().toString());
                st.setAge(Age.getText().toString());
                st.setEmail(email.getText().toString());
                st.setPhone(phone.getText().toString());
                st.setDiaChi(address.getText().toString());
                lsStudent.set(vitri,st);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        bntdelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenSV.setText(" ");
                maSV.setText(" ");
                Age.setText(" ");
                email.setText(" ");
                phone.setText(" ");
                address.setText(" ");
                lsStudent.remove(vitri);
                arrayAdapter.notifyDataSetChanged();
                tvcount2.setText("Count : "+lsStudent.size());
            }
        });
    }
}
