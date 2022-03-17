package com.example.mi_retrofit_velez;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mi_retrofit_velez.interfaz.Api_servicio;
import com.example.mi_retrofit_velez.modelo.Usuario;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView usuarioItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioItem= findViewById(R.id.usuarioItem);
        getUser();
    }

    private void getUser(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api_servicio apí= retrofit.create(Api_servicio.class);

        Call<List<Usuario>> user= apí.getAllUsuers();

        user.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (!response.isSuccessful()) {
                    usuarioItem.setText("Codigo: "+response.code());
                    return;
                }

                List<Usuario> listaUsuario= response.body();

                for(Usuario user: listaUsuario){

                    String content= "";
                    content+= "nombre:"+ user.getName()+ "\n";
                    content+= "usuario:"+ user.getUsername()+ "\n\n";
                    usuarioItem.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                usuarioItem.setText(t.getMessage());
            }
        });
    }

}