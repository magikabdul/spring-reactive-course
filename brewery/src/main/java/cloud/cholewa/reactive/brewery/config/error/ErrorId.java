package cloud.cholewa.reactive.brewery.config.error;

public interface ErrorId {

    String getCode();

    String getDescription();

    default int getHttpCode() {
        return Integer.parseInt(getCode().substring(0, 3));
    }
}
