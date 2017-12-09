
package com.example.narasimman.test;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String url="https://api.myjson.com/bins/h2n27";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue requestQueue= Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                TextView textView=findViewById(R.id.textview);
                try {
                    JSONArray jsonArray=response.getJSONArray("employee");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String name=jsonObject.getString("ename");
                        Log.e("dinesh",name);
                        String id=jsonObject.getString("empid");
                        Log.e("dinesh",id);
                        String dept=jsonObject.getString("dept");
                        Log.e("dinesh",dept);
                        Log.e("dinesh","-------------------------");
                        textView.append("Employee Name = "+String.valueOf(name)+" \n"+
                                        "Employee id = "+String.valueOf(id)+" \n"+
                                        "Department = "+String.valueOf(dept)+" \n"+
                                        "--------------------------------------\n"
                                        );
                    }
                } catch (JSONException e) {
                    Log.d("dinesh",e.toString());
                    e.printStackTrace();

                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonObjectRequest);
  }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("dinesh","adding extra codes in Mainactivity");
    }
}
