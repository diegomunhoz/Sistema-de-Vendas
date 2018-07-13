package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Diego Munhoz
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venda")
    private Integer idVenda;
    
    @Column(name = "data_venda")
    private String dataVenda;
    
    @Column(name = "valor_total")
    private Double valorTotal;
    
    @Column(name = "valor_pago")
    private Double valorPago;
    
    @Column(name = "valor_troco")
    private Double valorTroco;
    
    @JoinColumn(name = "funcionario_id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioIdFuncionario;

    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente clienteIdCliente;

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(Double valorTroco) {
        this.valorTroco = valorTroco;
    }

    public Funcionario getFuncionarioIdFuncionario() {
        return funcionarioIdFuncionario;
    }

    public void setFuncionarioIdFuncionario(Funcionario funcionarioIdFuncionario) {
        this.funcionarioIdFuncionario = funcionarioIdFuncionario;
    }

    public Cliente getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(Cliente clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

}