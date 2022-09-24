package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumTableRowsName {
    USERNAME("username");

    private final String item;

    @Override
    public String toString() {
        return item;
    }
}
