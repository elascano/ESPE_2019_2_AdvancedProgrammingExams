package ec.edu.espe.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;

    EditText txtID;
    EditText txtBrand;
    EditText txtModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtID = (EditText) findViewById(R.id.txtID);
        txtBrand = (EditText) findViewById(R.id.txtBrand);
        txtModel = (EditText) findViewById(R.id.txtModel);

        queue = Volley.newRequestQueue(this);

        Button btnSearchVehcile = (Button) findViewById(R.id.btnSearch);

        btnSearchVehcile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });
    }

    private void setData(){

        // String url = "http://freigthtransport.ddns.net:1024/FreightTransport/project/client/searchClient/1726416066";

       // String url = "http://freigthtransport.ddns.net:1024/FreightTransport/project/client/searchClient/"+txtID.getText().toString();
        String url = "http://freigthtransport.ddns.net:1024/vehicles/ExamVehicles/vehicles/showvehiclebyid/"+txtID.getText().toString();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    txtID.setText(response.getString("id"));
                    txtBrand.setText(response.getString("brand"));
                    txtModel.setText(response.getString("model"));

                } catch (JSONException e) {
                    e.printStackTrace();
                    txtID.setText(e.toString());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);

    }
}
