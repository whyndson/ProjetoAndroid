package com.example.meubizu.services;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.ref.WeakReference;
import com.example.meubizu.R;
import com.example.meubizu.view.AdicionarComentarioActivity;

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class ConsultaCepTask  extends AsyncTask<String, Object, String> {

    private WeakReference<AdicionarComentarioActivity> reference;

    public ConsultaCepTask(Context context) {
        this.reference = new WeakReference<>((AdicionarComentarioActivity) context);
    }

    @Override
    protected String doInBackground(String... listaCep) {
        String cep = listaCep[0];

        WebClient client = new WebClient();
        String response = client.getCep(cep);

        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {

            Log.i("Script", "Response: " + s);

            JSONObject json = new JSONObject(s);
            String rua = json.getString("logradouro");
            String cidade = json.getString("localidade");
            String uf = json.getString("uf");

            reference.get().editTextCidade.setText(cidade);
            reference.get().editTextEstado.setText(uf);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
