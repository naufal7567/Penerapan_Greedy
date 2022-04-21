package com.paket_greedy;

import java.io.*;
import java.lang.*;

public class Main {
    static int n = 5, W;
    static obj st[];
    public static BufferedReader br = new BufferedReader (new
            InputStreamReader(System.in));
    public static void main(String[] agus) throws IOException {
        int i = 0;
        System.out.println("--------------------------Knapsack Problem--------------------------\n");
        System.out.print("Banyak barang yang ingin diangkut : ");
        n = Integer.parseInt(br.readLine());
        System.out.print("Kapasitas maksimum truk (Kg) : ");
        W = Integer.parseInt ( br.readLine() );
        st = new obj[n];
        for (i=0; i< n; i++) {
            st[i] = new obj();
            System.out.print("Barang #" + (i + 1) + " :-\n\tBerat (Kg) : ");
            st[i].weight = Float.parseFloat(br.readLine());
            System.out.print ("\tProfit (Rp): ");
            st[i].profit = Float.parseFloat(br.readLine());
            st[i].p_perKg = Round (st[i].profit / st[i].weight, 2);
            System.out.print("\tProfit per Kg: " + st[i].p_perKg + "\n");
            st[i].index = i + 1;
        }
        bubbleSort();
        System.out.print("\nSolusi Optimal : ");
        input_barang();
    }
    public static float Round(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return(float) tmp / p;
    }
    static void input_barang() {
        float x[] = new float[n];
        float u, tot_profit = 0;
        int i;
        for (i=0; i<n; i++)
            x[i] = 0;
        u = W;
        for (i = 0; i < n; i++) {
            if (st[i].weight > u)
                break;
            x[i] = 1;
            u -= st[i].weight;
            System.out.print("\nMemasukkan barang #" + st[i].index + " (Rp. " + st[i].profit + " , " + st[i].weight + " Kg) kedalam truk.\n" );
            System.out.print("Kapasitas truk yang tersisa : " + u + " Kg\n");
            tot_profit += st[i].profit;
        }
        System.out.print("\n\nTotal Profit yang didapatkan = Rp." + tot_profit + "-");
    }
    static void bubbleSort() {
        for (int pass=1; pass<n; pass++)
            for (int i=0; i<n-pass; i++)
                if (st[i].p_perKg < st[i+1].p_perKg) {
                    obj temp = new obj();
                    temp = st[i];
                    st[i] = st[i+1];
                    st[i+1] = temp;
                }
    }
    static class obj {
        float weight;
        float profit;
        float p_perKg;
        int index;
    }
}