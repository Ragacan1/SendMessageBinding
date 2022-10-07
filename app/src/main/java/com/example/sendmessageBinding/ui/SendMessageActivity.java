package com.example.sendmessageBinding.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendmessageBinding.R;
import com.example.sendmessageBinding.SendMessageApplication;
import com.example.sendmessageBinding.data.Message;
import com.example.sendmessageBinding.data.User;
import com.example.sendmessageBinding.databinding.ActivitySendMessageBinding;

/**
 * <h1>Proyecto SendMessage</h1>
 * En este proyecto aprenderemos a realizar las siguientes operaciones
 * <ol>
 *     <li>Crear un evento en un componente Button en codigo XML</li>
 *     <li>Crear un escuchador/Listener de evento OnClick()</li>
 *     <li>Crear un Intent y un elemento Bundle para pasar informacion entre Activity</li>
 *     <li>El ciclo de vida de una Activity</li>
 *     <li>Manejar la pila de Actividades</li>
 * </ol>
 *
 * @author RafaGC
 * @version 1.0
 * @see android.widget.Button
 * @see android.app.Activity
 * @see android.content.Intent
 * @see android.os.Bundle
 */

public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageActivity";
    private SendMessageOnClickListener delegate;
    private ActivitySendMessageBinding binding;

    //region CICLO DE VIDA DE LA ACTIVITY

    /**
     * Metodo que se ejecuta cuando se crea la activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        /*//Se inicializa el delegado
        delegate = new SendMessageOnClickListener();
        //Se establece el vinculo entre su boton y su delegado
        btSend.setOnClickListener(delegate);*/

        //Establecemos el Listener OnClickListenerAlBoton mediandte una clase anonima que
        // implementa la interfaz view.OnClickListener
        // *ANTES ERA UNA FUNCION Y LO HEMOS TRANSFORMADO A UNA EXPRESION LAMBDA
        binding.setMessage(new Message(((SendMessageApplication)getApplication()).getUser()));
        binding.btSend.setOnClickListener(View -> sendMessage());

        //view -> Toast.makeText(SendMessageActivity.this, "Esto es a traves de una clase anonima", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }

    /**
     * Método Callback que crea el menú de opciones en la visa. Se devuelve true para indicar al SO
     * que se ha realizado la opción de modificar el menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Este método callback se llama cuando se pulsa sobre una de las opciones del menu de la
     * aplicacion
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_aboutus:
                //Toast.makeText(this, "Se ha pulsado sobre About Us", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");

    }

    /**
     * Este metodo se ejecuta cuando se destruye la Activity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");

    }
    //endregion



    public void sendMessage() {
        //TODO Se modificará este ejercicio para estudiar ViewBinding
        //Toast.makeText(this, "Hemos pulsado el botón", Toast.LENGTH_SHORT).show();
        //1. Crar el contenedor para añadir los datos
        Bundle bundle = new Bundle();

        //1.1 pasar dato a dato
        //bundle.putString("user",binding.getMessage().getUser().getName());
        //bundle.putString("message",binding.getMessage().getContent());

        //1.2 crear un objeto Message
        //Message message = new Message(binding.etUser.getText().toString(), binding.etMessage.getText().toString());
        bundle.putParcelable("message", binding.getMessage());

        //2. Vamos a crear el objeto Intent explicito porque se conoce la actividad
        //destino
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);

        //3. Inicia la transicion entre una vista y otra mediante startActivity
        startActivity(intent);
    }
    /**
     * Este método es el que se llama cuando se pulsa sobre el boton btSend definido en el XML
     * android:onclick="sendMessage"
     *
     * @param view
     */
    public void sendMessage(View view) {
        sendMessage();
    }

    /**
     * Esta clase NO ANONIMA implementa el listener
     */

    class SendMessageOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(SendMessageActivity.this, "esto es a través de un delegado",Toast.LENGTH_SHORT).show();
        }
    }

    //Esta clase ya no es anónima e implementa el listener que responde siempre al evento OnClick
    class SendMesageOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(SendMessageActivity.this, "Esto es a través de una clase normal", Toast.LENGTH_SHORT).show();
        }
    }
}