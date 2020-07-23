package br.edu.ufersa.sismart.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ufersa.sismart.model.VO.ItemVO;

public class ItemDAO extends BaseDAO<ItemVO>{

	@Override
	public void inserir(ItemVO value) throws SQLException {
		String sql = "insert into item (nome, marca, codigoDeBarras, quantidadeEmEstoque, preco, "
				+ "quantidadeCompra, id_tipo, id_cesta) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ptst;
		
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, value.getNome());	
			ptst.setString(2, value.getMarca());
			ptst.setString(3, value.getCodigoDeBarras());
			ptst.setLong(4, value.getQuantidadeEmEstoque());
			ptst.setDouble(5, value.getPreco());
			ptst.setLong(6, value.getQuantidadeCompra());
			ptst.setLong(7, value.getTipo().getId());
			ptst.setLong(8, value.getIdCesta());
			
			// verificando se houve linhas alteradas.
			int affectedRows = ptst.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Nenhuma linha modificada, falha na inserção.");
			}
			
			// verificando se foi gerado um ID.
			ResultSet generatedKey = ptst.getGeneratedKeys();
			if (generatedKey.next()) {
				value.setId(generatedKey.getLong(1));
			} else {
				throw new SQLException("Nenhum ID retornado, falha na inserção.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(ItemVO value) throws SQLException {
		String sql = "delete from item where id = ?";
		PreparedStatement psts;
		
		try {
			
			psts = getConnection().prepareStatement(sql);
			psts.setLong(1, value.getId());
			psts.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(ItemVO value) throws SQLException {
		String sql = "update item set nome = ?, marca = ?, codigoDeBarras = ?, quantidadeEmEstoque = ?,"
				+ " preco = ?, quantidadeCompra = ?, id_tipo = ?, id_cesta = ? where id= ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, value.getNome());	
			ptst.setString(2, value.getMarca());
			ptst.setString(3, value.getCodigoDeBarras());
			ptst.setLong(4, value.getQuantidadeEmEstoque());
			ptst.setDouble(5, value.getPreco());
			ptst.setLong(6, value.getQuantidadeCompra());
			ptst.setLong(7, value.getTipo().getId());
			ptst.setLong(8, value.getIdCesta());
			ptst.setLong(9, value.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listar() throws SQLException {
		String sql = "select * from item";
		Statement st;
		ResultSet rs = null;
				
 		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet listarPorId(long value) throws SQLException {
		String sql = "select * from item where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, value);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	};
	
	
	public ResultSet listarPorNome(String value) throws SQLException {
		String sql = "select * from item where nome = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, value);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	};
	
	public ResultSet listarPorMarca(String value) throws SQLException {
		String sql = "select * from item where marca = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, value);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	};
	
	public ResultSet listarPorCodigoDeBarras(String value) throws SQLException {
		String sql = "select * from item where codigoDeBarras = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, value);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	};
	
	// verificar itens que compoem uma mesma cesta
	public ResultSet listarPorIdCesta(long value) throws SQLException {
		String sql = "select * from item where id_cesta = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
				
 		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, value);
			rs = ptst.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	};

	
}
