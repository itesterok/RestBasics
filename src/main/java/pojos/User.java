package pojos;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public final class User {
  private Address address;
  private Company company;
  private int id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address addressObject) {
    this.address = addressObject;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company companyObject) {
    this.company = companyObject;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
    return getId()
        + 36484859
            * (getName() + getUsername() + getEmail() + getPhone() + getWebsite()).hashCode();
  }

  /** Company data model. */
  public static final class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getCatchPhrase() {
      return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
      this.catchPhrase = catchPhrase;
    }

    public String getBs() {
      return bs;
    }

    public void setBs(String bs) {
      this.bs = bs;
    }

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
      return 366674 * (getBs() + getCatchPhrase() + getName()).hashCode();
    }
  }

  /** Address data model. */
  public static final class Address {
    Geo GeoObject;
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public String getSuite() {
      return suite;
    }

    public void setSuite(String suite) {
      this.suite = suite;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getZipcode() {
      return zipcode;
    }

    public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
    }

    public Geo getGeo() {
      return GeoObject;
    }

    public void setGeo(Geo geoObject) {
      this.GeoObject = geoObject;
    }

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
      return 34234 * (getCity() + getStreet() + getSuite() + getZipcode()).hashCode();
    }

    /** GEO data model. */
    public static final class Geo {
      private String lat;
      private String lng;

      public String getLat() {
        return lat;
      }

      public void setLat(String lat) {
        this.lat = lat;
      }

      public String getLng() {
        return lng;
      }

      public void setLng(String lng) {
        this.lng = lng;
      }

      @Override
      public String toString() {
        return ToStringBuilder.reflectionToString(this);
      }

      @Override
      public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
      }

      @Override
      public int hashCode() {
        return 34234 * getLat().hashCode() + 56765 * getLng().hashCode();
      }
    }
  }
}
