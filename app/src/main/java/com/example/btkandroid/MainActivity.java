package com.example.btkandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.btkandroid.db.DaoMaster;
import com.example.btkandroid.db.DaoSession;
import com.example.btkandroid.db.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DaoSession session;
    private RecyclerView personRcycler;
    private PersonAdapter personAdapter;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDb();
        initRcyclerView();
        initFab(); }

    private void initFab() {
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CreateActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initRcyclerView() {
        personRcycler=findViewById(R.id.personRecyler);
        LinearLayoutManager manager= new LinearLayoutManager(this);
        personRcycler.setLayoutManager(manager);
        personAdapter=new PersonAdapter();
        personRcycler.setAdapter(personAdapter);
    }

    private void initDb() {
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"person-db");
        DaoMaster master=new DaoMaster(helper.getWritableDatabase());
        session=master.newSession();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPersons();
    }

    private void getPersons() {
        List<Person> personList=session.getPersonDao().loadAll();
        personAdapter.setList(personList);
    }
}
