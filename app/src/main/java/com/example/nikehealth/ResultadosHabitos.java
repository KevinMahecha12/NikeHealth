package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ResultadosHabitos extends AppCompatActivity {
    TextView res;
    LottieAnimationView l;

    int durmiobien = 0;
    int tienesiestas = 0;
    int seacuestemprano = 0;
    int tieneocio = 0;
    int problemaocio = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_habitos);

        res  = findViewById(R.id.Resultados);
        l = findViewById(R.id.animacion);
        l.animate().setDuration(2700).setStartDelay(2900);

        durmiobien = (int) getIntent().getSerializableExtra("duermebien");
        tienesiestas = (int) getIntent().getSerializableExtra("tienesiesta");
        seacuestemprano = (int) getIntent().getSerializableExtra("temprano");
        tieneocio = (int) getIntent().getSerializableExtra("ocio");
        problemaocio = (int) getIntent().getSerializableExtra("problemaocio");


        if(durmiobien == 1 && tienesiestas == 1 && seacuestemprano == 1 &&  problemaocio == 2) {
            l.setAnimation(R.raw.todobien);
            res.setText("Usted esta sano!, sus hábitos parecen estar en orden!");
        }
        if(durmiobien == 2) {
            l.setAnimation(R.raw.dormir);
            res.setText("La falta de sueño puede afectar tu sistema inmunitario. Se ha demostrado en estudios que las personas que no tienen horas de sueño de calidad o suficientes horas de sueño tienen más probabilidades de enfermarse tras estar expuestas a un virus, tal como un virus de resfrío común. La falta de sueño también puede afectar la velocidad a la que te recuperas si te enfermas.\n" +
                    "\n" +
                    "Durante el sueño, el sistema inmunitario libera proteínas llamadas citocinas, algunas de las cuales ayudan a promover el sueño. Algunas citocinas deben aumentar cuando tienes una infección o inflamación o cuando estás estresado. La falta de sueño puede reducir la producción de estas citocinas protectoras. Además, los anticuerpos y las células que combaten infecciones disminuyen durante los períodos en los que no duermes lo suficiente.");
        }
        if(tienesiestas == 2) {
            l.setAnimation(R.raw.siesta);
            res.setText("Haz siestas cortas. Trata de tomar siestas de solo 10 o 20 minutos. Cuanto más tiempo duermas la siesta, más probable es que te sientas atontando después. Sin embargo, los adultos jóvenes podrían tolerar siestas más largas.\n" +
                    "Duerme la siesta a primera hora de la tarde. Tomar una siesta después de las 3 p. m. puede interferir con el sueño nocturno. Los factores individuales, como tu necesidad de dormir, tus horarios de sueño, tu edad y el uso de medicamentos, también pueden ser importantes para determinar la mejor hora del día para dormir la siesta.\n" +
                    "Crea un ambiente de descanso. Duerme en un lugar tranquilo y oscuro, con una temperatura ambiente cómoda y pocas distracciones.");
        }
        if(seacuestemprano == 2) {
            l.setAnimation(R.raw.acuestatarde);
            res.setText("Los investigadores también señalan que dormir tarde está asociado a una mayor prevalencia de enfermedades cardiovasculares, diabetes o enfermedades respiratorias. Si sabemos que dormir mal tiene repercusiones negativas en tu salud y que los late sleepers tienen mayores problemas para conciliar sueño y ritmo social, el resultado es lógico.");
        }
        if(tieneocio == 2) {
            l.setAnimation(R.raw.estres);
            res.setText("El ocio también es salud, el hecho de no hacer nada en algún momento del día puede ser increíblemente beneficioso. No hay que esperar a tener vacaciones para permitirnos esos instantes de calma e inactividad. Regalarnos dos o tres horas de calma y quietud reinicia, reduce el estrés, potencia la creatividad y revierte en salud mental.\n" +
                    "\n" +
                    "Es momento por tanto de cambiar nuestro esquema mental: estar siempre haciendo algo también puede ser contraproducente. La vida solo puede saborearse cuando nos regalamos tiempo de calidad y ello, pasa a menudo por el ocio, por la calma e incluso por el arte de no hacer nada.");
        }
        if(durmiobien == 2 && tienesiestas == 2 && seacuestemprano == 2 && tieneocio == 2) {
            l.setAnimation(R.raw.estres);
            res.setText("La falta de sueño puede afectar tu sistema inmunitario. Se ha demostrado en estudios que las personas que no tienen horas de sueño de calidad o suficientes horas de sueño tienen más probabilidades de enfermarse tras estar expuestas a un virus, tal como un virus de resfrío común. La falta de sueño también puede afectar la velocidad a la que te recuperas si te enfermas.\n" +
                    "\n" +
                    "Durante el sueño, el sistema inmunitario libera proteínas llamadas citocinas, algunas de las cuales ayudan a promover el sueño. Algunas citocinas deben aumentar cuando tienes una infección o inflamación o cuando estás estresado. La falta de sueño puede reducir la producción de estas citocinas protectoras. Además, los anticuerpos y las células que combaten infecciones disminuyen durante los períodos en los que no duermes lo suficiente." +"\n\n"+
                    "Haz siestas cortas. Trata de tomar siestas de solo 10 o 20 minutos. Cuanto más tiempo duermas la siesta, más probable es que te sientas atontando después. Sin embargo, los adultos jóvenes podrían tolerar siestas más largas. Duerme la siesta a primera hora de la tarde. Tomar una siesta después de las 3 p. m. puede interferir con el sueño nocturno. Los factores individuales, como tu necesidad de dormir, tus horarios de sueño, tu edad y el uso de medicamentos, también pueden ser importantes para determinar la mejor hora del día para dormir la siesta." +"\n\n" +
                    "Crea un ambiente de descanso. Duerme en un lugar tranquilo y oscuro, con una temperatura ambiente cómoda y pocas distracciones. "+"\n\n" +
                    "El ocio también es salud, el hecho de no hacer nada en algún momento del día puede ser increíblemente beneficioso. No hay que esperar a tener vacaciones para permitirnos esos instantes de calma e inactividad. Regalarnos dos o tres horas de calma y quietud reinicia, reduce el estrés, potencia la creatividad y revierte en salud mental."+ "\n\n" +
                    "Es momento por tanto de cambiar nuestro esquema mental: estar siempre haciendo algo también puede ser contraproducente. La vida solo puede saborearse cuando nos regalamos tiempo de calidad y ello, pasa a menudo por el ocio, por la calma e incluso por el arte de no hacer nada.");
        }
    }
}