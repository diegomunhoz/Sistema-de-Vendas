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
@Table(name = "item_venda")
public class ItemVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_item_venda")
    private Integer idItemVenda;

    @Column(name = "quantidade_produto")
    private Integer quantidadeProduto;
    
    @Column(name = "desconto_produto")
    private Double descontoProduto;
    
    @Column(name = "valor_total")
    private Double valorTotal;
    
    @JoinColumn(name = "produto_id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto produtoIdProduto;
    
    @JoinColumn(name = "venda_id_venda", referencedColumnName = "id_venda")
    @ManyToOne(optional = false)
    private Venda vendaIdVenda;

    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public Double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(Double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProdutoIdProduto() {
        return produtoIdProduto;
    }

    public void setProdutoIdProduto(Produto produtoIdProduto) {
        this.produtoIdProduto = produtoIdProduto;
    }

    public Venda getVendaIdVenda() {
        return vendaIdVenda;
    }

    public void setVendaIdVenda(Venda vendaIdVenda) {
        this.vendaIdVenda = vendaIdVenda;
    }

}