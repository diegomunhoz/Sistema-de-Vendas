package dao;

import java.util.ArrayList;
import model.Endereco;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import util.HibernateUtil;

public class EnderecoDAO extends GenericDAO {

    public Endereco buscarPorCodigo(int codigo) throws Exception {
        Session sessao = null;
        Endereco endereco = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        endereco = (Endereco) sessao.get(Endereco.class, codigo);
        return endereco;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Endereco> buscarTodos() throws Exception {
        ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Endereco.class);
        criteria.addOrder(Order.asc("idEndereco"));
        listaRetorno = (ArrayList<Endereco>) criteria.list();
        return listaRetorno;
    }
}