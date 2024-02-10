package org.practica4.interfaces;

/**
 * Interfaz Relacionable, donde se establece el contrato que debe cumplir toda clase relacionable con otra
 */
public interface Relacionable {
	public boolean esMenorQue(Relacionable r);
	public boolean esIgualQue(Relacionable r);
	public boolean esMayorQue(Relacionable r);
}
