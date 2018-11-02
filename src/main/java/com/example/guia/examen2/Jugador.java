package com.example.guia.examen2;

import java.io.Serializable;

public class Jugador implements Serializable {
    String nick;
    int puntaje;

    public Jugador(String nick, int puntaje) {
        this.nick = nick;
        this.puntaje = puntaje;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
