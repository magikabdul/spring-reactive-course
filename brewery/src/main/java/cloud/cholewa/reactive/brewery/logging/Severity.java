package cloud.cholewa.reactive.brewery.logging;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Severity {

    CRITICAL("Critical"),
    MAJOR("Major"),
    MINOR("Minor");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
