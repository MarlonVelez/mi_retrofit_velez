package com.example.mi_retrofit_velez.interfaz;

import com.example.mi_retrofit_velez.modelo.Usuario;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Api_servicio {

    @GET("users")
    Call<List<Usuario>> getAllUsuers();
}

