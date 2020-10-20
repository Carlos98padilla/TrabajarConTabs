package com.example.trabajarcontabs;
//Se importan las clases que contienen algunos métodos a utilizar en la implementación del código.
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
//Se indica que la clase AdaptadorPaginas es una clase extendida de la clase FragmentPagerAdapter.
//La clase FragmentPagerAdapter se puede utilizar como un administrador de fragmentos, cuando se
//tienen varias pestañas. Después de declarar la clase AdaptadorPaginas se agregan todos sus métodos:
//el método constructor, el método getItem() y getCount().
public class AdaptadorPaginas extends FragmentPagerAdapter {
    //Se declara una variable de tipo entero llamada numeroPaginas para asociarla al número de tabs
//o pestañas y a los fragmentos asociados.
    int numeroPaginas;
    public AdaptadorPaginas(@NonNull FragmentManager fm, int numPaginas) {
        super(fm, numPaginas);
        this.numeroPaginas = numPaginas;
    }
    @NonNull
    @Override
//Al método getItem(), se le pasa como parámetro una posición. Luego se agrega una sentencia switch, y
//dependiendo de la posición que se pase como parámetro; se retorna el fragmento que mostrará la
//información asociada a la pestaña seleccionada.
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SpinnerFragment();
            case 1:
                return new ListViewFragment();
            case 2:
                return new GridViewFragment();
            default: return null;
        }
    }
    @Override
//El método getCount() retorna el número de Tabs o pestañas.
    public int getCount() {
        return numeroPaginas;
    }
}