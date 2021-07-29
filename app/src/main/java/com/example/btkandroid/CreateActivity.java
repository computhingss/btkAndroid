package com.example.btkandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.btkandroid.db.DaoMaster;
import com.example.btkandroid.db.DaoSession;
import com.example.btkandroid.db.Person;
import com.google.android.material.textfield.TextInputEditText;

import org.greenrobot.greendao.database.Database;

public class CreateActivity extends AppCompatActivity {
    private TextInputEditText name,surname,identityNumber,motherName,fatherName;
    private Button save;
    DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        initViews();
        initDb();
    }

    private void initDb() {
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"person-db");
        DaoMaster master=new DaoMaster(helper.getWritableDatabase());
        session=master.newSession();
    }

    private void initViews(){
        name=findViewById(R.id.name);
        surname=findViewById(R.id.surname);
        identityNumber=findViewById(R.id.identityNumber);
        motherName=findViewById(R.id.motherName);
        fatherName=findViewById(R.id.fatherName);
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerson();
            }
        });
    }
    private void savePerson() {
        Person person =new Person();
        person.setName(name.getText().toString());
        person.setSurname(surname.getText().toString());
        person.setFatherName(fatherName.getText().toString());
        person.setIdentityNumber(identityNumber.getText().toString());
        person.setMotherName(motherName.getText().toString());
        session.getPersonDao().insert(person);
        finish();
    }

}
