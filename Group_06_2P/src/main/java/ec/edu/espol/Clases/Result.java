/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.Clases;

import java.io.Serializable;

/**
 *
 * @author angelozurita
 */
public class Result implements Serializable{
    private Type_game tipo;
    private int victories;
    private int tie;
    private int defeat ; 

    public Result(Type_game tipo, int victories, int tie, int defeat) {
        this.tipo = tipo;
        this.victories = victories;
        this.tie = tie;
        this.defeat = defeat;
    }

    public Type_game getTipo() {
        return tipo;
    }

    public void setTipo(Type_game tipo) {
        this.tipo = tipo;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getTie() {
        return tie;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }
    
    
}
