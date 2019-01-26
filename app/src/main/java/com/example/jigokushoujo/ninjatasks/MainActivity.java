package com.example.jigokushoujo.ninjatasks;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jigokushoujo.ninjatasks.db.ControladorDB;

public class MainActivity extends AppCompatActivity {

    ControladorDB controladorDB;
    private ArrayAdapter<String> miAdapter;
    ListView listViewTareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controladorDB = new ControladorDB(this);
        listViewTareas = (ListView) findViewById(R.id.listaTareas);
        actualizarUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final EditText cajaTexto = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("New Mission")
                .setMessage("Set up your mission")
                .setView(cajaTexto)
                .setPositiveButton("Accept Task", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String  tarea = cajaTexto.getText().toString();
                        controladorDB.addTarea(tarea);
                        actualizarUI();
                        lanzarToastAceptar();
                    }
                })
                .setNegativeButton("Decline Task", null)
                .create();
        dialog.show();

        return super.onOptionsItemSelected(item);
    }

    private void actualizarUI(){
        if(controladorDB.numeroRegistros() == 0){
            listViewTareas.setAdapter(null);
        } else {
            miAdapter = new ArrayAdapter<>(this, R.layout.item_tarea, R.id.task_title, controladorDB.obtenerTareas());
            listViewTareas.setAdapter(miAdapter);
        }
    }

    public void borrarTarea(View view){
        View parent =  (View)view.getParent();
        TextView tareaTextView = (TextView) parent.findViewById(R.id.task_title);
        String tarea = tareaTextView.getText().toString();
        controladorDB.borrarTarea(tarea);
        actualizarUI();
        lanzarToastHecho();
    }

    public void lanzarToastAceptar() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_personalizado1,(ViewGroup) findViewById(R.id.relativeLayout1));

        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.show();
    }

    public void lanzarToastHecho() {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.toast_personalizado2,(ViewGroup) findViewById(R.id.relativeLayout2));

        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.show();
    }
}
