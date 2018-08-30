package com.example.user.insertdatausingvolley;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText nameet,locationet,phoneet,usernameet,paswordet,typeet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameet=findViewById(R.id.name);
        locationet=findViewById(R.id.location);
        phoneet=findViewById(R.id.mobile);
        usernameet=findViewById(R.id.username);
        paswordet=findViewById(R.id.password);
        typeet=findViewById(R.id.type);
    }

    public void submitBT(View view) {
        String name=nameet.getText().toString();
        String location=locationet.getText().toString();
        String mobile=phoneet.getText().toString();
        String username=usernameet.getText().toString();
        String password=paswordet.getText().toString();
        String type=typeet.getText().toString();
        signUp(this,new Model(name,location,mobile,username,password,type));
    }

    public static void signUp(final Context context, final Model model){
        final String url="http://letstravelworld.tk/farmermate/signup.php";
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            //two method string request
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Cheek your connection", Toast.LENGTH_SHORT).show();

            }
        })
            //at first second bracket than select alt+fn+del than select override method getParams
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> stringMap =new HashMap<>();
                stringMap.put("name",model.getName());
                stringMap.put("location",model.getLocation());
                stringMap.put("mobile",model.getMobile());
                stringMap.put("username",model.getUsername());
                stringMap.put("password",model.getPassword());
                stringMap.put("type",model.getType());
                return stringMap;
            }
        };

      requestQueue.add(stringRequest);
    }

}
