package models;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlTransient;

public class Vendedor {
    private String CDVEND;
    private String DSNOME;
    private int CDTAB;
    private Date DTNASC;
    private Map<String, Vendedor> vendedores = new HashMap<>();

    public Vendedor() {
    }

    public Vendedor(String CDVEND, String DSNOME, int CDTAB, Date DTNASC) {
        this.CDVEND = CDVEND;
        this.DSNOME = DSNOME;
        this.CDTAB = CDTAB;
        this.DTNASC = DTNASC;
    }

    public String getCDVEND() {
        return CDVEND;
    }

    public void setCDVEND(String CDVEND) {
        this.CDVEND = CDVEND;
    }

    public String getDSNOME() {
        return DSNOME;
    }

    public void setDSNOME(String DSNOME) {
        this.DSNOME = DSNOME;
    }

    public int getCDTAB() {
        return CDTAB;
    }

    public void setCDTAB(int CDTAB) {
        this.CDTAB = CDTAB;
    }

    public Date getDTNASC() {
        return DTNASC;
    }

    public void setDTNASC(Date DTNASC) {
        this.DTNASC = DTNASC;
    }

    @XmlTransient
    public Map<String, Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Map<String, Vendedor> vendedores) {
        this.vendedores = vendedores;
    }
    
    
}
