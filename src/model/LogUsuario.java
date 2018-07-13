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
@Table(name = "log_usuario")
public class LogUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log_usuario")
    private Integer idLogUsuario;
    
    @JoinColumn(name = "funcionario_id_funcionario", referencedColumnName = "id_funcionario")
    @ManyToOne(optional = false)
    private Funcionario funcionarioIdFuncionario;

    @Column(name = "data_login")
    private String dataLogin;
    
    @Column(name = "hora_login")
    private String horaLogin;

    public Integer getIdLogUsuario() {
        return idLogUsuario;
    }

    public void setIdLogUsuario(Integer idLogUsuario) {
        this.idLogUsuario = idLogUsuario;
    }

    public Funcionario getEnderecoIdFuncionario() {
        return funcionarioIdFuncionario;
    }

    public void setEnderecoIdFuncionario(Funcionario funcionarioIdFuncionario) {
        this.funcionarioIdFuncionario = funcionarioIdFuncionario;
    }

    public String getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(String dataLogin) {
        this.dataLogin = dataLogin;
    }

    public String getHoraLogin() {
        return horaLogin;
    }

    public void setHoraLogin(String horaLogin) {
        this.horaLogin = horaLogin;
    }

}