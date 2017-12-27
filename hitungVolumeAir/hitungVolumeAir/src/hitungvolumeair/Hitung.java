/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitungvolumeair;

/**
 *
 * @author Mang Wie
 */
public class Hitung {
    private double volumeTotal,volumeAir, volumeAir2, tinggiAir, tinggiTabung = 350, diameter = 140, volumeTabung;
    
    public Hitung(double tinggi){
        this.tinggiAir = tinggi;
    }
    
    public void hitungVolumeAir(){
        double jariJari = diameter/2;
        double rKuadrat = Math.pow(jariJari,2);
        double luasLingkaran = 3.14 * rKuadrat;
        volumeTabung = 3.14*(rKuadrat)*tinggiTabung;
        System.out.println("volume tabung = "+volumeTabung);
        if(tinggiAir < jariJari){
            //tinggi tembereng dari titik pusat
            double temberengJarak = jariJari - tinggiAir;
            //System.out.println(temberengJarak);
            //mencari sudut pusat segitiga
            double cosPusat = temberengJarak/jariJari;
            double pusat = Math.acos(cosPusat);
            double sudutPusat = Math.toDegrees(pusat);
            double sudutJuring = 2*sudutPusat;
            //menentukan luas juring
            double luasJuring = (sudutJuring/360)*(luasLingkaran);
            //mencari luas segitiga
            double alasSegitiga = Math.sqrt((Math.pow(jariJari,2))-(Math.pow(temberengJarak,2)));
            double luasSegitiga = 0.5 * alasSegitiga * temberengJarak;
            double luasTembereng = luasJuring - luasSegitiga;
            //volum air
            volumeAir = luasTembereng * tinggiTabung;
            System.out.println("Volume air dalam tabung (cm^3) = "+volumeAir);
        }
        else if(tinggiAir == jariJari){
            volumeAir = volumeTabung/2;
            System.out.println("Volume air dalam tabung (cm^3) = "+volumeAir);
        }
        else{
             //tinggi tembereng dari titik pusat
            double temberengJarak =  tinggiAir - jariJari;
            //System.out.println(temberengJarak);
            //mencari sudut pusat segitiga
            double cosPusat = temberengJarak/jariJari;
            double pusat = Math.acos(cosPusat);
            double sudutPusat = Math.toDegrees(pusat);
            double sudutJuring = 2*sudutPusat;
            //menentukan luas juring
            double luasJuring = (sudutJuring/360)*(luasLingkaran);
            //mencari luas segitiga
            double alasSegitiga = Math.sqrt((Math.pow(jariJari,2))-(Math.pow(temberengJarak,2)));
            double luasSegitiga = 0.5 * alasSegitiga * temberengJarak;
            double luasTembereng = luasJuring - luasSegitiga;
            //volum air
            double volumeKosong = luasTembereng * tinggiTabung;
            volumeAir = volumeTabung - volumeKosong;
            System.out.println("Volume air dalam tabung (cm^3) = "+volumeAir);
        }
    }
    
    public void volumeBola(){
        double jariJari = diameter/2;
        double volumeBola = 4/3 * 3.14 * (Math.pow(jariJari,3));
        System.out.println("Volume bola (cm^3) = "+volumeBola);
        if(tinggiAir == jariJari){
            volumeAir2 = volumeBola/2;
             System.out.println("Volume air dalam bola (cm^3) = "+volumeAir2);
        }
        else if(tinggiAir > diameter){
            System.out.println("tinggi air tidak boleh melebii diameter!");
        }
        else if(tinggiAir == diameter){
            volumeAir2 = volumeBola;
            System.out.println("Volume air dalam bola (cm^3) = "+volumeAir2);
        }
        else if(tinggiAir < jariJari){
            double t = jariJari-tinggiAir;
            volumeAir2 = 0.333*3.14*(Math.pow(t, 2))*((3*jariJari)-t);
            System.out.println("Volume air dalam bola (cm^3) = "+volumeAir2);
        }
        else{
            double t = tinggiAir-jariJari;
            double volumeKosong = 1/3 * 3.14 * (Math.pow(t, 2)) * ((3*jariJari)-t);
            volumeAir2 = volumeBola - volumeKosong;
            System.out.println("Volume air dalam bola (cm^3) = "+volumeAir2);
        }
    }
    
    public double volumeAirTotal(){
        volumeTotal = volumeAir + volumeAir2;
        return volumeTotal;
    }
}
