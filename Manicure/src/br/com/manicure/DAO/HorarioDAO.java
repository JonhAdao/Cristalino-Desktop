/**
 * @author John
 */
package br.com.manicure.DAO;

import br.com.manicure.conexao.Conexao;
import br.com.manicure.model.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorarioDAO {

    private static final String HORARIOS = "SELECT id, hora FROM horario";

    public static List<Horario> horarios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Horario> horarios = new ArrayList();
        try {
            conn = new Conexao().getConexao();
            stmt = conn.prepareStatement(HORARIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Horario horas = new Horario();
                horas.setHora(rs.getTime("hora"));
                horas.setId(rs.getInt("id"));

                horarios.add(horas);
            }
            return horarios;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
