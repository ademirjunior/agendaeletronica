package br.com.timetec.agendaeletronica;

import java.sql.Connection;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import br.com.timetec.agendaeletronica.contato.Contato;
import br.com.timetec.agendaeletronica.contato.ContatoDAO;

public class Criar extends BasePage {

	private static final long serialVersionUID = -1757976258526671212L;

	public Criar() {
		add(new Label("titulo", "Criação de contato!"));
		
		Contato contato = new Contato();
		CompoundPropertyModel<Contato> compoundPropertyModelContato = new CompoundPropertyModel<Contato>(contato);
		
		Form<Contato> form = new Form<Contato>("formularioContato", compoundPropertyModelContato) {

			private static final long serialVersionUID = 8743536682783204589L;
			
			@Override
			public void onSubmit() {
				Contato contatoSubmetido = getModelObject();
				salvar(contatoSubmetido);
				setResponsePage(Inicio.class);
			}

		};
		
		add(form);
		
		TextField<String> inputNome = new TextField<String>("nome");
		TextField<String> inputEmail = new TextField<String>("email");
		TextField<String> inputTelefone = new TextField<String>("telefone");
		form.add(inputNome, inputEmail, inputTelefone);
	}
	
	private void salvar(Contato contatoSubmetido) {
		Connection conexao = ((WicketApplication) getApplication()).getConexao();
		ContatoDAO dao = new ContatoDAO(conexao);
		dao.inserir(contatoSubmetido);
	}

}
