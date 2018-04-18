package com.example.andresim.ejemplonavigationdrawer;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private String [] opcionesMenu;
    private DrawerLayout myPanel;
    private ListView lista;
    private TextView texto;
    private ActionBarDrawerToggle myDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opcionesMenu= new String[]{"Perfil", "Configuracion", "Salir"};
        myPanel = (DrawerLayout) findViewById(R.id.drawer_layout);
        lista = (ListView) findViewById(R.id.left_drawer);
        texto = (TextView) findViewById(R.id.textView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        setSupportActionBar(toolbar);

        myDrawerToggle = new ActionBarDrawerToggle(this, myPanel,toolbar, R.string.drawer_open,R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle("Menu");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActionBar().setTitle("Menu");
            }
        };



        //Creamos el Adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter(this, R.layout.drawer_list_item, opcionesMenu);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new DrawerItemClickListener());


    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int posicion) {
        texto.setText(opcionesMenu[posicion]);
        myPanel.closeDrawer(lista);
    }
}
