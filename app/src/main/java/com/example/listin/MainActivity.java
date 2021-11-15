package com.example.listin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> listacontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listacontactos = new ArrayList<Contacto>();
        listacontactos.add(new Contacto("Juan","659 40 18 67"));
        listacontactos.add(new Contacto("Pedro","654 46 19 67"));
        listacontactos.add(new Contacto("Alberto","657 46 18 67"));
        listacontactos.add(new Contacto("Edu","657 46 17 67"));
        listacontactos.add(new Contacto("Carlos","657 46 18 67"));
        listacontactos.add(new Contacto("Guille","634 46 16 67"));
        listacontactos.add(new Contacto("Cesar","645 46 18 67"));
        listacontactos.add(new Contacto("Mario","667 46 18 67"));
        listacontactos.add(new Contacto("Raul","689 46 18 67"));
        listacontactos.add(new Contacto("Jorge","623 46 18 67"));
        listacontactos.add(new Contacto("Pablo","678 23 18 67"));

        AdaptadorContactos adaptador = new AdaptadorContactos(this);
        ListView lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);

    }
    class AdaptadorContactos extends ArrayAdapter<Contacto>{
        AppCompatActivity appCompatActivity;

        AdaptadorContactos(AppCompatActivity context){
            super(context,R.layout.contacto, listacontactos);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.contacto, null);

            TextView textView1 = item.findViewById(R.id.textView);
            textView1.setText(listacontactos.get(position).getNombre());

            TextView textView2 = item.findViewById(R.id.textView2);
            textView2.setText(listacontactos.get(position).getNumero());

            ImageView imageView1 = item.findViewById(R.id.imageView);
            imageView1.setImageResource(R.mipmap.contacto);



            return (item);

        }
    }
}