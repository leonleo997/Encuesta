package co.highusoft.encuesta;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {

    private PieChart pieChart_p1;
    private PieChart pieChart_p2;
    private PieChart pieChart_p3;
    private PieChart pieChart_p4;
    private PieChart pieChart_p5;
    FirebaseAuth auth;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);


        pieChart_p1 = findViewById(R.id.pie_chart_p1);
        pieChart_p2 = findViewById(R.id.pie_chart_p2);
        pieChart_p3 = findViewById(R.id.pie_chart_p3);
        pieChart_p4 = findViewById(R.id.pie_chart_p4);
        pieChart_p5 = findViewById(R.id.pie_chart_p5);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        loadPieChart_p1();
    }

    private void loadPieChart_p1() {


        Description desc = new Description();
        desc.setText("Pregunta 1");
        desc.setTextSize(15);
        pieChart_p1.setDescription(desc);
        pieChart_p1.setRotationEnabled(true);


        Description desc2 = new Description();
        desc2.setText("Pregunta 2");
        desc2.setTextSize(15);
        pieChart_p2.setDescription(desc2);
        pieChart_p2.setRotationEnabled(true);


        Description desc3 = new Description();
        desc3.setText("Pregunta 3");
        desc3.setTextSize(15);
        pieChart_p3.setDescription(desc3);
        pieChart_p3.setRotationEnabled(true);


        Description desc4 = new Description();
        desc4.setText("Pregunta 4");
        desc4.setTextSize(15);
        pieChart_p4.setDescription(desc4);
        pieChart_p4.setRotationEnabled(true);


        Description desc5 = new Description();
        desc5.setText("Pregunta 5");
        desc5.setTextSize(15);
        pieChart_p5.setDescription(desc5);
        pieChart_p5.setRotationEnabled(true);

        addDataSet(pieChart_p1, "Pregunta_1");
        addDataSet(pieChart_p2, "Pregunta_2");
        addDataSet(pieChart_p3, "Pregunta_3");
        addDataSet(pieChart_p4, "Pregunta_4");
        addDataSet(pieChart_p5, "Pregunta_5");


        Log.e(">>P1", "loadPieChart_p1: ");
    }

    private void addDataSet(final PieChart pieChart_p1, String childName) {

        final ArrayList<Float> yData = new ArrayList<>();
        final ArrayList<String> xData = new ArrayList<>();

        final DatabaseReference p1 = db.getReference().child("Preguntas").child(childName);
        p1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                yData.clear();
                xData.clear();
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for (DataSnapshot child : children) {
                    yData.add(new Float(child.getChildrenCount()));
                    xData.add(child.getKey());

                    Log.e(">>p1", "onDataChange: " + child.getKey() + " values:" + child.getChildrenCount());
                }

                Float total = 0f;
                for (Float value :
                        yData) {
                    total += value;
                }

                for (int i = 0; i < yData.size(); i++) {
                    yData.set(i, (yData.get(i)*100) / total);
                }

                ArrayList<PieEntry> yEntries = new ArrayList<>();
                ArrayList<String> xEntries = new ArrayList<>();
                for (int i = 0; i < yData.size(); i++) {
                    yEntries.add(new PieEntry(yData.get(i), xData.get(i)));
                }

                for (int i = 0; i < xData.size(); i++) {
                    xEntries.add(xData.get(i));
                }

                PieDataSet pieDataSet = new PieDataSet(yEntries, "Respuesta");
                pieDataSet.setSliceSpace(2);
                pieDataSet.setValueTextSize(12);

                ArrayList<Integer> colors = new ArrayList<>();
                colors.add(Color.GRAY);
                colors.add(Color.BLUE);
                colors.add(Color.GREEN);
                colors.add(Color.RED);
                colors.add(Color.YELLOW);

                pieDataSet.setColors(colors);


                Legend legend = pieChart_p1.getLegend();
                legend.setForm(Legend.LegendForm.CIRCLE);
                legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

                PieData pieData = new PieData(pieDataSet);
                pieChart_p1.setData(pieData);
                pieChart_p1.invalidate();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
