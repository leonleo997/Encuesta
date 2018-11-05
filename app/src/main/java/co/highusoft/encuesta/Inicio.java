package co.highusoft.encuesta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    private Button btn_registrar;
    private Button btn_estadisticas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btn_estadisticas = findViewById(R.id.btn_estadisticas);
        btn_estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Inicio.this, Estadisticas.class);
                startActivity(i);
            }
        });

        btn_registrar = findViewById(R.id.btn_registro);
        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Inicio.this, NuevoRegistro.class);
                startActivity(i);
            }
        });
    }
}
