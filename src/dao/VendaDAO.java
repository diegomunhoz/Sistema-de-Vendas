package dao;

import java.util.ArrayList;
import model.Venda;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import util.HibernateUtil;

public class VendaDAO extends GenericDAO {

    public Venda buscarPorCodigo(int codigo) throws Exception {
        Session sessao = null;
        Venda venda = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        venda = (Venda) sessao.get(Venda.class, codigo);
        return venda;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Venda> buscarTodos() throws Exception {
        ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Venda.class);
        criteria.addOrder(Order.asc("idVenda"));
        listaRetorno = (ArrayList<Venda>) criteria.list();
        return listaRetorno;
    }
}