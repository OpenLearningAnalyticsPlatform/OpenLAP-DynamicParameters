package de.rwthaachen.openlap.dynamicparam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenLAPDynamicParam<T> {

    private final OpenLAPDynamicParamType type;
    private final OpenLAPDynamicParamDataType dataType;
    private String id;
    private String title;
    private String description;
    private String possibleValues;
    private T defaultValue;
    private T value;
    private boolean required;

    public OpenLAPDynamicParam() {
        this.type = null;
        this.dataType = null;
    }

    /**
     * @param type
     * @param dataType
     * @param id
     * @param title
     * @param description
     * @param defaultValue
     * @param possibleValues semicolon separated values
     * @param required
     */
    public OpenLAPDynamicParam(OpenLAPDynamicParamType type, OpenLAPDynamicParamDataType dataType, String id, String title, String description, T defaultValue, String possibleValues, boolean required) {
        this.type = type;
        this.dataType = dataType;
        this.id = id;
        this.title = title;
        this.description = description;
        this.defaultValue = defaultValue;
        this.possibleValues = possibleValues;
        this.required = required;
    }

    public OpenLAPDynamicParamType getType() {
        return type;
    }

    public OpenLAPDynamicParamDataType getDataType() {
        return dataType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPossibleValues() {
        return possibleValues;
    }

    public void setPossibleValues(String possibleValues) {
        this.possibleValues = possibleValues;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean validateDynamicParam(OpenLAPDynamicParam openLAPDynamicParam) {
        return openLAPDynamicParam.getType().equals(this.getType())
                && (openLAPDynamicParam.getId().equals(this.getId()));
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "OpenLAPDynamicParam{" +
                    "type=" + type +
                    ", dataType=" + dataType +
                    ", id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", possibleValues='" + possibleValues + '\'' +
                    ", defaultValue=" + defaultValue +
                    ", value=" + value +
                    ", required=" + required +
                    '}';
        }
    }
}
