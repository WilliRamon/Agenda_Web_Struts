package br.com.agendaweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.agendaweb.vo.Pessoa;
import br.com.cadastrarpessoa.factory.ConnectionFactory;

public class PessoaDao {

	public ArrayList<Pessoa> buscaListaPessoas() {
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM tb_ficha							");
		query.append("	INNER JOIN TB_CODIGO							");
		query.append("		ON TB_FICHA.COD_SEXO = TB_CODIGO.COD_ORDEM	");
		query.append("	ORDER BY TB_FICHA.ID							");
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(query.toString());
			
			rset = pstm.executeQuery(); 
			
			while(rset.next()) {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(rset.getLong("id"));
				pessoa.setNome(rset.getString("nome"));
				pessoa.setIdade(rset.getInt("idade"));
				pessoa.setSexo(rset.getString("tb_codigo.cod_descricao"));
				pessoa.setDataCadastro(rset.getDate("dataCadastro"));
				
				listaPessoas.add(pessoa);
			
			}
			
			return listaPessoas;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	public void cadastrarPessoa(Pessoa pessoa) {
		
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO TB_FICHA 					");
		query.append("	(nome, idade, cod_sexo, dataCadastro) 	");
		query.append("VALUES (?, ?, ?, ?)					");
		
		String sql = query.toString();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(3, pessoa.getSexo());
			pstm.setDate(4, new Date(pessoa.getDataCadastro().getTime()));
			
			pstm.execute();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstm!=null){
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
