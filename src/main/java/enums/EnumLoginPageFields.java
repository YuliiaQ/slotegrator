package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumLoginPageFields {
    LOGIN("UserLogin_username"),
    PASSWORD("UserLogin_password");

    private final String field;

    @Override
    public String toString() {
        return field;
    }
}
