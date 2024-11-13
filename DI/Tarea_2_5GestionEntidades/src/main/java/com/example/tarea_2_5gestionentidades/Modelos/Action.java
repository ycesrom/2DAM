package com.example.tarea_2_5gestionentidades.Modelos;

import javafx.beans.property.*;

import java.sql.Timestamp;

public class Action
{
    private IntegerProperty id=new SimpleIntegerProperty();
    private IntegerProperty action_id=new SimpleIntegerProperty();
    private IntegerProperty sequence=new SimpleIntegerProperty();
    private StringProperty state=new SimpleStringProperty();
    private StringProperty name=new SimpleStringProperty();
    private ObjectProperty<Timestamp> create_date = new SimpleObjectProperty<>();


    // Constructor vacío
    public Action()
    {

    }

    // Constructor completo para crear una accion con todos sus atributos
    public Action(Integer id, Integer action_id, Integer sequence, String state, String name, Timestamp create_date)
    {
        this.id.set(id);
        this.action_id.set(action_id);
        this.sequence.set(sequence);
        this.state.set(state);
        this.name.set(name);
        this.create_date.set(create_date);


    }

    // Métodos getter y setter para los atributos
    public Integer getId(){return id.get();}
    public IntegerProperty getIdProperty()
    {
        return id; // Devuelve el valor del id
    }
    public Integer getSequence(){return sequence.get();}
    public IntegerProperty getSequenceProperty()
    {
        return sequence;// Devuelve el valor de la secuencia
    }

    public Integer getAction_id() {return action_id.get();} // Devuelve el valor de la accionId
    public IntegerProperty getAction_idProperty() {return action_id; // Devuelve el valor de la accionId
    }

    public String getState() {return state.get(); }
    public StringProperty getStateProperty() {return state; }// Devuelve el valor de el estado}


    public String getName(){return name.get();}
    public StringProperty getNameProperty() {return name; }// Devuelve el valor de el nombre

    public Timestamp getCreate_date() {return create_date.get();}
    public ObjectProperty<Timestamp> createDateProperty() {return create_date;}
    public void setCreate_date(Timestamp createDate) {
        this.create_date.set(createDate);
    }





}
