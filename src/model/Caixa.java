package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diego Munhoz
 */
@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caixa")
    private Integer idCaixa;

    @Column(name = "data_caixa")
    @Temporal(TemporalType.DATE)
    private Date dataCaixa;
    
    @Column(name = "valor_total_caixa")
    private Double valorTotalCaixa;
    
    @Column(name = "situacao_caixa")
    private Character situacaoCaixa;

    public Integer getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(Integer idCaixa) {
        this.idCaixa = idCaixa;
    }

    public Date getDataCaixa() {
        return dataCaixa;
    }

    public void setDataCaixa(Date dataCaixa) {
        this.dataCaixa = dataCaixa;
    }

    public Double getValorTotalCaixa() {
        return valorTotalCaixa;
    }

    public void setValorTotalCaixa(Double valorTotalCaixa) {
        this.valorTotalCaixa = valorTotalCaixa;
    }

    public Character getSituacaoCaixa() {
        return situacaoCaixa;
    }

    public void setSituacaoCaixa(Character situacaoCaixa) {
        this.situacaoCaixa = situacaoCaixa;
    }

}