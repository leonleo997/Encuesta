package co.highusoft.encuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NuevoRegistro extends AppCompatActivity {


    private RadioGroup rg_p1;
    private RadioGroup rg_p2;
    private RadioGroup rg_p3;
    private RadioGroup rg_p4;
    private RadioGroup rg_p5;

    private Button btn_registrar;

    FirebaseAuth auth;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        inicializarComponentes();

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb_p1=findViewById(rg_p1.getCheckedRadioButtonId());
                RadioButton rb_p2=findViewById(rg_p2.getCheckedRadioButtonId());
                RadioButton rb_p3=findViewById(rg_p3.getCheckedRadioButtonId());
                RadioButton rb_p4=findViewById(rg_p4.getCheckedRadioButtonId());
                RadioButton rb_p5=findViewById(rg_p5.getCheckedRadioButtonId());

                if(rb_p1==null ||rb_p2==null ||rb_p3==null ||rb_p4==null ||rb_p5==null){
                    Toast.makeText(getApplicationContext(), "Debe responder todas las preguntas.",Toast.LENGTH_LONG).show();
                    return;
                }

                DatabaseReference reference=db.getReference().child("Preguntas").child("Pregunta_1").push();
                String id = reference.getKey();
                Log.e(">>",id);
//
                reference.setValue("Probando");
            }
        });
    }

    private void inicializarComponentes() {
        rg_p1=findViewById(R.id.rg_p1);
        rg_p2=findViewById(R.id.rg_p2);
        rg_p3=findViewById(R.id.rg_p3);
        rg_p4=findViewById(R.id.rg_p4);
        rg_p5=findViewById(R.id.rg_p5);

        auth=FirebaseAuth.getInstance();
        db=FirebaseDatabase.getInstance();

        btn_registrar=findViewById(R.id.btn_enviar);
    }
}
