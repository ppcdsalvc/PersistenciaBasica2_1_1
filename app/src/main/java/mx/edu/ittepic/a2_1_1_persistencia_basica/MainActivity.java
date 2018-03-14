package mx.edu.ittepic.a2_1_1_persistencia_basica;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button bt1,bt2;
EditText et1,et2;
RadioButton rb1,rb2,rb3;
CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("percistenciaBasicaArturo");

        bt1=findViewById(R.id.btGuardar);
        bt2=findViewById(R.id.btObtener);

        et1 = findViewById(R.id.etNombre);
        et2 = findViewById(R.id.etCorreo);

        rb1= findViewById(R.id.rbHombre);
        rb2= findViewById(R.id.rbMujer);
        rb3= findViewById(R.id.rbOtros);

        cb1 = findViewById(R.id.cbCantar);
        cb2 = findViewById(R.id.cbLeer);
        cb3 = findViewById(R.id.cbJugar);

        sp = findViewById(R.id.spSigno);



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**Edit text*/
                String nombre = et1.getText().toString();
                SharedPreferences preferences1 = getSharedPreferences("nombres", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1= preferences1.edit();
                editor1.putString("nombre",nombre);
                editor1.commit();

                String correo = et2.getText().toString();
                SharedPreferences preferences2 = getSharedPreferences("correos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2= preferences2.edit();
                editor2.putString("correo",correo);
                editor2.commit();

                /**RadioButtons*/
                if(rb1.isChecked()){
                String genero = rb1.getText().toString();
                SharedPreferences preferences3 = getSharedPreferences("generos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor3= preferences3.edit();
                editor3.putString("genero",genero);
                editor3.commit();}

                if(rb2.isChecked()){
                    String genero = rb2.getText().toString();
                    SharedPreferences preferences3 = getSharedPreferences("generos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor3= preferences3.edit();
                    editor3.putString("genero",genero);
                    editor3.commit();}

                if(rb3.isChecked()){
                    String genero = rb3.getText().toString();
                    SharedPreferences preferences3 = getSharedPreferences("generos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor3= preferences3.edit();
                    editor3.putString("genero",genero);
                    editor3.commit();}

                /**  Check box */
                if(cb1.isChecked()){
                    boolean cantar =true;
                    SharedPreferences preferences4 = getSharedPreferences("hobbis1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor4= preferences4.edit();
                    editor4.putBoolean("cantar",cantar);
                    editor4.commit();}

                if(cb2.isChecked()){
                    boolean leer =true;
                    SharedPreferences preferences5 = getSharedPreferences("hobbis2", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor5= preferences5.edit();
                    editor5.putBoolean("leer",leer);
                    editor5.commit();}

                if(cb3.isChecked()){
                    boolean jugar =true;
                    SharedPreferences preferences6 = getSharedPreferences("hobbis3", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor6= preferences6.edit();
                    editor6.putBoolean("jugar",jugar);
                    editor6.commit();}

                    /**Spiner*/
                 int posicionSpinner = sp.getSelectedItemPosition();
                SharedPreferences preferences7 = getSharedPreferences("signos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor7= preferences7.edit();
                editor7.putInt("posicionSpinner",posicionSpinner);
                editor7.commit();

                Toast.makeText(MainActivity.this, "Ya se guardo", Toast.LENGTH_SHORT).show();

            }});//fin bt1


                    bt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences preferences1 = getSharedPreferences("nombres",Context.MODE_PRIVATE);
                            et1.setText(preferences1.getString("nombre",""));

                            SharedPreferences preferences2 = getSharedPreferences("correos",Context.MODE_PRIVATE);
                            et2.setText(preferences2.getString("correo",""));

                            SharedPreferences preferences3 = getSharedPreferences("generos",Context.MODE_PRIVATE);

                            switch ((preferences3.getString("genero",""))) {
                                case "Hombre":
                                    rb1.setChecked(true);
                                    break;
                                case "Mujer":
                                    rb2.setChecked(true);
                                    break;
                                case "Otros":
                                    rb3.setChecked(true);
                                    break;}


                            SharedPreferences preferences4 = getSharedPreferences("hobbis1",Context.MODE_PRIVATE);
                               if((preferences4.getBoolean("cantar",false))){
                                   cb1.setChecked(true);}

                            SharedPreferences preferences5 = getSharedPreferences("hobbis2",Context.MODE_PRIVATE);
                            if((preferences5.getBoolean("leer",false))){
                                cb2.setChecked(true);}

                            SharedPreferences preferences6 = getSharedPreferences("hobbis3",Context.MODE_PRIVATE);
                            if((preferences6.getBoolean("jugar",false))){
                                cb3.setChecked(true);}


                            SharedPreferences preferences7 = getSharedPreferences("signos",Context.MODE_PRIVATE);
                            sp.setSelection(preferences7.getInt("posicionSpinner",0));


                            Toast.makeText(MainActivity.this, "Recuperado", Toast.LENGTH_SHORT).show();


                        }
                    });//fin on clic bt2


    }
}
