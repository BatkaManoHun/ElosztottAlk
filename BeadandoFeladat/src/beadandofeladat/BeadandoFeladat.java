package beadandofeladat;

import java.util.Random;

public class BeadandoFeladat {

    public static void main(String[] args) {
       Harcos harcos = new Harcos();
       Varazslo varazslo = new Varazslo();  
       Jatekter jatekter = new Jatekter();
       
       Random random_hp = new Random();
       Random lepes = new Random();
       Random sebzes = new Random();
       
       harcos.eletero = 3 + random_hp.nextInt(6)+1;
       harcos.pozicio = 0;
       
       varazslo.eletero = 3 + random_hp.nextInt(6)+1;
       varazslo.pozicio = 2;
            
       jatekter.jatekter[0] = 'H';
       jatekter.jatekter[1] = '_';
       jatekter.jatekter[2] = 'V';
       
       System.out.println(jatekter.jatekter[0]+""+jatekter.jatekter[1]+""+jatekter.jatekter[2]+" --> H:"+harcos.eletero+", V:"+varazslo.eletero);
       
        while ((harcos.eletero != 0) && (varazslo.eletero != 0)) {
            harcos.pozicio = lepes.nextInt(3);
            varazslo.pozicio = lepes.nextInt(3);
            for (int i = 0; i < jatekter.jatekter.length; i++) {
                jatekter.jatekter[i] = ' ';
            }

            if (harcos.pozicio == varazslo.pozicio) {
                int harcos_sebzes = sebzes.nextInt(7);
                int varazslo_sebzes = sebzes.nextInt(7);
                
                if (varazslo.eletero - harcos_sebzes >= 0) {
                    varazslo.eletero = varazslo.eletero - harcos_sebzes;
                } else {
                    varazslo.eletero = 0;
                }
                if (harcos.eletero - varazslo_sebzes >= 0) {
                    harcos.eletero = harcos.eletero - varazslo_sebzes;
                } else {
                    harcos.eletero = 0;
                }
                jatekter.jatekter[harcos.pozicio] = 'X';
                for (int i = 0; i < jatekter.jatekter.length; i++) {
                    if (jatekter.jatekter[i] == ' ') {
                        jatekter.jatekter[i] = '_';
                    }
                }
                System.out.println(jatekter.jatekter[0] + "" + jatekter.jatekter[1] + "" + jatekter.jatekter[2] + " --> H:" + harcos.eletero + ", V:" + varazslo.eletero);

            } else {
                jatekter.jatekter[harcos.pozicio] = 'H';
                jatekter.jatekter[varazslo.pozicio] = 'V';
                for (int i = 0; i < jatekter.jatekter.length; i++) {
                    if (jatekter.jatekter[i] == ' ') {
                        jatekter.jatekter[i] = '_';
                    }
                }
                System.out.println(jatekter.jatekter[0] + "" + jatekter.jatekter[1] + "" + jatekter.jatekter[2] + " --> H:" + harcos.eletero + ", V:" + varazslo.eletero);
            }
        }
        
        System.out.println("Játék vége");
    }
    
}
