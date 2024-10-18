package com.example.formativajavier;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.formativajavier.clases.Personaje;
import com.squareup.picasso.Picasso;

public class DetallePersonajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        ImageView img_personaje = findViewById(R.id.img_personaje);
        TextView txt_nombre_personaje = findViewById(R.id.txt_nombre_personaje);
        TextView txt_curso_personaje = findViewById(R.id.txt_descripcion_personaje);

        Personaje usuario = (Personaje) getIntent().getSerializableExtra("personaje");

        if (usuario != null) {
            txt_nombre_personaje.setText(usuario.getNombre());
            txt_curso_personaje.setText(usuario.getDescripcion());
            Picasso.get().load(usuario.getImagen()).into(img_personaje);
        }

        Button btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }

            private void logout() {
                // Eliminar el usuario de SharedPreferences
                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("usuario");
                editor.apply();

                // Enviar a la pantalla de login
                Intent intent = new Intent(DetallePersonajeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}