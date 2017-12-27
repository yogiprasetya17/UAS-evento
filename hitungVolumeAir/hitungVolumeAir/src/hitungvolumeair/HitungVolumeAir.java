/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitungvolumeair;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Mang Wie
 */
public class HitungVolumeAir {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("PROGRAM MENCARI VOLUME AIR");
        System.out.print("Masukkan tinggi air (cm): ");
        double tinggiAir = sc.nextDouble();
        
        Hitung ht = new Hitung(tinggiAir);
        ht.hitungVolumeAir();
        ht.volumeBola();
        System.out.println("volume air Keseluruhan : "+ht.volumeAirTotal());
    }
    
}
