package edu.upeu.dam.examen_registrocontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.e1);
        et2=(EditText) findViewById(R.id.e2);
    }

    public void guardar(View view){

        String nombre = et1.getText().toString();
        String datos = et2.getText().toString();

        SharedPreferences pref=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor_obj = pref.edit();
        editor_obj.putString(nombre, datos);
        editor_obj.commit();
        Toast.makeText(this, "Contacto agregado", Toast.LENGTH_SHORT);

    }

    public void buscar(View view){
        String nombre=et1.getText().toString();
        SharedPreferences preferencia=getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String datos=preferencia.getString(nombre,"");

        if(datos.length()==0){
            Toast.makeText(this,"el contacto no existe", Toast.LENGTH_SHORT).show();
        }else{
            et2.setText(datos);
        }

    }

}