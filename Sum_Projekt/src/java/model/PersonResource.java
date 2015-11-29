/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Arthur
 */
public interface PersonResource extends Serializable{
    public Aktivitet addAktivitet(Aktivitet a);
    public List<Aktivitet> getAktiviteter();
}