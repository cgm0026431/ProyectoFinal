package com.example.proyectofinal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.Client.Usuarios;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link newFormulario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class newFormulario extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public newFormulario() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment newFormulario.
     */
    // TODO: Rename and change types and number of parameters
    public static newFormulario newInstance(String param1, String param2) {
        newFormulario fragment = new newFormulario();
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
    private EditText etNombre,etMes,etAnio;
    private Button botonInsertar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_new_formulario, container, false);
                etNombre=v.findViewById(R.id.txtNombreEntrada);
                etAnio=v.findViewById(R.id.txtAnioEntrada);
                etMes=v.findViewById(R.id.txtMesEntrada);

            final ControlUser control = new ControlUser(v.getContext());
        botonInsertar= (Button) v.findViewById(R.id.btnEnviar);
        //   botonActualizar.setVisibility(View.GONE);
        botonInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anioString = etAnio.getText().toString().trim();
                String mesString = etMes.getText().toString().trim();
                String nombreString = etNombre.getText().toString().trim();
                if (anioString.equals("")){
                    etAnio.setError("Ingresa el año");
                    etAnio.requestFocus();
                    return;
                }
                if (nombreString.equals("")){
                    etNombre.setError("Ingresa el Nombre");
                    etNombre.requestFocus();
                    return;
                }
                if (mesString.equals("")){
                    etMes.setError("Ingresa el color");
                    etMes.requestFocus();
                    return;
                }

                int anioInt = Integer.parseInt(anioString);
                Usuarios user=new Usuarios(nombreString,mesString,anioInt);
                long resultado = control.insertarUser(user);
                if (resultado==-1){
                    //error al insertar
                    Toast.makeText(getActivity(), " Error", Toast.LENGTH_SHORT).show();
                }else{
                    //se inserto correctamente
                    Toast.makeText(getActivity(), "Insertado Correctamente", Toast.LENGTH_SHORT).show();
                    limpiarFormulario();
                }

            }
        });
        return v;
    }
    private void limpiarFormulario() {
        etAnio.setText("");
        etNombre.setText("");
        etMes.setText("");
    }
}