package com.example.sendmessageBinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sendmessageBinding.R;
import com.example.sendmessageBinding.data.Message;
import com.example.sendmessageBinding.databinding.ActivityViewMessageBinding;

/**
 * Clase que muestra un mensaje de un usuario. Recoge el mensaje que implementa la interfaz
 * Parcelable.
 */

public class ViewMessageActivity extends AppCompatActivity {

    private static final String TAG = "ViewMessageActivity";
    private ActivityViewMessageBinding binding;


    //region CICLO DE VIDA DE LA ACTIVITY
    /**
     * Metodo que se ejecuta cuando se crea la activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Log.d(TAG, "ViewMessageActivity -> onCreate()");

        //1. Asignar a mis actividades de esta clase las características de las de la View

        //2.1 Recoger el Bundle que me han pasado en el Intent que ha iniciado esta actividad
        Bundle bundle = getIntent().getExtras();
        Message message = bundle.getParcelable("message");
        binding.setMessage(message);

        //3. Mostrar los datos de estos

        binding.tvUserContent.setText(message.getUser().getName());
        binding.tvMessageContent.setText(message.getContent());

        //tvUserContent.setText(bundle.getString("user"));
        //tvMessageContent.setText(bundle.getString("message"));

        //Log.d(TAG, "ViewMessageActivity -> onCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewMessageActivity -> onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewMessageActivity -> onStop()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewMessageActivity -> onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewMessageActivity -> onPause()");

    }

    /**
     * Este metodo se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding =null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");

    }
    //endregion


}