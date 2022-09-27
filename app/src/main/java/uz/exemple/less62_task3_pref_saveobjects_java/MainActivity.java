package uz.exemple.less62_task3_pref_saveobjects_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import uz.exemple.less62_task3_pref_saveobjects_java.managers.PrefsManager;
import uz.exemple.less62_task3_pref_saveobjects_java.model.MemberModel;

public class MainActivity extends AppCompatActivity {
    MemberModel member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        EditText et_memberName = findViewById(R.id.et_userName);
        EditText et_memberAge = findViewById(R.id.et_userAge);
        EditText et_memberEmail = findViewById(R.id.et_userEmail);
        Button b_save = findViewById(R.id.b_save);
        Button b_load = findViewById(R.id.b_load);
        TextView tv_resObj = findViewById(R.id.tv_resObj);
        TextView tv_res = findViewById(R.id.tv_res);
        Context context = this;

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_memberAge.getText().toString().isEmpty()){
                    String name = et_memberName.getText().toString().trim();
                    int age = Integer.parseInt(et_memberAge.getText().toString().trim());
                    String email = et_memberEmail.getText().toString().trim();

                    member = new MemberModel(name,age,email);
                    Gson gson = new Gson();
                    String json = gson.toJson(member);
                    PrefsManager.getInstance(context).saveData("member",json);

                    et_memberName.setText("");
                    et_memberAge.setText("");
                    et_memberEmail.setText("");
                }

            }
        });
        b_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String res = PrefsManager.getInstance(v.getContext()).getData("member");
                tv_resObj.setText(res);
                tv_resObj.setVisibility(View.VISIBLE);
                Gson gson = new Gson();
                MemberModel obj = gson.fromJson(res, MemberModel.class);
                tv_res.setText("Name - "+obj.getName()+",\nEmail "+obj.getEmail()+",\nAge - "+obj.getAge());
                tv_res.setVisibility(View.VISIBLE);

            }
        });
    }
}