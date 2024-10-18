package com.example.formativajavier;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etContrasena;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String usuarioGuardado = getSharedPreferences("MyPrefs", MODE_PRIVATE)
                .getString("usuario", null);

        if (usuarioGuardado != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_login);

            etUsuario = findViewById(R.id.et_usuario);
            etContrasena = findViewById(R.id.et_contrasena);
            btnLogin = findViewById(R.id.btn_login);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validarCredenciales();
                }
            });
        }
    }

    private void validarCredenciales() {
        String usuario = etUsuario.getText().toString().trim();
        String contrasena = etContrasena.getText().toString().trim();

        if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(contrasena)) {
            Toast.makeText(this, "Por favor, complete ambos campos", Toast.LENGTH_SHORT).show();
        } else {
            getSharedPreferences("MyPrefs", MODE_PRIVATE)
                    .edit()
                    .putString("usuario", usuario)
                    .apply();

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}