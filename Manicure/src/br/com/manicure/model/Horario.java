package br.com.manicure.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class Horario {

    private int id;
    private Time hora;
    private List<Agendamentos> agendamentos;

    public Horario() {
        this.agendamentos = new ArrayList(6);
        for (int i = 0; i < 6; i++) {
            this.agendamentos.add(new Agendamentos());
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public List<Agendamentos> getAgendamentos() {
        return this.agendamentos;
    }

    public Agendamentos getAgendamento(int column) {
        if (!this.agendamentos.isEmpty() && this.agendamentos.size() > column) {
            return this.agendamentos.get(column);
        }
        return null;
    }

    public void setAgendamento(int column, Agendamentos agenda) {
        this.agendamentos.add(column - 1, agenda);
    }
}
