package com.dariojolo.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MainActivity extends FragmentActivity implements DataFragment.DataListener{

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();

    }

    @Override
    public void sendData(String text) {
        //Llamar al metodo renderizarTexto del DetailsFragment,
        //Pasandole el texto que recibimos por parametro en este metodo.

        if (isMultiPanel) {
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            detailsFragment.renderizarTexto(text);
        }else{
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }
    }
    private void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailFragment) != null)

        ;
    }
}
