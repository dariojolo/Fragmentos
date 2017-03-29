package com.dariojolo.fragmentos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private EditText txtIngreso;
    private Button  btnSend;
    private DataListener dataListener;

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            dataListener = (DataListener) context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + " debe implementar DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data,container, false);
        // Logica para capturar los elementos de la UI
        txtIngreso = (EditText)view.findViewById(R.id.txtIngreso);
        btnSend    = (Button)view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendText(txtIngreso.getText().toString());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void sendText(String texto){
        dataListener.sendData(texto);
    }
    public interface DataListener{
        void sendData(String text);
    }
}
