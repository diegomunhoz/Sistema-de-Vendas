package dao;

import java.util.ArrayList;
import model.Funcionario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class FuncionarioDAO extends GenericDAO {

    public Funcionario buscarPorCodigo(int codigo) throws Exception {
        Session sessao = null;
        Funcionario funcionario = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        funcionario = (Funcionario) sessao.get(Funcionario.class, codigo);
        return funcionario;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Funcionario> buscarTodos() throws Exception {
        ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.addOrder(Order.asc("idFuncionario"));
        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Funcionario> buscarPorNome(String nome) throws Exception {
        ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.add(Restrictions.ilike("nome", "%" + nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        return listaRetorno;
    }
}