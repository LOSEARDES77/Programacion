package com.example;

public interface TransportaPasajeros {
    boolean subirPasajero(Persona p);
    boolean bajarPersona(Persona p);
    Persona[] getEstadoOcupacion();
    int getNumActualPasajeros();
    int getNumMaximoPasajeros();
    int getNumPlazasLibres();
}
