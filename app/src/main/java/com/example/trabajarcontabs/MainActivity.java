package com.example.trabajarcontabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    //Se crean dos atributos uno de tipo TabLayout, llamado tabControlesSeleccion y otro de tipo
    //ViewPager llamado paginas; para asociarlos con los controles o vistas del diseño activity_main.xml.

    TabLayout tabControlesSeleccion;
    ViewPager paginas;

    //Se declara el adaptador de nombre adaptadorPaginas, del tipo de la clase AdaptadorPaginas.
    AdaptadorPaginas adaptadorPaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //El método findViewById() localiza los controles del fichero activity_main.xml,
        //utilizando la clase R; después de identificarlos, los vincula con los atributos que se declararon
        //al inicio de la clase.

        tabControlesSeleccion = (TabLayout) findViewById(R.id.tabControlesSeleccion);
        paginas = (ViewPager) findViewById(R.id.paginas);

        //Se crea nuestro adaptador, el cual será un nuevo objeto de la clase AdaptadorPaginas; se pasa
        //como parámetros al constructor de la clase, el método getSupportFragmentManager() que permite
        //interactuar con los fragmentos asociados a esta actividad. El otro parámetro es el método
        //getTabCount() del TabLayout para saber número de pestañas que tiene asociadas.

        adaptadorPaginas = new AdaptadorPaginas(getSupportFragmentManager(),
                tabControlesSeleccion.getTabCount());

        //Se le indica al objeto ViewPager cuál es el adaptador que va a utilizar para mostrar los fragmentos.

        paginas.setAdapter(adaptadorPaginas);

        //Se implementa el método setOnTabSelectedListener() para para saber cuándo cambia de estado
        //una pestaña o TabItem. Dependiendo la pestaña que se seleccione, se mostrará el fragmento
        //definido en el adaptador

        tabControlesSeleccion.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                paginas.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    adaptadorPaginas.notifyDataSetChanged();
                }
                if(tab.getPosition() == 1){
                    adaptadorPaginas.notifyDataSetChanged();
                }
                if(tab.getPosition() == 2){
                    adaptadorPaginas.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Se utiliza el método addOnPageChangeListener() y así mantener sincronizado el objeto ViewPager
        //con la posición de la pestaña en el TabLayout.
        paginas.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabControlesSeleccion));

    }
}
