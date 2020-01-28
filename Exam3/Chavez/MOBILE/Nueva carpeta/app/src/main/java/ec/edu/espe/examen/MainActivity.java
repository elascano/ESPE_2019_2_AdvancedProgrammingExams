package ec.edu.espe.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);
    }

    private void obtenerUser(String user, String password){
        String url="http://192.168.1.115:8080/TransporteCarga/Acme/Users/users/data/"+user+"/"+password;
        final JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try{
                    JSONObject obj=response.getJSONObject(0);
                    String tipo=obj.getString("tipo");
                    String admin="1";
                    String user="2";
                    if(tipo.equals(admin)){
                        Toast.makeText(MainActivity.this, "¡Bienvenido Administrador!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Administrador.class);
                        startActivity(intent);

                    }else if(tipo.equals(user)){
                        Toast.makeText(MainActivity.this, "¡Bienvenido Usuario!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), Logistica.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(MainActivity.this, "Contraseña o Usuario Incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();


            }
        });
        queue.add(request);
    }
}
/*
  EditText edtUsuario,edtPassword;
     Button btnLogin;


    private RequestQueue queue;
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue= Volley.newRequestQueue(this);

        edtUsuario=findViewById(R.id.usuario);
        edtPassword=findViewById(R.id.contrasena);
        btnLogin=findViewById(R.id.btnIngresar);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String u=edtUsuario.getText().toString();
                String pas=edtPassword.getText().toString();
                obtenerUser(u,pas);
            }
        });


    }
    private void obtenerUser(String user, String password){

        String url="http://192.168.1.115:8080/TransporteCarga/Acme/Users/users/data/"+user+"/"+password;
        final JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try{
                    JSONObject obj=response.getJSONObject(0);
                    String tipo=obj.getString("tipo");
                    String admin="1";
                    String user="2";
                    if(tipo.equals(admin)){
                        Toast.makeText(MainActivity.this, "¡Bienvenido Administrador!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Administrador.class);
                        startActivity(intent);

                    }else if(tipo.equals(user)){
                        Toast.makeText(MainActivity.this, "¡Bienvenido Usuario!", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), Logistica.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(MainActivity.this, "Contraseña o Usuario Incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();


            }
        });
        queue.add(request);
    }
}

 */