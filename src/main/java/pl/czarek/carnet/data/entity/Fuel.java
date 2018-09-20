package pl.czarek.carnet.data.entity;

public enum Fuel {
    GAS("LPG"),
    PETROL("Benzyna"),
    OIL("Ropa");

    String typeOfFuel;

    Fuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public static Fuel[] getFuels() {
        return values();
    }
}
