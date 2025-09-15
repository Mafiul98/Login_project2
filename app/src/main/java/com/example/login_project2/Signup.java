package com.example.login_project2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    Button loginbtn,mainsignup;
    TextView chanegePhoto;
    ImageView imageview;
    TextInputEditText inputemail,inputpassword,inputname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        loginbtn=findViewById(R.id.loginbtn);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Signup.this, Login.class));
                finish();

            }
        });

        mainsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputemail.getText().toString();
                String password = inputpassword.getText().toString();
                String name = inputname.getText().toString();

                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageview.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,50,outputStream);
                byte[] imagebyte = outputStream.toByteArray();

                String image = Base64.encodeToString(imagebyte,Base64.DEFAULT);

                String url = "";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {



                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map mymap = new HashMap<String,String>();
                        mymap.put("email","");
                        mymap.put("password","");
                        mymap.put("name","");
                        mymap.put("image","");

                        return mymap;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(Signup.this);
                requestQueue.add(stringRequest);

            }
        });

    }
}