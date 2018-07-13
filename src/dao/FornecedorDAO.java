package dao;

import java.util.ArrayList;
import model.Fornecedor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class FornecedorDAO extends GenericDAO {

    public Fornecedor buscarPorCodigo(Long codigo) throws Exception {
        Session sessao = null;
        Fornecedor fornecedor = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        fornecedor = (Fornecedor) sessao.get(Fornecedor.class, codigo);
        return fornecedor;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Fornecedor> buscarTodos() throws Exception {
        ArrayList<Fornecedor> listaRetorno = new ArrayList<Fornecedor>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Fornecedor.class);
        criteria.addOrder(Order.asc("idFornecedor"));
        listaRetorno = (ArrayList<Fornecedor>) criteria.list();
        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Fornecedor> buscarPorNome(String razao_social) throws Exception {
        ArrayList<Fornecedor> listaRetorno = new ArrayList<Fornecedor>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Fornecedor.class);
        criteria.add(Restrictions.ilike("razao_social", "%" + razao_social + "%"));
        criteria.addOrder(Order.asc("razao_social"));
        listaRetorno = (ArrayList<Fornecedor>) criteria.list();
        return listaRetorno;
    }
}