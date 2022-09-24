package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumDashboardBoxes {

    PLAYER_MANAGEMENT("/user/player/admin");

    private final String field;

    @Override
    public String toString() {
        return field;
    }
}
