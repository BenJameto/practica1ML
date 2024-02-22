// Interfaz Sujeto
public interface Sujeto {
    void registrar(Observador observador);
    void remover(Observador observador);  
    void notificar();
}
