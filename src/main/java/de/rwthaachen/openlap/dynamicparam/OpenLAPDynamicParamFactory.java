package de.rwthaachen.openlap.dynamicparam;

import de.rwthaachen.openlap.exceptions.OpenLAPDynamicParamException;

public class OpenLAPDynamicParamFactory {
    public static final OpenLAPDynamicParam createOpenLAPDataColumnOfType(String id, OpenLAPDynamicParamType type, OpenLAPDynamicParamDataType dataType, String title, String description, Object defaultValue, String possibleValues, boolean required)
            throws OpenLAPDynamicParamException {
        switch (dataType)
        {
            case STRING:
                return new OpenLAPDynamicParam<String>(type, dataType, id, title, description, (String)defaultValue, possibleValues, required);
            case INTEGER:
                return new OpenLAPDynamicParam<Integer>(type, dataType, id, title, description, (Integer)defaultValue, possibleValues, required);
            case FLOAT:
                return new OpenLAPDynamicParam<Float>(type, dataType, id, title, description, (Float)defaultValue, possibleValues, required);
            default:
                throw new OpenLAPDynamicParamException("Data type not supported");
        }
    }
}
