package beadandofeladat;

import java.util.Random;

public class BeadandoFeladat {

    public static void main(String[] args) {
            
       Random random_hp = new Random();
       Random lepes = new Random();
       Random sebzes = new Random();
       
       try{
       // karakterek generálása random élettel, pozícióval, karakter tipussal
       Harcos harcos = new Harcos(3 + random_hp.nextInt(6)+1,0,'H');
       Varazslo varazslo = new Varazslo(3 + random_hp.nextInt(6)+1,2,'V');  
       
       
       Jatekter jatekter = new Jatekter();
       
       //játéktér inicializálása
       jatekter.jatekter[0] = harcos.getTipus();
       jatekter.jatekter[1] = '_';
       jatekter.jatekter[2] = varazslo.getTipus();
       
       System.out.println(jatekter.jatekter[0]+""+jatekter.jatekter[1]+""+jatekter.jatekter[2]+" --> H:"+harcos.getEletero()+", V:"+varazslo.getEletero());
       
       //Harc amíg valamelyik karakter élete el nem éri a 0-át
        while ((harcos.getEletero() != 0) && (varazslo.getEletero() != 0)) {
            
            //lépegetés a pályán
            harcos.setPozicio(lepes.nextInt(3));
            varazslo.setPozicio(lepes.nextInt(3));
            for (int i = 0; i < jatekter.jatekter.length; i++) {
                jatekter.jatekter[i] = ' ';
            }
            // ugyan az a ppozíció, akkor harc
            if (harcos.getPozicio() == varazslo.getPozicio()) {
                
                // a random sebzések eltárolása
                int harcos_sebzes = sebzes.nextInt(7);
                int varazslo_sebzes = sebzes.nextInt(7);
                
                //harc utáni életerők állítása
                if (varazslo.getEletero() - harcos_sebzes >= 0) {
                    varazslo.setEletero(varazslo.getEletero() - harcos_sebzes);
                } else {
                    varazslo.setEletero(0);
                }
                if (harcos.getEletero() - varazslo_sebzes >= 0) {
                    harcos.setEletero(harcos.getEletero() - varazslo_sebzes);
                } else {
                    harcos.setEletero(0);
                }
                
                //játéktér frissítése harc esetén
                jatekter.jatekter[harcos.getPozicio()] = 'X';
                for (int i = 0; i < jatekter.jatekter.length; i++) {
                    if (jatekter.jatekter[i] == ' ') {
                        jatekter.jatekter[i] = '_';
                    }
                }
                System.out.println(jatekter.jatekter[0] + "" + jatekter.jatekter[1] + "" + jatekter.jatekter[2] + " --> H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());

            } else {
                 //játéktér frissítése lépés esetén
                jatekter.jatekter[harcos.getPozicio()] = harcos.getTipus();
                jatekter.jatekter[varazslo.getPozicio()] = varazslo.getTipus();
                for (int i = 0; i < jatekter.jatekter.length; i++) {
                    if (jatekter.jatekter[i] == ' ') {
                        jatekter.jatekter[i] = '_';
                    }
                }
                System.out.println(jatekter.jatekter[0] + "" + jatekter.jatekter[1] + "" + jatekter.jatekter[2] + " --> H:" + harcos.getEletero() + ", V:" + varazslo.getEletero());
            }
        }
        
        System.out.println("Játék vége");
        }
         catch (EleteroRangeCheckedException ex){
            System.err.println(ex.getMessage());
        } catch (PozicioRangeCheckedException ex) {
            System.err.println(ex);
        }
    }
    
}
