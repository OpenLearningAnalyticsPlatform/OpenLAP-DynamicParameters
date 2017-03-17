package de.rwthaachen.openlap.dynamicparam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenLAPDynamicParam {

    private final OpenLAPDynamicParamType type;
    private String id;
    private String title;
    private String description;
    private String defaultValue;
    private String possibleValues;
    private boolean required;

    public OpenLAPDynamicParam() {
        this.type = null;
    }

    public OpenLAPDynamicParam(OpenLAPDynamicParamType type, String id, String title, String description, String defaultValue, String possibleValues, boolean required) {
        this.type = type;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean validateDynamicParam(OpenLAPDynamicParam openLAPDynamicParam) {
        return openLAPDynamicParam.getType().equals(this.getType())
                && (openLAPDynamicParam.getId().equals(this.getId()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenLAPDynamicParam)) return false;

        OpenLAPDynamicParam that = (OpenLAPDynamicParam) o;

        if (isRequired() != that.isRequired()) return false;
        if (getType() != that.getType()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
        return possibleValues != null ? possibleValues.equals(that.possibleValues) : that.possibleValues == null;

    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
        result = 31 * result + (possibleValues != null ? possibleValues.hashCode() : 0);
        result = 31 * result + (isRequired() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "OpenLAPDynamicParam{" +
                    "type=" + type +
                    ", id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", defaultValue='" + defaultValue + '\'' +
                    ", possibleValues='" + possibleValues + '\'' +
                    ", required=" + required +
                    '}';
        }
    }
}
