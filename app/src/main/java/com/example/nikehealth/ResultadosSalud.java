package com.example.nikehealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ResultadosSalud extends AppCompatActivity {

    TextView res;
    LottieAnimationView l;

    int medico = 0,medicamentos=0,emocionales=0,estres=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_salud);

        res = findViewById(R.id.Resultados);
        l = findViewById(R.id.animacion);
        l.animate().setDuration(2700).setStartDelay(2900);

        medico = (int) getIntent().getSerializableExtra("medico");
        medicamentos = (int) getIntent().getSerializableExtra("medicamentos");
        emocionales = (int) getIntent().getSerializableExtra("emocionales");
        estres = (int) getIntent().getSerializableExtra("estres");

        if (medico == 1 && medicamentos == 1 && emocionales == 1 && estres == 1) {
            l.setAnimation(R.raw.estres);
            res.setText("Tratamiento de los trastornos del estado de ánimo\n" +
                    "La depresión y el trastorno bipolar son dos trastornos del estado de ánimo frecuentes. El trastorno bipolar también se conoce como depresión maníaca. Estas enfermedades suelen tratarse con medicamentos y terapia. Su proveedor de atención médica podrá darle más información acerca de los tratamientos adecuados para usted. Un hospital o una clínica mental también pueden brindarle ayuda." +
                    "\n" + "Tratamientos para la depresión\n" +
                    "La depresión hace que se sienta triste, inútil, impotente o desesperanzado. Puede perder el interés por cosas que solía disfrutar. El tratamiento incluye medicamentos y terapia de conversación (o verbal). Los medicamentos antidepresivos cambian el nivel de ciertas sustancias químicas en el cerebro, lo que lo ayuda a sentirse mejor. " +
                    "\n\n" + "No siempre puede evitar el estrés en su vida, pero puede aprender a manejarlo mejor. Los Institutos Nacionales de la Salud recomiendan estas medidas:\n" +
                    "\n" + "Establezca prioridades. Decidir qué cosas se deben hacer y qué cosas pueden esperar y aprender a decir no a tareas nuevas si usted está abrumado(a).\n" +
                    "Manténgase en contacto con personas que pueden proporcionar apoyo emocional y de otra índole. Pida ayuda a los amigos, la familia y la comunidad u organizaciones religiosas para reducir el estrés debido a responsabilidades laborales o asuntos familiares, tal como el cuidado de un ser querido.\n" +
                    "Tómese tiempo para hacer actividades relajantes que disfruta como leer, hacer yoga o jardinería.\n" +
                    "Evite pensar obsesivamente en los problemas. Enfóquese en lo que ha logrado, no en lo que no ha podido hacer.\n" +
                    "Haga ejercicio con regularidad. Una caminata moderada de solo 30 minutos por día puede ayudar a levantarle el ánimo y reducir el estrés.\n" +
                    "Si siente que está consumiendo drogas o alcohol para sobrellevar el estrés o si está teniendo pensamientos suicidas, acuda a un profesional de la salud emocional");
        }
        if (medico == 1 && medicamentos == 1 && emocionales == 1 && estres == 2) {
            l.setAnimation(R.raw.emocionalmente);
            res.setText("Tratamiento de los trastornos del estado de ánimo\n" +
                    "La depresión y el trastorno bipolar son dos trastornos del estado de ánimo frecuentes. El trastorno bipolar también se conoce como depresión maníaca. Estas enfermedades suelen tratarse con medicamentos y terapia. Su proveedor de atención médica podrá darle más información acerca de los tratamientos adecuados para usted. Un hospital o una clínica mental también pueden brindarle ayuda." +
                    "\n" + "Tratamientos para la depresión\n" +
                    "La depresión hace que se sienta triste, inútil, impotente o desesperanzado. Puede perder el interés por cosas que solía disfrutar. El tratamiento incluye medicamentos y terapia de conversación (o verbal). Los medicamentos antidepresivos cambian el nivel de ciertas sustancias químicas en el cerebro, lo que lo ayuda a sentirse mejor. ");
        }
        if (medico == 1 && medicamentos == 1 && emocionales == 2 && estres == 2) {
            l.setAnimation(R.raw.medicina);
            res.setText("La decisión de ver a un médico puede variar, dependiendo de si la visita es para atención preventiva (visitas de rutina), por problemas médicos o por una emergencia. " +
                    "\n" + "En general, todos debemos acudir normalmente al médico, al dentista y al oftalmólogo para revisiones preventivas. Las mujeres deben acudir regularmente al médico de atención primaria o al ginecólogo para revisiones ginecológicas. Es conveniente pedir al médico de atención primaria una pauta sobre el tipo de atención que se requiere y la frecuencia de las consultas. Normalmente, los niños y las personas mayores necesitan realizar visitas preventivas más frecuentes, pero la frecuencia depende también del estado de salud de cada persona. Por ejemplo, una persona diabética o con una enfermedad cardíaca (o en riesgo de padecerla) necesitará revisiones más frecuentes.");
        }
        if (medico == 1 && medicamentos == 2 && emocionales == 2 && estres == 2) {
            l.setAnimation(R.raw.consulta);
            res.setText("La decisión de ver a un médico puede variar, dependiendo de si la visita es para atención preventiva (visitas de rutina), por problemas médicos o por una emergencia. " +
                    "\n" + "En general, todos debemos acudir normalmente al médico, al dentista y al oftalmólogo para revisiones preventivas. Las mujeres deben acudir regularmente al médico de atención primaria o al ginecólogo para revisiones ginecológicas. Es conveniente pedir al médico de atención primaria una pauta sobre el tipo de atención que se requiere y la frecuencia de las consultas. Normalmente, los niños y las personas mayores necesitan realizar visitas preventivas más frecuentes, pero la frecuencia depende también del estado de salud de cada persona. Por ejemplo, una persona diabética o con una enfermedad cardíaca (o en riesgo de padecerla) necesitará revisiones más frecuentes.");
        }
        if (medico == 1 && medicamentos == 2 && emocionales == 1 && estres == 2) {
            l.setAnimation(R.raw.emocionalmente);
            res.setText("Tratamiento de los trastornos del estado de ánimo\n" +
                    "La depresión y el trastorno bipolar son dos trastornos del estado de ánimo frecuentes. El trastorno bipolar también se conoce como depresión maníaca. Estas enfermedades suelen tratarse con medicamentos y terapia. Su proveedor de atención médica podrá darle más información acerca de los tratamientos adecuados para usted. Un hospital o una clínica mental también pueden brindarle ayuda." +
                    "\n" + "Tratamientos para la depresión\n" +
                    "La depresión hace que se sienta triste, inútil, impotente o desesperanzado. Puede perder el interés por cosas que solía disfrutar. El tratamiento incluye medicamentos y terapia de conversación (o verbal). Los medicamentos antidepresivos cambian el nivel de ciertas sustancias químicas en el cerebro, lo que lo ayuda a sentirse mejor. " +
                    "\n" + "La decisión de ver a un médico puede variar, dependiendo de si la visita es para atención preventiva (visitas de rutina), por problemas médicos o por una emergencia. " +
                    "\n" + "En general, todos debemos acudir normalmente al médico, al dentista y al oftalmólogo para revisiones preventivas. Las mujeres deben acudir regularmente al médico de atención primaria o al ginecólogo para revisiones ginecológicas. Es conveniente pedir al médico de atención primaria una pauta sobre el tipo de atención que se requiere y la frecuencia de las consultas. Normalmente, los niños y las personas mayores necesitan realizar visitas preventivas más frecuentes, pero la frecuencia depende también del estado de salud de cada persona. Por ejemplo, una persona diabética o con una enfermedad cardíaca (o en riesgo de padecerla) necesitará revisiones más frecuentes.");
        }
        if (medico == 2 && medicamentos == 2 && emocionales == 1 && estres == 1) {
            l.setAnimation(R.raw.emocionalmente);
            res.setText("Tratamiento de los trastornos del estado de ánimo\n" +
                    "La depresión y el trastorno bipolar son dos trastornos del estado de ánimo frecuentes. El trastorno bipolar también se conoce como depresión maníaca. Estas enfermedades suelen tratarse con medicamentos y terapia. Su proveedor de atención médica podrá darle más información acerca de los tratamientos adecuados para usted. Un hospital o una clínica mental también pueden brindarle ayuda." +
                    "\n" + "Tratamientos para la depresión\n" +
                    "La depresión hace que se sienta triste, inútil, impotente o desesperanzado. Puede perder el interés por cosas que solía disfrutar. El tratamiento incluye medicamentos y terapia de conversación (o verbal). Los medicamentos antidepresivos cambian el nivel de ciertas sustancias químicas en el cerebro, lo que lo ayuda a sentirse mejor. " +
                    "\n\n" + "No siempre puede evitar el estrés en su vida, pero puede aprender a manejarlo mejor. Los Institutos Nacionales de la Salud recomiendan estas medidas:\n" +
                    "\n" + "Establezca prioridades. Decidir qué cosas se deben hacer y qué cosas pueden esperar y aprender a decir no a tareas nuevas si usted está abrumado(a).\n" +
                    "Manténgase en contacto con personas que pueden proporcionar apoyo emocional y de otra índole. Pida ayuda a los amigos, la familia y la comunidad u organizaciones religiosas para reducir el estrés debido a responsabilidades laborales o asuntos familiares, tal como el cuidado de un ser querido.\n" +
                    "Tómese tiempo para hacer actividades relajantes que disfruta como leer, hacer yoga o jardinería.\n" +
                    "Evite pensar obsesivamente en los problemas. Enfóquese en lo que ha logrado, no en lo que no ha podido hacer.\n" +
                    "Haga ejercicio con regularidad. Una caminata moderada de solo 30 minutos por día puede ayudar a levantarle el ánimo y reducir el estrés.\n" +
                    "Si siente que está consumiendo drogas o alcohol para sobrellevar el estrés o si está teniendo pensamientos suicidas, acuda a un profesional de la salud emocional");
        }
        if (medico == 2 && medicamentos == 1 && emocionales == 2 && estres == 2) {
            l.setAnimation(R.raw.medicina);
            res.setText("los fallos más habituales a la hora de medicarnos:\n\n" +
                    "\n" +
                    "No seguir el horario en el que hay que tomar cada dosis. Esto es importantísimo, porque se establece para garantizar una eficacia.\n\n" +
                    "Olvidar alguna dosis. Esto puede significar una pérdida de eficacia total, por ejemplo en la reaparición de un dolor.\n\n" +
                    "No completar la duración de un tratamiento porque creemos que nos sentimos mejor. Por ejemplo, cuando tomamos un antibiótico, la mejoría aparece a los pocos días pero la infección no ha sido eliminada de nuestro organismo.\n\n" +
                    "Olvidarnos de los medicamentos cuando vamos de viaje. Esto ocurre sobre todo en enfermedades crónicas porque asociamos un viaje a estar vacaciones y descansar de la medicación, lo cual es un grave error.\n\n" +
                    "Dejar de tomar una medicación crónica para que nuestro organismo ‘descanse’.\n\n" +
                    "No seguir las recomendaciones de la ingesta del fármaco en relación a las comidas. Por ejemplo, las pastillas para bajar el azúcar es necesario tomárselas media hora antes de la comida para que cuando empecemos a comer, nuestros niveles de azúcar en la sangre no suban.\n\n" +
                    "No dar al médico una información correcta sobre los síntomas o los medicamentos que tomamos, o dejar de proporcionarle datos. Esto es muy habitual entre las personas mayores que llegan a tomar dos o tres medicamentos con nombres diferentes para el mismo problema. Esto puede llevar a graves intoxicaciones o interacciones medicamentosas.\n\n" +
                    "Recomendar fármacos a otras personas porque a nosotros nos ha ido bien para unos síntomas similares. No existen enfermedades sino enfermos, es decir, el medico adapta a cada paciente la terapia que necesita según sus características.\n\n" +
                    "Algunos factores que favorecen el incumplimiento son: la falta de educación sanitaria sobre la enfermedad padecida; la complejidad del tratamiento prescrito; la mala relación profesional sanitario-paciente; las reacciones adversas; y la falta de apoyo familiar, social y sanitario. Los pacientes ancianos son los mayores consumidores de medicamentos dispensados con prescripción y constituyen un grupo especialmente susceptible a una peor adherencia terapéutica.");
        }
        if (medico == 2 && medicamentos == 2 && emocionales == 1 && estres == 2) {
            l.setAnimation(R.raw.emocionalmente);
            res.setText("Tratamiento de los trastornos del estado de ánimo\n" +
                    "La depresión y el trastorno bipolar son dos trastornos del estado de ánimo frecuentes. El trastorno bipolar también se conoce como depresión maníaca. Estas enfermedades suelen tratarse con medicamentos y terapia. Su proveedor de atención médica podrá darle más información acerca de los tratamientos adecuados para usted. Un hospital o una clínica mental también pueden brindarle ayuda." +
                    "\n" + "Tratamientos para la depresión\n" +
                    "La depresión hace que se sienta triste, inútil, impotente o desesperanzado. Puede perder el interés por cosas que solía disfrutar. El tratamiento incluye medicamentos y terapia de conversación (o verbal). Los medicamentos antidepresivos cambian el nivel de ciertas sustancias químicas en el cerebro, lo que lo ayuda a sentirse mejor. ");
        }
        if (medico == 2 && medicamentos == 2 && emocionales == 2 && estres == 2) {
            l.setAnimation(R.raw.todobien);
            res.setText("Usted esta sano mentalmente!, no parece que haya problemas emocionales o de estrés que lo esten preocupando!");
        }
        if (medico == 2 && medicamentos == 2 && emocionales == 2 && estres == 1) {
            l.setAnimation(R.raw.estres);
            res.setText("No siempre puede evitar el estrés en su vida, pero puede aprender a manejarlo mejor. Los Institutos Nacionales de la Salud recomiendan estas medidas:\n" +
                    "\n" + "Establezca prioridades. Decidir qué cosas se deben hacer y qué cosas pueden esperar y aprender a decir no a tareas nuevas si usted está abrumado(a).\n" +
                    "Manténgase en contacto con personas que pueden proporcionar apoyo emocional y de otra índole. Pida ayuda a los amigos, la familia y la comunidad u organizaciones religiosas para reducir el estrés debido a responsabilidades laborales o asuntos familiares, tal como el cuidado de un ser querido.\n" +
                    "Tómese tiempo para hacer actividades relajantes que disfruta como leer, hacer yoga o jardinería.\n" +
                    "Evite pensar obsesivamente en los problemas. Enfóquese en lo que ha logrado, no en lo que no ha podido hacer.\n" +
                    "Haga ejercicio con regularidad. Una caminata moderada de solo 30 minutos por día puede ayudar a levantarle el ánimo y reducir el estrés.\n" +
                    "Si siente que está consumiendo drogas o alcohol para sobrellevar el estrés o si está teniendo pensamientos suicidas, acuda a un profesional de la salud emocional");
        }
        if (medico == 2 && medicamentos == 1 && emocionales == 2 && estres == 1) {
            l.setAnimation(R.raw.estres);
            res.setText("No siempre puede evitar el estrés en su vida, pero puede aprender a manejarlo mejor. Los Institutos Nacionales de la Salud recomiendan estas medidas:\n" +
                    "\n" + "Establezca prioridades. Decidir qué cosas se deben hacer y qué cosas pueden esperar y aprender a decir no a tareas nuevas si usted está abrumado(a).\n" +
                    "Manténgase en contacto con personas que pueden proporcionar apoyo emocional y de otra índole. Pida ayuda a los amigos, la familia y la comunidad u organizaciones religiosas para reducir el estrés debido a responsabilidades laborales o asuntos familiares, tal como el cuidado de un ser querido.\n" +
                    "Tómese tiempo para hacer actividades relajantes que disfruta como leer, hacer yoga o jardinería.\n" +
                    "Evite pensar obsesivamente en los problemas. Enfóquese en lo que ha logrado, no en lo que no ha podido hacer.\n" +
                    "Haga ejercicio con regularidad. Una caminata moderada de solo 30 minutos por día puede ayudar a levantarle el ánimo y reducir el estrés.\n" +
                    "Si siente que está consumiendo drogas o alcohol para sobrellevar el estrés o si está teniendo pensamientos suicidas, acuda a un profesional de la salud emocional" +"\n\n"+
                    "los fallos más habituales a la hora de medicarnos:\n\n" +
                    "\n" +
                    "No seguir el horario en el que hay que tomar cada dosis. Esto es importantísimo, porque se establece para garantizar una eficacia.\n\n" +
                    "Olvidar alguna dosis. Esto puede significar una pérdida de eficacia total, por ejemplo en la reaparición de un dolor.\n\n" +
                    "No completar la duración de un tratamiento porque creemos que nos sentimos mejor. Por ejemplo, cuando tomamos un antibiótico, la mejoría aparece a los pocos días pero la infección no ha sido eliminada de nuestro organismo.\n\n" +
                    "Olvidarnos de los medicamentos cuando vamos de viaje. Esto ocurre sobre todo en enfermedades crónicas porque asociamos un viaje a estar vacaciones y descansar de la medicación, lo cual es un grave error.\n\n" +
                    "Dejar de tomar una medicación crónica para que nuestro organismo ‘descanse’.\n\n" +
                    "No seguir las recomendaciones de la ingesta del fármaco en relación a las comidas. Por ejemplo, las pastillas para bajar el azúcar es necesario tomárselas media hora antes de la comida para que cuando empecemos a comer, nuestros niveles de azúcar en la sangre no suban.\n\n" +
                    "No dar al médico una información correcta sobre los síntomas o los medicamentos que tomamos, o dejar de proporcionarle datos. Esto es muy habitual entre las personas mayores que llegan a tomar dos o tres medicamentos con nombres diferentes para el mismo problema. Esto puede llevar a graves intoxicaciones o interacciones medicamentosas.\n\n" +
                    "Recomendar fármacos a otras personas porque a nosotros nos ha ido bien para unos síntomas similares. No existen enfermedades sino enfermos, es decir, el medico adapta a cada paciente la terapia que necesita según sus características.\n\n" +
                    "Algunos factores que favorecen el incumplimiento son: la falta de educación sanitaria sobre la enfermedad padecida; la complejidad del tratamiento prescrito; la mala relación profesional sanitario-paciente; las reacciones adversas; y la falta de apoyo familiar, social y sanitario. Los pacientes ancianos son los mayores consumidores de medicamentos dispensados con prescripción y constituyen un grupo especialmente susceptible a una peor adherencia terapéutica.");
        }
        if (medico == 1 && medicamentos == 1 && emocionales == 2 && estres == 1) {
            l.setAnimation(R.raw.estres);
            res.setText("\n\n" + "No siempre puede evitar el estrés en su vida, pero puede aprender a manejarlo mejor. Los Institutos Nacionales de la Salud recomiendan estas medidas:\n" +
                    "\n" + "Establezca prioridades. Decidir qué cosas se deben hacer y qué cosas pueden esperar y aprender a decir no a tareas nuevas si usted está abrumado(a).\n" +
                    "Manténgase en contacto con personas que pueden proporcionar apoyo emocional y de otra índole. Pida ayuda a los amigos, la familia y la comunidad u organizaciones religiosas para reducir el estrés debido a responsabilidades laborales o asuntos familiares, tal como el cuidado de un ser querido.\n" +
                    "Tómese tiempo para hacer actividades relajantes que disfruta como leer, hacer yoga o jardinería.\n" +
                    "Evite pensar obsesivamente en los problemas. Enfóquese en lo que ha logrado, no en lo que no ha podido hacer.\n" +
                    "Haga ejercicio con regularidad. Una caminata moderada de solo 30 minutos por día puede ayudar a levantarle el ánimo y reducir el estrés.\n" +
                    "Si siente que está consumiendo drogas o alcohol para sobrellevar el estrés o si está teniendo pensamientos suicidas, acuda a un profesional de la salud emocional");
        }
        if (medico == 2 && medicamentos == 1 && emocionales == 1 && estres == 1) {
            l.setAnimation(R.raw.estres);
            l.setAnimation(R.raw.estres);
            res.setText("Tratamiento de los trastornos del estado de ánimo\n" +
                    "La depresión y el trastorno bipolar son dos trastornos del estado de ánimo frecuentes. El trastorno bipolar también se conoce como depresión maníaca. Estas enfermedades suelen tratarse con medicamentos y terapia. Su proveedor de atención médica podrá darle más información acerca de los tratamientos adecuados para usted. Un hospital o una clínica mental también pueden brindarle ayuda." +
                    "\n" + "Tratamientos para la depresión\n" +
                    "La depresión hace que se sienta triste, inútil, impotente o desesperanzado. Puede perder el interés por cosas que solía disfrutar. El tratamiento incluye medicamentos y terapia de conversación (o verbal). Los medicamentos antidepresivos cambian el nivel de ciertas sustancias químicas en el cerebro, lo que lo ayuda a sentirse mejor. " +
                    "\n\n" + "No siempre puede evitar el estrés en su vida, pero puede aprender a manejarlo mejor. Los Institutos Nacionales de la Salud recomiendan estas medidas:\n" +
                    "\n" + "Establezca prioridades. Decidir qué cosas se deben hacer y qué cosas pueden esperar y aprender a decir no a tareas nuevas si usted está abrumado(a).\n" +
                    "Manténgase en contacto con personas que pueden proporcionar apoyo emocional y de otra índole. Pida ayuda a los amigos, la familia y la comunidad u organizaciones religiosas para reducir el estrés debido a responsabilidades laborales o asuntos familiares, tal como el cuidado de un ser querido.\n" +
                    "Tómese tiempo para hacer actividades relajantes que disfruta como leer, hacer yoga o jardinería.\n" +
                    "Evite pensar obsesivamente en los problemas. Enfóquese en lo que ha logrado, no en lo que no ha podido hacer.\n" +
                    "Haga ejercicio con regularidad. Una caminata moderada de solo 30 minutos por día puede ayudar a levantarle el ánimo y reducir el estrés.\n" +
                    "Si siente que está consumiendo drogas o alcohol para sobrellevar el estrés o si está teniendo pensamientos suicidas, acuda a un profesional de la salud emocional");
        }
        if (medico == 1 && medicamentos == 2 && emocionales == 2 && estres == 1) {
            l.setAnimation(R.raw.estres);
            res.setText("\n\n" + "No siempre puede evitar el estrés en su vida, pero puede aprender a manejarlo mejor. Los Institutos Nacionales de la Salud recomiendan estas medidas:\n" +
                    "\n" + "Establezca prioridades. Decidir qué cosas se deben hacer y qué cosas pueden esperar y aprender a decir no a tareas nuevas si usted está abrumado(a).\n" +
                    "Manténgase en contacto con personas que pueden proporcionar apoyo emocional y de otra índole. Pida ayuda a los amigos, la familia y la comunidad u organizaciones religiosas para reducir el estrés debido a responsabilidades laborales o asuntos familiares, tal como el cuidado de un ser querido.\n" +
                    "Tómese tiempo para hacer actividades relajantes que disfruta como leer, hacer yoga o jardinería.\n" +
                    "Evite pensar obsesivamente en los problemas. Enfóquese en lo que ha logrado, no en lo que no ha podido hacer.\n" +
                    "Haga ejercicio con regularidad. Una caminata moderada de solo 30 minutos por día puede ayudar a levantarle el ánimo y reducir el estrés.\n" +
                    "Si siente que está consumiendo drogas o alcohol para sobrellevar el estrés o si está teniendo pensamientos suicidas, acuda a un profesional de la salud emocional");
        }
    }
}