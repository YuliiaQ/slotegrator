package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumNavbarItems {
    DASHBOARD("Dashboard");

    private final String item;

    @Override
    public String toString() {
        return item;
    }
}
