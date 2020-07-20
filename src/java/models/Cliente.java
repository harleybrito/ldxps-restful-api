package models;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlTransient;

public class Cliente {
    private String CDCL;
    private String DSNOME;
    private String IDTIPO;
    private String CDVEND;
    private double DSLIM;
    private Map<String, Cliente> clientes = new HashMap<>();

    public Cliente() {
    }

    public Cliente(String CDCL, String DSNOME, String IDTIPO, String CDVEND, double DSLIM) {
        this.CDCL = CDCL;
        this.DSNOME = DSNOME;
        this.IDTIPO = IDTIPO;
        this.CDVEND = CDVEND;
        this.DSLIM = DSLIM;
    }

    public String getCDCL() {
        return CDCL;
    }

    public void setCDCL(String CDCL) {
        this.CDCL = CDCL;
    }

    public String getDSNOME() {
        return DSNOME;
    }

    public void setDSNOME(String DSNOME) {
        this.DSNOME = DSNOME;
    }

    public String getIDTIPO() {
        return IDTIPO;
    }

    public void setIDTIPO(String IDTIPO) {
        this.IDTIPO = IDTIPO;
    }

    public String getCDVEND() {
        return CDVEND;
    }

    public void setCDVEND(String CDVEND) {
        this.CDVEND = CDVEND;
    }

    public double getDSLIM() {
        return DSLIM;
    }

    public void setDSLIM(double DSLIM) {
        this.DSLIM = DSLIM;
    }

    @XmlTransient
    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
}
