/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sakila;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bas200181
 */
@Entity
@Table(name = "city_full_info")
@NamedQueries({
    @NamedQuery(name = "CityFullInfo.findAll", query = "SELECT c FROM CityFullInfo c"),
    @NamedQuery(name = "CityFullInfo.findByCityId", query = "SELECT c FROM CityFullInfo c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "CityFullInfo.findByCity", query = "SELECT c FROM CityFullInfo c WHERE c.city = :city"),
    @NamedQuery(name = "CityFullInfo.findByCountryId", query = "SELECT c FROM CityFullInfo c WHERE c.countryId = :countryId"),
    @NamedQuery(name = "CityFullInfo.findByLastUpdate", query = "SELECT c FROM CityFullInfo c WHERE c.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "CityFullInfo.findByCountry", query = "SELECT c FROM CityFullInfo c WHERE c.country = :country"),
    @NamedQuery(name = "CityFullInfo.findByCountryLastUpdate", query = "SELECT c FROM CityFullInfo c WHERE c.countryLastUpdate = :countryLastUpdate")})
public class CityFullInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "city_id")
    private short cityId;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "country_id")
    private short countryId;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "country_last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date countryLastUpdate;

    public CityFullInfo() {
    }

    public short getCityId() {
        return cityId;
    }

    public void setCityId(short cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public short getCountryId() {
        return countryId;
    }

    public void setCountryId(short countryId) {
        this.countryId = countryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCountryLastUpdate() {
        return countryLastUpdate;
    }

    public void setCountryLastUpdate(Date countryLastUpdate) {
        this.countryLastUpdate = countryLastUpdate;
    }
    
}
