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
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "rg")
    private String rg;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "celular")
    private String celular;
    
    @Column(name = "dt_nascimento")
    private String dtNascimento;
    
    @JoinColumn(name = "endereco_id_endereco", referencedColumnName = "id_endereco")
    @ManyToOne(optional = false)
    private Endereco enderecoIdEndereco;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Endereco getEnderecoIdEndereco() {
        return enderecoIdEndereco;
    }

    public void setEnderecoIdEndereco(Endereco enderecoIdEndereco) {
        this.enderecoIdEndereco = enderecoIdEndereco;
    }

}
