package ua.crm.novaposhta;

/**
 * Created by Oleg on 25.08.2016.
 */
public class NPRequest<T> {
    private String apiKey;
    private String modelName;
    private String calledMethod;
    private T methodProperties;

    public NPRequest() {
    }

    public NPRequest(String apiKey, String modelName, String calledMethod, T methodProperties) {
        this.apiKey = apiKey;
        this.modelName = modelName;
        this.calledMethod = calledMethod;
        this.methodProperties = methodProperties;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCalledMethod() {
        return calledMethod;
    }

    public void setCalledMethod(String calledMethod) {
        this.calledMethod = calledMethod;
    }

    public T getMethodProperties() {
        return methodProperties;
    }

    public void setMethodProperties(T methodProperties) {
        this.methodProperties = methodProperties;
    }

    @Override
    public String toString() {
        return "NPRequest{" +
                "apiKey='" + apiKey + '\'' +
                ", modelName='" + modelName + '\'' +
                ", calledMethod='" + calledMethod + '\'' +
                ", methodProperties=" + methodProperties +
                '}';
    }
}
