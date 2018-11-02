package co.highusoft.encuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class NuevoRegistro extends AppCompatActivity {


    private RadioGroup rg_p1;
    private RadioGroup rg_p2;
    private RadioGroup rg_p3;
    private RadioGroup rg_p4;
    private RadioGroup rg_p5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        rg_p1=findViewById(R.id.rg_p1);
        rg_p2=findViewById(R.id.rg_p2);
        rg_p3=findViewById(R.id.rg_p3);
        rg_p4=findViewById(R.id.rg_p4);
        rg_p5=findViewById(R.id.rg_p5);


    }
}
