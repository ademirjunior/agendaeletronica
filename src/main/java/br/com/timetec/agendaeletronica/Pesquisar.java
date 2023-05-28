package br.com.timetec.agendaeletronica;


import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import br.com.timetec.agendaeletronica.contato.Contato;

public class Pesquisar extends BasePage {

	private static final long serialVersionUID = -1757976258526671212L;

	public Pesquisar() {
		Form<String> formularioPesquisa = new Form<String>("formularioPesquisa");
		add(formularioPesquisa);
		
		TextField<String> pesquisaNome = new TextField<String>("pesquisaNome", new Model<String>());
		formularioPesquisa.add(pesquisaNome);
		
		final WebMarkupContainer containerResultados = new  WebMarkupContainer("divResultados");
		containerResultados.setVisible(false);
		containerResultados.setOutputMarkupPlaceholderTag(true);
		add(containerResultados);
		
		PropertyListView<Contato> listaResultados = new PropertyListView<Contato>("contatos", new ListModel<Contato>()) {

			private static final long serialVersionUID = -7981833775145119443L;

			@Override
			protected void populateItem(final ListItem<Contato> item) {
				item.add(new Label("nome"));
				item.add(new Label("email"));
				item.add(new Label("telefone"));
				item.add(new Label("estadoCivil"));
				item.add(new Link<Void>("linkEditar") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						setResponsePage(new Editar(item.getModelObject()));
						
					}
				});
			}
		};
		
		containerResultados.add(listaResultados);
		
		AjaxButton botaoPesquisar = new AjaxButton("botaoPesquisar", formularioPesquisa) {
			
			private static final long serialVersionUID = -3954005241443849476L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				containerResultados.setVisible(true);
				target.add(containerResultados);
			}
		};
		
		formularioPesquisa.add(botaoPesquisar);
	}

}
