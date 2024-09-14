package br.com.manicure.dao.factory;

import br.com.manicure.DAO.AgendamentosDAO;
import br.com.manicure.DAO.ClientesDAO;
import br.com.manicure.DAO.EsmalteDAO;
import br.com.manicure.DAO.HorarioDAO;
import br.com.manicure.DAO.PacotesDAO;
import br.com.manicure.DAO.ProcedimentoDAO;
import br.com.manicure.DAO.UsuarioDAO;
import br.com.manicure.interfaces.GenericDAO;
import br.com.manicure.model.Agendamentos;
import br.com.manicure.model.Cliente;
import br.com.manicure.model.Esmalte;
import br.com.manicure.model.Horario;
import br.com.manicure.model.Pacotes;
import br.com.manicure.model.Procedimento;
import br.com.manicure.model.Usuarios;

/**
 *
 * @author John
 */
public class DAOFactory {

    public static GenericDAO<Cliente> getClienteDAO() {
        return new ClientesDAO();
    }

    public static GenericDAO<Agendamentos> getAgendamentoDAO() {
        return new AgendamentosDAO();
    }

    public static GenericDAO<Esmalte> getEsmalteDAO() {
        return new EsmalteDAO();
    }

    public static GenericDAO<Pacotes> getPacoteDAO() {
        return new PacotesDAO();
    }

    public static GenericDAO<Procedimento> getProcedimentoDAO() {
        return new ProcedimentoDAO();
    }

    public static GenericDAO<Usuarios> getUsuarioDAO() {
        return new UsuarioDAO();
    }
    
        public static GenericDAO<Horario> getHorarioDAO() {
        return (GenericDAO<Horario>) new HorarioDAO();
    }

}
