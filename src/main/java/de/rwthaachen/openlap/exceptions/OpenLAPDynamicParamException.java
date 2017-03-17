package de.rwthaachen.openlap.exceptions;

public class OpenLAPDynamicParamException extends Exception {
    public static final String PARAM_ALREADY_EXISTS = "Parameter already exists";

    public OpenLAPDynamicParamException(String errorMessage, String paramId) {
        super(errorMessage +": " + paramId);
    }

    public OpenLAPDynamicParamException(String errorMessage) {
        super(errorMessage);
    }
}
