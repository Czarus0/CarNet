package pl.czarek.carnet.business.domain;

import pl.czarek.carnet.contraints.ExistsInCarDealerRepo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CarDealerPost {
    @Size(min = 2, max = 50, message = "Nazwa firmy musi zawierać od 2 do 50 znaków")
    @ExistsInCarDealerRepo(message = "Salon o takiej nazwie już istnieje")
    private String nameOfFirm;
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{3}", message = "Podany telefon musi mieć wzór XXX-XXX-XXX")
    private String phoneNumber;
    @Pattern(regexp = "[1-9]|[1-9][0-9]", message = "Godzina może być w przedziale 1-24")
    private String openFrom;
    @Pattern(regexp = "[1-9][0-9]?", message = "Godzina może być w przedziale 1-24")
    private String openTo;
    private String carDealerImage;
    @Size(min = 2, max = 50, message = "Ulica musi zawierać od 2 do 50 znaków")
    private String street;
    @Pattern(regexp = "[1-9][0-9]{0,2}[A-Z]?", message = "Numer domu może zawierać 3 cyfry i jedną literę na końcu")
    private String numberHome;
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Kod pocztowy musi być wzoru XX-XXX")
    private String postCode;
    @Size(min = 2, max = 50, message = "Miasto musi zawierać od 2 do 50 znaków")
    private String city;
    @Size(min = 2, max = 50, message = "Państwo musi zawierać od 2 do 30 znaków")
    private String country;
    private boolean hasPhoneNumber;

    public String getNameOfFirm() {
        return nameOfFirm;
    }

    public void setNameOfFirm(String nameOfFirm) {
        this.nameOfFirm = nameOfFirm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(String openFrom) {
        this.openFrom = openFrom;
    }

    public String getOpenTo() {
        return openTo;
    }

    public void setOpenTo(String openTo) {
        this.openTo = openTo;
    }

    public String getCarDealerImage() {
        return carDealerImage;
    }

    public void setCarDealerImage(String carDealerImage) {
        this.carDealerImage = carDealerImage;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isHasPhoneNumber() {
        return hasPhoneNumber;
    }

    public void setHasPhoneNumber(boolean hasPhoneNumber) {
        this.hasPhoneNumber = hasPhoneNumber;
    }
}
