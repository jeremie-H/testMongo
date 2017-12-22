package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "myrecords")
public class MyRecord {

    @Id
    private String id;

    private final String origine;

    private final String appareil;

    private final String chambre;

    private final String lit;

    private final String uf;

    @Indexed
    private final String ipp;

    private final String domaineIpp;

    private final String iep;

    private final String domaineIep;

    private final String ej;

    private final Instant dateReception;

    @Indexed
    private final String codeMesure;

    private final String uniteMesure;

    private final Double valeurMesure;

    @Indexed
    private final Instant dateMesure;

    public MyRecord(final String id, final String origine, final String appareil, final String chambre, final String lit,
                    final String uf, final String ipp, final String domaineIpp, final String iep, final String domaineIep,
                    final String ej, final Instant dateReception, final String codeMesure, final String uniteMesure, final Double valeurMesure, final Instant dateMesure) {

        this.id=id;
        this.origine = origine;
        this.appareil = appareil;
        this.chambre = chambre;
        this.lit = lit;
        this.uf = uf;
        this.ipp = ipp;
        this.domaineIpp = domaineIpp;
        this.iep = iep;
        this.domaineIep = domaineIep;
        this.ej = ej;
        this.dateReception = dateReception;
        this.codeMesure = codeMesure;
        this.uniteMesure = uniteMesure;
        this.valeurMesure = valeurMesure;
        this.dateMesure = dateMesure;

    }


    public String getId() {
        return this.id;
    }


    public String getIpp() {
        return this.ipp;
    }


    public String getOrigine() {
        return this.origine;
    }


    public String getAppareil() {
        return this.appareil;
    }


    public String getChambre() {
        return this.chambre;
    }


    public String getLit() {
        return this.lit;
    }


    public String getUf() {
        return this.uf;
    }


    public String getDomaineIpp() {
        return this.domaineIpp;
    }


    public String getIep() {
        return this.iep;
    }


    public String getDomaineIep() {
        return this.domaineIep;
    }


    public String getEj() {
        return this.ej;
    }


    public Instant getDateReception() {
        return this.dateReception;
    }


    public String getCodeMesure() {
        return codeMesure;
    }


    public String getUniteMesure() {
        return uniteMesure;
    }


    public Double getValeurMesure() {
        return valeurMesure;
    }


    public Instant getDateMesure() {
        return dateMesure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyRecord myRecord = (MyRecord) o;

        if (!id.equals(myRecord.id)) return false;
        if (origine != null ? !origine.equals(myRecord.origine) : myRecord.origine != null) return false;
        if (appareil != null ? !appareil.equals(myRecord.appareil) : myRecord.appareil != null) return false;
        if (chambre != null ? !chambre.equals(myRecord.chambre) : myRecord.chambre != null) return false;
        if (lit != null ? !lit.equals(myRecord.lit) : myRecord.lit != null) return false;
        if (uf != null ? !uf.equals(myRecord.uf) : myRecord.uf != null) return false;
        if (ipp != null ? !ipp.equals(myRecord.ipp) : myRecord.ipp != null) return false;
        if (domaineIpp != null ? !domaineIpp.equals(myRecord.domaineIpp) : myRecord.domaineIpp != null) return false;
        if (iep != null ? !iep.equals(myRecord.iep) : myRecord.iep != null) return false;
        if (domaineIep != null ? !domaineIep.equals(myRecord.domaineIep) : myRecord.domaineIep != null) return false;
        if (ej != null ? !ej.equals(myRecord.ej) : myRecord.ej != null) return false;
        if (dateReception != null ? !dateReception.equals(myRecord.dateReception) : myRecord.dateReception != null)
            return false;
        if (codeMesure != null ? !codeMesure.equals(myRecord.codeMesure) : myRecord.codeMesure != null) return false;
        if (uniteMesure != null ? !uniteMesure.equals(myRecord.uniteMesure) : myRecord.uniteMesure != null)
            return false;
        if (valeurMesure != null ? !valeurMesure.equals(myRecord.valeurMesure) : myRecord.valeurMesure != null)
            return false;
        return dateMesure != null ? dateMesure.equals(myRecord.dateMesure) : myRecord.dateMesure == null;
    }

    @Override
    public int hashCode() {
        int result = (id != null ? origine.hashCode() : 0);
        result = 31 * result + (origine != null ? origine.hashCode() : 0);
        result = 31 * result + (appareil != null ? appareil.hashCode() : 0);
        result = 31 * result + (chambre != null ? chambre.hashCode() : 0);
        result = 31 * result + (lit != null ? lit.hashCode() : 0);
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        result = 31 * result + (ipp != null ? ipp.hashCode() : 0);
        result = 31 * result + (domaineIpp != null ? domaineIpp.hashCode() : 0);
        result = 31 * result + (iep != null ? iep.hashCode() : 0);
        result = 31 * result + (domaineIep != null ? domaineIep.hashCode() : 0);
        result = 31 * result + (ej != null ? ej.hashCode() : 0);
        result = 31 * result + (dateReception != null ? dateReception.hashCode() : 0);
        result = 31 * result + (codeMesure != null ? codeMesure.hashCode() : 0);
        result = 31 * result + (uniteMesure != null ? uniteMesure.hashCode() : 0);
        result = 31 * result + (valeurMesure != null ? valeurMesure.hashCode() : 0);
        result = 31 * result + (dateMesure != null ? dateMesure.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MyRecord{" +
                "id='" + id + '\'' +
                ", origine='" + origine + '\'' +
                ", appareil='" + appareil + '\'' +
                ", chambre='" + chambre + '\'' +
                ", lit='" + lit + '\'' +
                ", uf='" + uf + '\'' +
                ", ipp='" + ipp + '\'' +
                ", domaineIpp='" + domaineIpp + '\'' +
                ", iep='" + iep + '\'' +
                ", domaineIep='" + domaineIep + '\'' +
                ", ej='" + ej + '\'' +
                ", dateReception=" + dateReception +
                ", codeMesure='" + codeMesure + '\'' +
                ", uniteMesure='" + uniteMesure + '\'' +
                ", valeurMesure=" + valeurMesure +
                ", dateMesure=" + dateMesure +
                '}';
    }
}
