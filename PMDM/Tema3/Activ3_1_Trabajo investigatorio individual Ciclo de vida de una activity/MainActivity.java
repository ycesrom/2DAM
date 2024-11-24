package www.iesmurgi.org;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LIFECICLE", "onCreate");
        //Esta linea obtiene un objeto button que nos permite interactual con el.
        //Se obtiene a partir del id que se ha establecido y se accede por la
        //clase R.
        Button btnaceptar = (Button) findViewById(R.id.btnaceptar);
        btnaceptar.setOnClickListener(new View.OnClickListener() {
            //Metodo que se llama cuando se haga click en el componente
            @Override
            public void onClick(View arg0) {
                TextView texto = (TextView)findViewById(R.id.txttexto);
                EditText edt = (EditText)findViewById(R.id.edtnombre);
                String nombre = edt.getText().toString();
                texto.setText("Hola "+nombre);
            }
        });
    }

    //Metodo que llama a la app cuando se vuelve visible al usuario
    @Override
    protected void onStart() {
        super.onStart();
        //Mensajes de depuracion
        Log.d("LIFECICLE", "onStart");
        //Mensajes detallados
        Log.v("LIFECICLE","onStart");
        //Mensajes para informacion general
        Log.i("LIFECICLE","onStart");
        //Mensajes para advertecias
        Log.w("LIFECICLE","onStart");
        //Mensajes para errores
        Log.e("LIFECICLE","onStart");
    }

    //Metodo que llama a la app cuando está lista para interactuar con el usuario
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECICLE", "onResume");
    }

    //Metodo que llama a la app deja de estar en primer plano
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECICLE", "onPause");
    }

    //Metodo que llama a la app cuando vuelve a estar activa después de haber sido detenida
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFECICLE", "onRestart");
    }

    //Metodo que llama a la app cuando ya no es visible para el usuario
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECICLE", "onStop");
    }

    //Metodo que llama a la app antes de que sea destruida completamente
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECICLE", "onDestroy");
    }
}
