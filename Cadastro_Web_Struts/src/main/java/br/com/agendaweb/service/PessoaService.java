package br.com.agendaweb.service;

import java.util.ArrayList;
import java.util.Date;

import br.com.agendaweb.dao.PessoaDao;
import br.com.agendaweb.form.PessoaForm;
import br.com.agendaweb.vo.Pessoa;

public class PessoaService {

	public ArrayList<Pessoa> buscaListaPessoas() {
		
		PessoaDao dao = new PessoaDao();
		
		return dao.buscaListaPessoas();
	}

	public void cadastrarPessoa(PessoaForm frm) {
		
		Pessoa pessoa = new Pessoa();
		PessoaDao dao = new PessoaDao();
		
		pessoa.setNome(frm.getNome());
		pessoa.setIdade(frm.getIdade());
		pessoa.setSexo(frm.getSexo());
		pessoa.setDataCadastro(new Date());
		
		dao.cadastrarPessoa(pessoa);
	}

}
