package br.com.timetec.agendaeletronica;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class BasePage extends WebPage {

	private static final long serialVersionUID = -5756975939139547703L;

	public BasePage() {
		String userName = (String) getSession().getAttribute("userName");
		if (userName == null) {
			setResponsePage(Login.class);
			return;
		}
		
		add(new Link<Void>("sair") {

			private static final long serialVersionUID = -948309763654742799L;

			@Override
			public void onClick() {
				getSession().invalidate();
				setResponsePage(Inicio.class);
			}
		});
		
		
	}
}
