import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexaoProduto extends ConexaoBD {
    public static void inserir (Produto p) {
        abrirConexao();
        try {
            String sql = "INSERT INTO produto (id, descricao, quantidade, valor) VALUES (?, ?, ?, ?)";
            estado = conn.prepareStatement(sql);
            estado.setInt(1, p.getId());
            estado.setString(2, p.getDescricao());
            estado.setInt(3, p.getQuantidade());
            estado.setDouble(4, p.getValor());
            estado.execute();
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir produto.");
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public static void atualizar (Produto p) {
        abrirConexao();
        try {
            String sql = "UPDATE produto SET descricao = ?, quantidade = ?, valor = ? WHERE id = ?";
            estado = conn.prepareStatement(sql);
            estado.setString(1, p.getDescricao());
            estado.setInt(2, p.getQuantidade());
            estado.setDouble(3, p.getValor());
            estado.setInt(4, p.getId());
            estado.execute();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar produto.");
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public static void deletar (Produto p) {
        abrirConexao();
        try {
            String sql = "DELETE FROM produto WHERE id = ?";
            estado = conn.prepareStatement(sql);
            estado.setInt(1, p.getId());
            estado.execute();
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar deletar produto.");
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }
}
