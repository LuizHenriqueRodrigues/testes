package Util;

import java.io.Serializable;

public class MsgResponse implements Serializable {
    
    private Status status;
    private double value;
    private String resultado;

    public MsgResponse(Status status, double value) {
        this.status = status;
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public double getValue() {
        return value;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
}



