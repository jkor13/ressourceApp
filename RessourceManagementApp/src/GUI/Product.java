package GUI;

/**
 * Created by rico on 21.07.15.
 *
 * EDITED BY MARTIN
 *
 *
 */
public class Product {

    private String aID;
    private String aName;
    private String aTyp;
    private String category;
    private String brandname;
    private float netweight;
    private float grossweight;
    private String dimensions;
    private String mfac_name;
    private String mfac_adress;
    private String smarks;
    private String hazardinfo;
    private String name;
    private String adress;
    private String city;
    private String country;
    private String materiallist;
    private String quantitieslist;
    private String pnperpart;
    private String renewablelist;
    private String energysource;
    private String netenergyused;
    private String netenergyconsumed;
    private String recommandation;

    public String getaID() {
        return aID;
    }

    public void setaID(String aID) {
        this.aID = aID;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaTyp() {
        return aTyp;
    }

    public void setaTyp(String aTyp) {
        this.aTyp = aTyp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public float getNetweight() {
        return netweight;
    }

    public void setNetweight(float netweight) {
        this.netweight = netweight;
    }

    public float getGrossweight() {
        return grossweight;
    }

    public void setGrossweight(float grossweight) {
        this.grossweight = grossweight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getSmarks() {
        return smarks;
    }

    public void setSmarks(String smarks) {
        this.smarks = smarks;
    }

    public String getHazardinfo() {
        return hazardinfo;
    }

    public void setHazardinfo(String hazardinfo) {
        this.hazardinfo = hazardinfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public String getMateriallist() {
        return materiallist;
    }

    public void setMateriallist(String materiallist) {
        this.materiallist = materiallist;
    }

    public String getQuantitieslist() {
        return quantitieslist;
    }

    public void setQuantitieslist(String quantitieslist) {
        this.quantitieslist = quantitieslist;
    }

    public String getPnperpart() {
        return pnperpart;
    }

    public void setPnperpart(String pnperpart) {
        this.pnperpart = pnperpart;
    }

    public String getRenewablelist() {
        return renewablelist;
    }

    public void setRenewablelist(String renewablelist) {
        this.renewablelist = renewablelist;
    }

    public String getEnergysource() {
        return energysource;
    }

    public void setEnergysource(String energysource) {
        this.energysource = energysource;
    }

    public String getNetenergyused() {
        return netenergyused;
    }

    public void setNetenergyused(String netenergyused) {
        this.netenergyused = netenergyused;
    }

    public String getNetenergyconsumed() {
        return netenergyconsumed;
    }

    public void setNetenergyconsumed(String netenergyconsumed) {
        this.netenergyconsumed = netenergyconsumed;
    }

    public String getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(String recommandation) {
        this.recommandation = recommandation;
    }

    public Product() {
        category = new String();
        aName = new String();
        aTyp = new String();
        brandname = new String();
        netweight = 0;
        grossweight = 0;
        dimensions = new String();
        smarks = new String();
        hazardinfo = new String();
        name = new String();
        adress = new String();
        city = new String();
        country = new String();
        materiallist = new String();
        quantitieslist = new String();
        pnperpart = new String();
        renewablelist = new String();
        energysource = new String();
        netenergyused = new String();
        netenergyconsumed = new String();
        recommandation = new String();
    }


    public String getMfac_name() {
        return mfac_name;
    }

    public void setMfac_name(String mfac_name) {
        this.mfac_name = mfac_name;
    }

    public String getMfac_adress() {
        return mfac_adress;
    }

    public void setMfac_adress(String mfac_adress) {
        this.mfac_adress = mfac_adress;
    }
}
