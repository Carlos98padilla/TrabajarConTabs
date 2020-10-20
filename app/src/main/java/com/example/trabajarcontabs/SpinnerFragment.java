package com.example.trabajarcontabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SpinnerFragment extends Fragment {
    private static  final String ARG_PARAM1= "param1";
    private static  final String ARG_PARAM2= "param2";

    private String mParam1;
    private String mParam2;
    private Spinner opciones;
    private TextView opcionSeleccionada;
    private TextView mostrarInformacion;


    public SpinnerFragment() {
        // Required empty public constructor
    }

    public  static  SpinnerFragment newInstance(String param1, String param2){
        SpinnerFragment fragment = new SpinnerFragment();
        Bundle args=new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return  fragment;
    }

    public void  onCreate(Bundle savedInstancesState) {

        super.onCreate(savedInstancesState);
        if(getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View vista = inflater.inflate(R.layout.fragment_spinner, container, false);
       opciones= (Spinner) vista.findViewById(R.id.listaOpciones);
       opcionSeleccionada = (TextView) vista.findViewById(R.id.opcionSeleccionada);
       mostrarInformacion=(TextView)vista.findViewById(R.id.mostrarInformacion);
       ArrayAdapter<CharSequence> adaptador= ArrayAdapter.createFromResource(getActivity(), R.array.vectorOpciones,
               R.layout.support_simple_spinner_dropdown_item);
       opciones.setAdapter(adaptador);
       opciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

           public void onNothingSelected(AdapterView<?> parent){
                opcionSeleccionada.setText("");
           }
       });

       return vista;
    }
}
