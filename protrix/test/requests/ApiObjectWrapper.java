package requests;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("all")
public class ApiObjectWrapper {

    private LinkedTreeMap object;

    public ApiObjectWrapper() {
        this.object = new LinkedTreeMap();
    }

    public ApiObjectWrapper(String object) {
        this.object = (LinkedTreeMap) new Gson().fromJson(object, Object.class);
    }

    public ApiObjectWrapper(Object object) {
        this.object = (LinkedTreeMap) object;
    }

    public ApiObjectWrapper get(String field) {
        if(notExist(field)) return null;
        return new ApiObjectWrapper(object.get(field));
    }

    public String getAsString(String field) {
        if(notExist(field)) return null;
        return String.valueOf(object.get(field));
    }

    public Integer getAsInt(String field) {
        if(notExist(field)) return null;
        return (int) getAsDouble(field).doubleValue();
    }

    public Double getAsDouble(String field) {
        if(notExist(field)) return null;
        return Double.parseDouble(getAsString(field));
    }

    public Long getAsLong(String field) {
        if(notExist(field)) return null;
        return (long) getAsFloat(field).longValue();
    }

    public Float getAsFloat(String field) {
        if(notExist(field)) return null;
        return Float.parseFloat(getAsString(field));
    }

    public List<ApiObjectWrapper> getAsList(String field) {

        if(notExist(field)) return new ArrayList<>();

        if(!object.get(field).getClass().equals(ArrayList.class)) return new ArrayList<>();

        return ((ArrayList<Object>) object.get(field)).stream().map(ApiObjectWrapper::new).collect(Collectors.toList());
    }

    public Boolean getAsBoolean(String field) {

        if(notExist(field)) return null;

        return Boolean.parseBoolean(getAsString(field));
    }

    public Instant getAsInstant(String field) {

        if(notExist(field)) return null;

        return Instant.parse(getAsString(field));
    }

    public List<Double> getAsDoubleList(String field) {

        if(notExist(field)) return new ArrayList<>();

        return (ArrayList) object.get(field);
    }

    public void set(String field, Object value) {
        object.put(field, value);
    }

    public boolean exist(String field) {
        if(object == null) return false;
        return object.get(field) != null;
    }

    public boolean notExist(String field) {
        return !exist(field);
    }

    @Override
    public String toString() {
        return new Gson().toJson(object);
    }
}