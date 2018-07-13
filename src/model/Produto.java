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
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "valor_venda")
    private Double valorVenda;
    
    @Column(name = "valor_custo")
    private Double valorCusto;
    
    @Column(name = "qtde_min_estoque")
    private Integer qtdeMinEstoque;

    @Column(name = "qtde_estoque_atual")
    private Integer qtdeEstoqueAtual;

    @JoinColumn(name = "fornecedor_id_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedorIdFornecedor;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Integer getQtdeMinEstoque() {
        return qtdeMinEstoque;
    }

    public void setQtdeMinEstoque(Integer qtdeMinEstoque) {
        this.qtdeMinEstoque = qtdeMinEstoque;
    }

    public Integer getQtdeEstoqueAtual() {
        return qtdeEstoqueAtual;
    }

    public void setQtdeEstoqueAtual(Integer qtdeEstoqueAtual) {
        this.qtdeEstoqueAtual = qtdeEstoqueAtual;
    }

    public Fornecedor getFornecedorIdFornecedor() {
        return fornecedorIdFornecedor;
    }

    public void setFornecedorIdFornecedor(Fornecedor fornecedorIdFornecedor) {
        this.fornecedorIdFornecedor = fornecedorIdFornecedor;
    }

}