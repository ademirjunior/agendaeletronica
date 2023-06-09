package br.com.timetec.agendaeletronica;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class Login extends WebPage {

	private static final long serialVersionUID = 6442842711043524545L;

	public Login() {
		final TextField<String> campoNomeUsuario = new TextField<String>("nomeUsuario", new Model<String>());
		final PasswordTextField campoPassword = new PasswordTextField("password", new Model<String>());
		
		final Label mensagemErroLogin = new Label("mensagemErroLogin",Model.of("Erro ao realizar login!"));
		mensagemErroLogin.setOutputMarkupId(true).setVisible(false);
		
		Form<String> formularioLogin = new Form<String>("formularioLogin") {

			private static final long serialVersionUID = 1L;
			
			@Override
			public final void onSubmit() {
				String nomeUsuario = campoNomeUsuario.getModelObject();
				String senha = campoPassword.getModelObject();
				if(nomeUsuario.equals("ademir") && senha.equals("1234")) {
					getSession().setAttribute("userName", nomeUsuario);
					setResponsePage(Inicio.class);
				} else {
					mensagemErroLogin.setVisible(true);
				}
			}
		};
		
		add(mensagemErroLogin, formularioLogin);
		formularioLogin.add(campoNomeUsuario, campoPassword);
	}

}
