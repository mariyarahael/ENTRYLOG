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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PageAdminLogin extends AppCompatActivity {
EditText el1,el2,el3,el4;
AppCompatButton bl1,bl2;
String apiUrl="http://10.0.4.16:3000/api/students";

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

                JSONObject student = new JSONObject();//CREATING JSON OBJECT
                try {
                    student.put("name",getName);
                    student.put("admission_number",getAdmNum);
                    student.put("system_number",getSysNum);
                    student.put("department",getDep);
                }
                catch (JSONException e)
                {
                    throw new RuntimeException(e);
                }

                //JSON OBJECT REQUEST CREATION
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                        Request.Method.POST,
                        apiUrl,
                        student,

                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Added successfully", Toast.LENGTH_SHORT).show();
                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                            }
                        }


                );

                //REQUEST QUEUE
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);

            }
        });

        bl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preference=getSharedPreferences("LoginApp",MODE_PRIVATE);
                SharedPreferences.Editor editor =preference.edit();
                editor.clear();
                editor.apply();
                Intent iback= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(iback);
            }


        });

    }
}