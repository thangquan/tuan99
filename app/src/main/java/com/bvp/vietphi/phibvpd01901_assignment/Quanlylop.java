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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Quanlylop extends AppCompatActivity {
    Button bntadd , bntedit,bntdelete;
    EditText edid;
    EditText edname;
    TextView tvcount;
    ListView lsView;
    ArrayList<ClassManager> lsClass = new ArrayList<>();
    ArrayList<ClassManager> arrayAdapter;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlylop);
        edid = (EditText) findViewById(R.id.edidlop);
        edname = (EditText) findViewById(R.id.edtenlop);
        tvcount = (TextView) findViewById(R.id.tvcount) ;
        lsClass.add(new ClassManager("PT01","MOB"));
        lsClass.add(new ClassManager("PT01","MOB"));
        lsClass.add(new ClassManager("PT01","MOB"));
        bntadd = (Button) findViewById(R.id.btnadd);
        bntedit = (Button) findViewById(R.id.btnedit);
        bntdelete = (Button) findViewById(R.id.btndelete);
        lsView = (ListView) findViewById(R.id.lsView);
        final ArrayAdapter<ClassManager> arrayAdapter=
                new ArrayAdapter<ClassManager>(this,android.R.layout.simple_list_item_1,lsClass);
        lsView.setAdapter(arrayAdapter);
        bntadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassManager c = new ClassManager();
                c.setId(edid.getText().toString());
                c.setName(edname.getText().toString());
                lsClass.add(c);
                tvcount.setText("Count : "+lsClass.size());
                arrayAdapter.notifyDataSetChanged();
                edid.setText(" ");
                edname.setText(" ");
            }
        });
        lsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item"+position,Toast.LENGTH_SHORT).show();
                ClassManager c = lsClass.get(position);
                edid.setText(c.getId());
                edname.setText(c.getName());
                vitri = position;
            }
        });
      bntedit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              ClassManager c = new ClassManager();
              c.setId(edid.getText().toString());
              c.setName(edname.getText().toString());
              lsClass.set(vitri,c);
              arrayAdapter.notifyDataSetChanged();
          }
      });
        bntdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edid.setText(" ");
                edname.setText(" ");
                lsClass.remove(vitri);
                arrayAdapter.notifyDataSetChanged();
                tvcount.setText("Count : "+lsClass.size());
            }
        });

    }
}
