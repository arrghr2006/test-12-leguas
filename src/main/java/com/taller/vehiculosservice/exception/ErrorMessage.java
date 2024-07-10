package com.taller.vehiculosservice.exception;

public class ErrorMessage {
    public static final String DUPLICATED_VEHICLE = "La matrícula o el vin especificado ya están asociados a otro vehículo.";
    public static final String INTEGRITY_VIOLATION = "Book code not exist in our book catalog";
    public static final String VEHICLE_NOT_FOUND = "Vehículo no encontrado";
    public static final String VALIDATION_PARAMS = "Parámetros no válidos";
    public static final String INTERNAL_ERROR = "Error interno en la operación";
    public static final String RECONVERSION_ERROR = "Debe especificar el tipo de combustible después de la reconversión;";
    public static final String RECONVERSION_NO_PERMITIDA = "Solo se permiten reconversiones de Eléctricos a Gasolina.";

    private ErrorMessage(){
        throw new IllegalStateException("Utility class");
    }
}
