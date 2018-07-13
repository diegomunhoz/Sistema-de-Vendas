package dao;

import java.util.ArrayList;
import model.Cliente;
import model.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ProdutoDAO extends GenericDAO {

    public Produto buscarPorCodigo(int codigo) throws Exception {
        Session sessao = null;
        Produto produto = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        produto = (Produto) sessao.get(Produto.class, codigo);
        return produto;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Produto> buscarTodos() throws Exception {
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Produto.class);
        criteria.addOrder(Order.asc("idProduto"));
        listaRetorno = (ArrayList<Produto>) criteria.list();
        return listaRetorno;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<Produto> buscarPorDescricao(String descricao) throws Exception {
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Produto.class);
        criteria.add(Restrictions.ilike("descricao", "%" + descricao + "%"));
        criteria.addOrder(Order.asc("descricao"));
        listaRetorno = (ArrayList<Produto>) criteria.list();
        return listaRetorno;
    }
    
}