package com.example.listin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> listacontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listacontactos = new ArrayList<Contacto>();
        listacontactos.add(new Contacto("Juan","+34659401867"));
        listacontactos.add(new Contacto("Pedro","+34654461967"));
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

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String num = listacontactos.get(i).getNumero();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + num));
                startActivity(intent);
                //Toast.makeText(MainActivity.this,listacontactos.get(i).getNumero(), Toast.LENGTH_LONG).show();
            }
        });



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