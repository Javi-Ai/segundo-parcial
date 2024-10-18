package com.example.formativajavier;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.formativajavier.adaptadores.OnUsuarioClickListener;
import com.example.formativajavier.adaptadores.PersonajeAdapatador;
import com.example.formativajavier.clases.Personaje;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnUsuarioClickListener {

    RecyclerView rcv_personajes;
    List<Personaje> listaPersonajes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_personajes = findViewById(R.id.rcv_personajes);

        Personaje pj1 = new Personaje("https://media.revistagq.com/photos/5ec79998db7478f5171ec251/16:9/w_1920,c_limit/reloj-tony-montana-scarface.jpg", "Antonio Montana", "Es un inmigrante cubano que llega a Miami y se convierte en uno de los capos más poderosos del narcotráfico. Ambicioso, violento y despiadado, Tony busca poder a cualquier costo, lo que eventualmente lo lleva a su propia destrucción.\n" +
                "\n");
        Personaje pj2 = new Personaje("https://pbs.twimg.com/media/E6YSVGvWEAwIq6s?format=jpg&name=large", "Elvira Hancock", "Es la pareja de Tony Montana, una mujer fría y distante. Elvira es adicta a las drogas y está atrapada en el estilo de vida del narcotráfico. Aunque al principio parece inalcanzable, se vuelve el interés amoroso de Tony.");
        Personaje pj3 = new Personaje("https://pbs.twimg.com/media/CVbJHhwUkAAD4CD?format=jpg&name=900x900", "Frank López", "Es el jefe del cartel al que Tony inicialmente sirve. Frank es un hombre de negocios astuto pero cauteloso. Su relación con Tony se deteriora cuando este se vuelve más ambicioso y comienza a desafiar su autoridad.");
        Personaje pj4 = new Personaje("https://static.wikia.nocookie.net/scarface/images/5/5a/300px-MannyRibera.jpg/revision/latest?cb=20090916151553&path-prefix=es", "Manny Rivera", "Es el mejor amigo y confidente de Tony. También inmigrante cubano, Manny es más relajado y encantador. Aunque siempre está al lado de Tony, sus diferencias de carácter y valores eventualmente los separan.");

        listaPersonajes.add(pj1);
        listaPersonajes.add(pj2);
        listaPersonajes.add(pj3);
        listaPersonajes.add(pj4);

        rcv_personajes.setLayoutManager(new LinearLayoutManager(this));
        rcv_personajes.setAdapter(new PersonajeAdapatador(listaPersonajes, this));
    }

    @Override
    public void onUsuarioClick(Personaje personaje) {
        Intent intent = new Intent(this, DetallePersonajeActivity.class);
        intent.putExtra("personaje", personaje);
        startActivity(intent);
    }
}