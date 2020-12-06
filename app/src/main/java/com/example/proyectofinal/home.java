package com.example.proyectofinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectofinal.Client.Adapter;
import com.example.proyectofinal.Client.Usuarios;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private RecyclerView rvVehiculos;
    private Usuarios usuarios;
    private ArrayList<Usuarios> listaUsuario;
    private Adapter adaptador;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)

    {
        // Inflate the layout for this fragment

        View vi=inflater.inflate(R.layout.fragment_home, container, false);

        rvVehiculos = vi.findViewById(R.id.recicler);
        //Debemos configurar el recycler vier como un grid
        rvVehiculos.setLayoutManager(new GridLayoutManager(getContext(),1));

        listaUsuario=new ArrayList<Usuarios>();

      //  usuarios=new Usuarios("asd","asad",123);
        try {
            //listaUsuario = new ArrayList<Usuarios>();


            String nombreString,mesString;
            int anioInt;
            AyudanteSqlite ayudanteSqlite = new AyudanteSqlite(getContext());
            SQLiteDatabase sqLiteDatabase = ayudanteSqlite.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select  nombre ,mes ,anio  from user",null);
            if (cursor.moveToFirst()){
                do {

                    //     idInt = cursor.getInt(0);
                    nombreString = cursor.getString(0);
                    mesString = cursor.getString(1);
                    anioInt = cursor.getInt(2);
                    Toast.makeText(getActivity(), " "+nombreString, Toast.LENGTH_SHORT).show();
                    //  Toast.makeText(getActivity(), " "+mesString, Toast.LENGTH_SHORT).show();
                    Usuarios userAux = new Usuarios(nombreString,mesString,anioInt);
                    Toast.makeText(getActivity(), " "+userAux.getNombre(), Toast.LENGTH_SHORT).show();
                    listaUsuario.add(userAux);
                }while(cursor.moveToNext());
            }else{
                Toast.makeText(getActivity(), "No existen vehiculos registrados", Toast.LENGTH_SHORT).show();

            }
        }catch (Exception ex){
            Toast.makeText(getActivity(), "Error al cargar vehiculos de Sqlite", Toast.LENGTH_SHORT).show();
        }

      //  listaUsuario.add(usuarios);
        adaptador= new Adapter(listaUsuario);
        rvVehiculos.setAdapter(adaptador);
        return vi;
    }

    private void cargarVehiculosSqlite() {



    }

}