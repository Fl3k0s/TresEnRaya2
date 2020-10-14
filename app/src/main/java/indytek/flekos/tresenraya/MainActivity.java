package indytek.flekos.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        GridLayout layoutPadre = new GridLayout(this);
        layoutPadre.setColumnCount(1);
        layoutPadre.setRowCount(3);

        //creamos el layout de arriba
        GridLayout puntuacio = new GridLayout(this);
        puntuacio.setRowCount(3);
        puntuacio.setColumnCount(3);

        final TextView puntuacion1 = new TextView(this);
        final TextView puntuacion2 = new TextView(this);
        TextView texto = new TextView(this);
        int paddingDp = 45;
        float density = getResources().getDisplayMetrics().density;
        int paddingPixel = (int)(paddingDp * density);
        final int[] puntuaciones = { 0,0 };
        puntuacion1.setText("0");
        puntuacion2.setText("0");
        texto.setText("Haber estudiao");
        puntuacion1.setPadding(paddingPixel,0,paddingPixel,0);
        puntuacio.addView(puntuacion1, LayoutParams.WRAP_CONTENT);
        puntuacio.addView(texto);
        puntuacion2.setPadding(paddingPixel,0,paddingPixel,0);
        puntuacio.addView(puntuacion2, LayoutParams.WRAP_CONTENT);

        layoutPadre.addView(puntuacio);

        //creamos el layout que contendrá la imagen
        final ImageView[] imageView = {new ImageView(this)};
        imageView[0].setImageResource(R.drawable.nada);
        imageView[0].setPadding(0,paddingDp,0,paddingDp);
        layoutPadre.addView(imageView[0]);

        //creamos los botones
        LinearLayout botones = new LinearLayout(this);
        int paddingDp2 = 42;
        float density2 = getResources().getDisplayMetrics().density;
        int paddingPixel2 = (int)(paddingDp2 * density2);
        Button piedra = new Button(this);
        Button papel = new Button(this);
        Button tijera = new Button(this);

        piedra.setText("piedra");
        piedra.setPadding(paddingPixel2,0,paddingPixel2,0);
        papel.setText("papel");
        papel.setPadding(paddingPixel2,0,paddingPixel2,0);
        tijera.setText("tijera");
        tijera.setPadding(paddingPixel2,0,paddingPixel2,0);

        botones.addView(piedra);
        botones.addView(papel);
        botones.addView(tijera);
        layoutPadre.addView(botones);
        piedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nAleatorio = (int)(Math.random() * 4) + 1;
                switch (nAleatorio){
                    case 1:
                        imageView[0].setImageResource(R.drawable.piedra);
                        Toast toast = Toast.makeText(getApplicationContext(), "empate", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case 2:
                        imageView[0].setImageResource(R.drawable.papel);
                        puntuaciones[1]++;
                        puntuacion2.setText(String.valueOf(puntuaciones[1]));

                        break;
                    case 3:
                        imageView[0].setImageResource(R.drawable.tijeras);
                        puntuaciones[0]++;
                        puntuacion1.setText(String.valueOf(puntuaciones[0]));
                        break;
                }
            }
        });
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nAleatorio = (int)(Math.random() * 4) + 1;
                switch (nAleatorio){
                    case 1:
                        imageView[0].setImageResource(R.drawable.piedra);
                        puntuaciones[0]++;
                        puntuacion1.setText(String.valueOf(puntuaciones[0]));
                        break;
                    case 2:
                        imageView[0].setImageResource(R.drawable.papel);Toast toast = Toast.makeText(getApplicationContext(), "empate", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case 3:
                        imageView[0].setImageResource(R.drawable.tijeras);
                        puntuaciones[1]++;
                        puntuacion2.setText(String.valueOf(puntuaciones[1]));

                        break;
                }
            }
        });
        tijera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nAleatorio = (int)(Math.random() * 4) + 1;
                switch (nAleatorio){
                    case 1:
                        imageView[0].setImageResource(R.drawable.piedra);
                        puntuaciones[1]++;
                        puntuacion2.setText(String.valueOf(puntuaciones[1]));
                        break;
                    case 2:
                        imageView[0].setImageResource(R.drawable.papel);
                        puntuaciones[0]++;
                        puntuacion1.setText(String.valueOf(puntuaciones[0]));
                        break;
                    case 3:
                        imageView[0].setImageResource(R.drawable.tijeras);
                        Toast toast = Toast.makeText(getApplicationContext(), "empate", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                }
            }
        });


        setContentView(layoutPadre);
    }

}