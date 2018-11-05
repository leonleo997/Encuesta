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
import java.util.Calendar;
import java.util.Date;

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

                DatabaseReference reference_p1=db.getReference().child("Preguntas").child("Pregunta_1");
                DatabaseReference reference_p2=db.getReference().child("Preguntas").child("Pregunta_2");
                DatabaseReference reference_p3=db.getReference().child("Preguntas").child("Pregunta_3");
                DatabaseReference reference_p4=db.getReference().child("Preguntas").child("Pregunta_4");
                DatabaseReference reference_p5=db.getReference().child("Preguntas").child("Pregunta_5");
                Date currentTime = Calendar.getInstance().getTime();

                //Pregunta 1

                if(rb_p1.getId()==R.id.rb_p1_op1){
                    DatabaseReference rp1=reference_p1.child("a").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p1.getId()==R.id.rb_p1_op2){
                    DatabaseReference rp1=reference_p1.child("b").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p1.getId()==R.id.rb_p1_op3){
                    DatabaseReference rp1=reference_p1.child("c").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p1.getId()==R.id.rb_p1_op4){
                    DatabaseReference rp1=reference_p1.child("d").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }

                //Pregunta 2
                if(rb_p2.getId()==R.id.rb_p2_op1){
                    DatabaseReference rp1=reference_p2.child("a").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p2.getId()==R.id.rb_p2_op2){
                    DatabaseReference rp1=reference_p2.child("b").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p2.getId()==R.id.rb_p2_op3){
                    DatabaseReference rp1=reference_p2.child("c").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p2.getId()==R.id.rb_p2_op4){
                    DatabaseReference rp1=reference_p2.child("d").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }

                //Pregunta 3
                if(rb_p3.getId()==R.id.rb_p3_op1){
                    DatabaseReference rp1=reference_p3.child("a").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p3.getId()==R.id.rb_p3_op2){
                    DatabaseReference rp1=reference_p3.child("b").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p3.getId()==R.id.rb_p3_op3){
                    DatabaseReference rp1=reference_p3.child("c").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p3.getId()==R.id.rb_p3_op4){
                    DatabaseReference rp1=reference_p3.child("d").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p3.getId()==R.id.rb_p3_op5){
                    DatabaseReference rp1=reference_p3.child("e").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }

                //Pregunta 4
                if(rb_p4.getId()==R.id.rb_p4_op1){
                    DatabaseReference rp1=reference_p4.child("a").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p4.getId()==R.id.rb_p4_op2){
                    DatabaseReference rp1=reference_p4.child("b").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p4.getId()==R.id.rb_p4_op3){
                    DatabaseReference rp1=reference_p4.child("c").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p4.getId()==R.id.rb_p4_op4){
                    DatabaseReference rp1=reference_p4.child("d").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }

                //Pregunta 5
                if(rb_p5.getId()==R.id.rb_p5_op1){
                    DatabaseReference rp1=reference_p5.child("a").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p5.getId()==R.id.rb_p5_op2){
                    DatabaseReference rp1=reference_p5.child("b").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p5.getId()==R.id.rb_p5_op3){
                    DatabaseReference rp1=reference_p5.child("c").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }
                if(rb_p5.getId()==R.id.rb_p5_op4){
                    DatabaseReference rp1=reference_p5.child("d").push();
                    currentTime = Calendar.getInstance().getTime();
                    rp1.setValue(currentTime);
                }

                finish();
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
