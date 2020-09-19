package edu.eci.cvds.servlet;

import java.lang.Math;
import java.util.ArrayList;
import static java.lang.Math.sqrt;
import javax.faces.bean.*;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;




@ManagedBean(name = "calculadoraBean")
@SessionScoped
public class CalculadoraBean {
    private double promedio;
    private double varianza;
    private double standar;
    private int longitud;
    private ArrayList<Double> numeros;
    private double moda;
  
    

    public void calculate(String list) {
    	try {
    		numeros = new ArrayList<Double>();
        	String[] array = list.split(";");
        	for( String string: array) {
        		numeros.add( Double.parseDouble(string) );
        	}
        	calculateAll();
            
    	}
    	catch(Exception e) {
    		restart();
    	}
    	
    }
    public void restart(){
    	numeros= new ArrayList<Double>();
    	numeros.add(0.0);
    	calculateAll();
    }

    public void calculateMean(ArrayList<Double> list){
    	promedio = 0;
        for (Double number:list){
        	promedio += number;
        }
        promedio/= longitud;
    }
    public void calculateStandardDeviation(ArrayList<Double> list){
        standar = Math.sqrt(calculateVariance(list));
    }
    /**
     * 
     * @param list
     * @return
     */
    public double calculateVariance(ArrayList<Double> list){
        double a = 0;
        varianza =0;
        for (Double number:list){
            a +=  Math.pow(promedio - number,2f);
        }
        varianza = a/(longitud-1);
        return varianza;
    }
    
    public void calculateMode(ArrayList<Double> list){
        int veces = -1,c;
        moda = 0;
        for(int i = 0; i < longitud; i++){
            double a = numeros.get(i);
            c = 0;
            for (int j = i; j < longitud; j++){
                if (list.get(j) == a ){
                    c++;
                }
            }
            if (c > veces){
                moda = a;
                veces = c;
            }
        }
    }
    
    private void calculateAll() {
    	setNumeros(numeros);
    	calculateMean(numeros);
    	calculateMode(numeros);
    	calculateVariance(numeros);
    	calculateStandardDeviation(numeros);
    	
    }

    public ArrayList<Double> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Double> numeros) {
        this.numeros = numeros;
        setLongitud(numeros.size());
    }

    public double getModa() {
        return moda;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public double getVarianza() {
        return varianza;
    }

    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    public double getStandar() {
        return standar;
    }

    public void setStandar(double standar) {
        this.standar = standar;
    }
}