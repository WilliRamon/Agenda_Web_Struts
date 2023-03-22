package br.com.agendaweb.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.agendaweb.form.PessoaForm;
import br.com.agendaweb.service.PessoaService;
import br.com.agendaweb.vo.Pessoa;

public class PessoaAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PessoaForm frm = (PessoaForm) form;
		PessoaService service = new PessoaService();
		Pessoa pessoa = new Pessoa();
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		
		if(frm.getAcao().equalsIgnoreCase("INSERIR")){
			service.cadastrarPessoa(frm);
		}
		if(frm.getAcao().equalsIgnoreCase("ALTERAR")){
			System.out.println("oi");
		}
		
		
		frm.setAcao("");
		listaPessoas = service.buscaListaPessoas();
		request.setAttribute("listaPessoas", listaPessoas);
		//Montar a estrutura da Tabela 
		
		ActionForward fw = mapping.getInputForward();
		fw = mapping.findForward("success");
		return fw;
	}
}
