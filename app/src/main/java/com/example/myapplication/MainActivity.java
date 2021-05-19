package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView clientImage;
    EditText etName;
    EditText etSkill;
    EditText etJob;
    EditText etPhoneNumber;
    EditText etWhereSeen;
    EditText etDescription;
    Button btnRegister;

    ClientInfo clientInfo;
    Animation buttonAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        init();
        config();

    }

    private void findViews() {

        clientImage=findViewById(R.id.client_image);

        etName=findViewById(R.id.et_name);
        etSkill=findViewById(R.id.et_skill);
        etJob=findViewById(R.id.et_job);
        etPhoneNumber=findViewById(R.id.et_phone_number);
        etWhereSeen=findViewById(R.id.et_where_seen);
        etDescription=findViewById(R.id.et_description);

        btnRegister=findViewById(R.id.btn_register);


    }

    private void init() {

        clientInfo=new ClientInfo();
        buttonAnimation= AnimationUtils.loadAnimation(this,R.anim.button_animation);

    }

    private void config() {

        btnRegister.setOnClickListener(v -> {


            btnRegister.startAnimation(buttonAnimation);
            getDateFromClient(clientInfo);

        });

    }

    private void getDateFromClient(ClientInfo clientInfo) {

        if(evaluate()){

         //   clientInfo.ImageAddress=clientImage.getResources().toString();

            clientInfo.name=etName.getText().toString().trim();
            clientInfo.skill=etSkill.getText().toString().trim();
            clientInfo.job=etJob.getText().toString().trim();
            clientInfo.phoneNumber=etPhoneNumber.getText().toString().trim();
            clientInfo.whereSeen=etWhereSeen.getText().toString().trim();
            clientInfo.description=etDescription.getText().toString().trim();

            Toast.makeText(this, "اطلاعات با موفقیت ذخیره شد", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean evaluate() {

        if (etName.getText().length()==0
        ||etSkill.getText().length()==0
        ||etJob.getText().length()==0
        ||etPhoneNumber.getText().length()==0
        ||etWhereSeen.getText().length()==0
        ||etDescription.getText().length()==0){

            showError();
            return false;
        }

        else
        return  true;
    }

    private void showError() {

        Toast.makeText(this, "لطفا همه فیلد ها را وارد کنید", Toast.LENGTH_SHORT).show();
    }

}