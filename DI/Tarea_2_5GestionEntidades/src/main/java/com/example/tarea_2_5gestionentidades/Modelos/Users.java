package com.example.tarea_2_5gestionentidades.Modelos;

import javafx.beans.property.*;

import java.sql.Timestamp;

public class Users
{
    private IntegerProperty id;
    private BooleanProperty activo;
    private ObjectProperty<Timestamp> create_date = new SimpleObjectProperty<>();
    private StringProperty login;
    private StringProperty password;
    private IntegerProperty action_id;
    private IntegerProperty create_uid;
    private IntegerProperty write_uid;
    private StringProperty signature;
    private BooleanProperty share;
    private ObjectProperty<Timestamp> write_date = new SimpleObjectProperty<>();
    private StringProperty totp_secret;

    public Users()
    {

    }

    public Users(Integer id, Boolean activo, Timestamp create_date, String login,String password,
                 Integer action_id, Integer create_uid, Integer write_uid, String signature,
                 Boolean share,Timestamp write_date, String totp_secret)
    {
        this.id.set(id);
        this.activo.set(activo);
        this.create_date.set(create_date);
        this.login.set(login);
        this.password.set(password);
        this.action_id.set(action_id);
        this.create_uid.set(create_uid);
        this.write_uid.set(write_uid);
        this.signature.set(signature);
        this.share.set(share);
        this.write_date.set(write_date);
        this.totp_secret.set(totp_secret);

    }

    public Integer getId(){return id.get();}
    public IntegerProperty getIdProperty(){return id;}
    public Boolean getActivo(){return activo.get();}
    public BooleanProperty getActivoProperty(){return activo;}
    
    public Timestamp getCreate_date(){return create_date.get();}
    public ObjectProperty<Timestamp> getCreate_dateProperty(){return create_date;}
    public String getLogin(){return login.get();}
    public StringProperty getLoginProperty(){return login;}
    public String getPassword(){return password.get();}
    public StringProperty getPasswordProperty(){return password;}
    public Integer getAction_id(){return action_id.get();}
    public IntegerProperty getAction_idProperty(){return action_id;}
    public Integer getCreate_uid(){return create_uid.get();}
    public IntegerProperty getCreate_uidProperty(){return create_uid;}
    public Integer getWrite_uid(){return write_uid.get();}
    public IntegerProperty getWrite_uidProperty(){return write_uid;}
    public String getSignature(){return signature.get();}
    public StringProperty getSignatureProperty(){return signature;}
    public Boolean getShare(){return share.get();}
    public Timestamp getWrite_date(){return write_date.get();}
    public ObjectProperty<Timestamp> getWrite_dateProperty(){return write_date;}



}
