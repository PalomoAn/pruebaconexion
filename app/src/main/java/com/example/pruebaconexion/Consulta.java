package com.example.pruebaconexion;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Consulta {
    public void peticion(String url, Personas e , MainActivity m){
        StringRequest rqs = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    try {
                        JSONObject o = new JSONObject(response);
                        m.txtID.setText(o.getString("id"));
                        m.txtNombre.setText(o.getString("nombre"));
                    } catch (JSONException e){
                        //Toast.makeText(m.getApplicationContext(), "Error: "+e.toString(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Error:"+error.getLocalizedMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String,String>();
                param.put("id",e.getId());
                param.put("nombre",e.getNombre());
                return param;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(m.getApplicationContext());
        requestQueue.add(rqs);
    }
}
