package ar.com.marianoroces.examendam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//EJERCICIO RESUELTO EN API 28 DE ANDROID
//SE USO API_KEY PROPIA PARA EL MAPA, NO SE UTILIZO LA PROPUESTA POR EL EJERCICIO

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    EditText etNombreLocal;
    Button btnAgregar;
    Button btnBorrar;
    RadioButton rbSi;
    RadioButton rbNo;
    RadioGroup rgActivarBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.tvTitulo);
        etNombreLocal = findViewById(R.id.etNombreLocal);
        btnAgregar = findViewById(R.id.btnMostrarLocales);
        btnBorrar = findViewById(R.id.btnAgregarLocal);
        rbSi = findViewById(R.id.rbSi);
        rbNo = findViewById(R.id.rbNo);
        rgActivarBoton = findViewById(R.id.rgActivarBoton);

        final ArrayList<String> nombreLocales = new ArrayList<String>();

        rgActivarBoton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rbSi:
                        btnAgregar.setVisibility(Button.VISIBLE);
                        break;
                    case R.id.rbNo:
                        btnAgregar.setVisibility(Button.GONE);
                        break;
                }
            }
        });

        btnBorrar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombreLocales.add(etNombreLocal.getText().toString());
                etNombreLocal.setText("");
            }
        });

        btnAgregar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombreLocales.size() == 0){
                    Toast.makeText(MainActivity.this, "INGRESAR LOCALES PRIMERO", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    intent.putExtra("lista", nombreLocales);
                    startActivity(intent);
                }
            }
        });
    }
}