package com.example.entrylog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PageAdminLogin extends AppCompatActivity {
EditText el1,el2,el3,el4;
AppCompatButton bl1,bl2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page_admin_login);

        el1=(EditText) findViewById(R.id.name);
        el2=(EditText) findViewById(R.id.admnum);
        el3=(EditText) findViewById(R.id.sysnum);
        el4=(EditText) findViewById(R.id.dep);
        bl1=(AppCompatButton) findViewById(R.id.addbut);
        bl2=(AppCompatButton) findViewById(R.id.logoutbut);

        bl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName=el1.getText().toString();
                String getAdmNum=el2.getText().toString();
                String getSysNum=el3.getText().toString();
                String getDep=el4.getText().toString();
                Toast.makeText(getApplicationContext(),getName+getAdmNum+getSysNum+getDep,Toast.LENGTH_LONG).show();

            }
        });

        bl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iback= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(iback);
            }


        });

    }
}