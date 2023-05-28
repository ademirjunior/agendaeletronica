package br.com.timetec.agendaeletronica;

import java.sql.Connection;

import org.apache.wicket.markup.html.basic.Label;

import br.com.timetec.agendaeletronica.contato.Contato;
import br.com.timetec.agendaeletronica.contato.ContatoDAO;

public class Editar extends Criar {

	private static final long serialVersionUID = -3551164932280044084L;
	
	public Editar(Contato contato) {
		super(contato);
		replace(new Label("titulo", "Edição contato"));
	}

	@Override
	protected void salvar(Contato contatoSubmetido) {
		Connection conexao = ((WicketApplication) getApplication()).getConexao();
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.atualizar(contatoSubmetido);
	}
}
