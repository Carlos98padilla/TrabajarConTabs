package com.example.trabajarcontabs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {

    ListView listaOpciones;
    TextView opcionSeleccionada;
    TextView mostrarInformacion;

    public ListViewFragment() {
        // Required empty public constructor


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View vista = inflater.inflate(R.layout.fragment_list_view, container, false);
       listaOpciones = (ListView) vista.findViewById(R.id.listaOpciones);
       opcionSeleccionada = (TextView) vista.findViewById(R.id.opcionSeleccionada);
       mostrarInformacion = (TextView) vista.findViewById(R.id.mostrarInformacion);

       ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(getActivity(), R.array.vectorOpciones,
               R.layout.list_item_opciones);
       listaOpciones.setAdapter(adaptador);
       listaOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               opcionSeleccionada.setText("" + parent.getItemAtPosition(position));
               if (parent.getItemAtPosition(position).equals("¿Qué es android Studio?")){
                   mostrarInformacion.setText("Es un sistema operativo basado en Linux, el cual puede ser instalado en Smartphones, "+ "tabletas, televisores, electrodomesticos, entre otros dispositivos.");
               }else{
                   if(parent.getItemAtPosition(position).equals("¿Qué es Android Studio?")){
                       mostrarInformacion.setText("Es un entorno integrado de desarrollo (IDE por sus siglas en ingles), que permite "+
                               "crear aplicaciones para el sistema operativo Android");
                   }else {
                       mostrarInformacion.setText("Los elementos que componen el diseño de la interfaz gráfica en una actividad, "+
                               "se crean usando objetos de las clases View y ViewGroup");
                   }
               }
           }
       });
        return  vista;
    }
}
