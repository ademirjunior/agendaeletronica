package br.com.timetec.agendaeletronica.contato;

public enum EstadoCivil {

	SOLTEIRO("Solteiro"), 
	CASADO("Casado"), 
	DIVORCIADO("Divorciado"), 
	VIUVO("Viúvo");

	private final String Label;

	private EstadoCivil(String label) {
		Label = label;
	}

	public String getLabel() {
		return Label;
	}

}
